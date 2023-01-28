package iSpancar.member.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iSpancar.member.dao.MemberDao;
import iSpancar.member.dao.MemberRepository;
import iSpancar.member.dao.PermissionsRepository;
import iSpancar.member.model.MemberBean;
import iSpancar.member.model.MemberPosition;
import iSpancar.member.model.PermissionsOfPosition;

@Service
@Transactional
public class MemberService {

	@Autowired
	@Qualifier("mDao")
	private MemberDao mDao;
	
	@Autowired
	private MemberRepository mRepository;
	
	@Autowired
	private PermissionsRepository pRepository;
	
	public MemberService() {
	}
	
	//員工權限
	public List<PermissionsOfPosition> findAllPermissions(){
		List<PermissionsOfPosition> list = pRepository.findAll();
		return list;
	}
	
	public void updatePermission(PermissionsOfPosition pop) {
		pRepository.save(pop);
	}
	
	
	//用帳號找資料
	public List<MemberBean> findbyaccountnumber(String accountnumber) throws SQLException{
		
		Optional<MemberBean> op =  mRepository.findById(accountnumber);
		MemberBean memberBean = null;
		if(op.isPresent()) {//Optional非空值
			 memberBean = op.get();
		}
		List<MemberBean> list = new ArrayList<MemberBean>();
		list.add(memberBean);
		
		return list;
	}
	
	//用帳號找資料回傳Bean
	public MemberBean findByAccountReturnBean(String accountnumber) throws SQLException {
		Optional<MemberBean> op =  mRepository.findById(accountnumber);
		MemberBean memberBean = null;
		if(op.isPresent()) {//Optional非空值
			memberBean = op.get();
		}
		//mBean = mDao.findbyaccountnumberwithoutimage(accountnumber);
		
		return memberBean;
	}
	
	//圖
	public MemberBean findImgbyaccountnumber(String accountnumber) throws SQLException {
		Optional<MemberBean> op =  mRepository.findById(accountnumber);
		MemberBean memberBean = null;
		if(op.isPresent()) {//Optional非空值
			memberBean = op.get();
		}
		return memberBean;
	}
	
	//放入資料庫
	public void insertMemberBean(MemberBean bean) throws SQLException, ParseException {
		
		MemberPosition position = new MemberPosition();
		position.setMemberBean(bean);
		PermissionsOfPosition employee = new PermissionsOfPosition();
		employee.setPositionPk("employee");
		position.setPermissionsofposition(employee);
		
		mRepository.save(bean);
		
		mRepository.insertMemberPosition(bean.getAccountnumber(), "employee");
			
	}
	//user資料
	public void insertForUser(MemberBean bean) throws SQLException, ParseException {
		
		MemberPosition position = new MemberPosition();
		position.setMemberBean(bean);
		PermissionsOfPosition user = new PermissionsOfPosition();
		user.setPositionPk("user");
		position.setPermissionsofposition(user);
		
		mRepository.save(bean);
		
		mRepository.insertMemberPosition(bean.getAccountnumber(), "user");
		
	}
	//用帳號刪除資料
	public void deleteByAccountnumber(String accountnumber) throws SQLException {

		mRepository.deleteMemberPosition(accountnumber);
		mRepository.deleteById(accountnumber);
	}
	
	//用帳號修改不含圖
	public MemberBean updateByAccountnumber(MemberBean mb) throws SQLException, ParseException {
		Optional<MemberBean> op = mRepository.findById(mb.getAccountnumber());
		MemberBean memberBean = null;
		if(op.isPresent()) {//Optional非空值
			 memberBean = op.get();
		}
		mb.setFile(memberBean.getFile());
		return mRepository.save(mb);
	}
	
	//確認有無帳號
	public boolean checkaccountnumber(String accountnumber) throws SQLException {
		
			boolean check = mDao.checkaccountnumber(accountnumber);
		
			return check;
	}
	
	//確認帳密
	public String checkaccountnumberpassword(String accountnumber,String password) throws SQLException {

//			String checkString = mDao.checkaccountnumberpassword(accountnumber, password);
			Optional<MemberBean> op = mRepository.findById(accountnumber);
			if(op.isPresent()) {
			MemberBean mBean = op.get();
				boolean matches = new BCryptPasswordEncoder().matches(password,mBean.getMemberpassword());//密碼核對
				String check;
				if(matches) {
					check = "資料正確";
				}else {
					check = "資料有誤";
				}
				return check;
			}
			return "資料有誤";
	}
	
	//修改圖片
	public void updateImgByAccount(String accountnumber,Blob personalimg) throws SQLException {
		
			//mDao.updateImgByAccount(accountnumber, personalimg);
		Optional<MemberBean> op = mRepository.findById(accountnumber);
		MemberBean memberBean = null;
		if(op.isPresent()) {//Optional非空值
			 memberBean = op.get();
			 memberBean.setFile(personalimg);
		}
		mRepository.saveAndFlush(memberBean);
		
	}
	
	//查詢全部
	public List<MemberBean> findAll() throws SQLException{
		
			List<MemberBean> list = mRepository.findAll();
			
			return list;
	}
	
	//取得職位
		public String getEmployeePosition() {
			
			String employee = mDao.getEmployeePosition();
			return employee;
			
		}
	
	
	//inputstream ->blob
	public Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}
	
	//取得檔名
		public String getFileName(Part part) {
			String fileName = mDao.getFileName(part);
			return fileName;
		}

}
