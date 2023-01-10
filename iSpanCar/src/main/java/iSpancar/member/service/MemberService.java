package iSpancar.member.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iSpancar.member.dao.MemberDao;
import iSpancar.member.model.MemberBean;
import iSpancar.member.model.MemberPosition;
import iSpancar.member.model.PermissionsOfPosition;

@Service
@Transactional
public class MemberService {

	@Autowired
	@Qualifier("mDao")
	private MemberDao mDao;
	
	
	public MemberService() {
	}
	
	//用帳號找資料
	public List<MemberBean> findbyaccountnumber(String accountnumber) throws SQLException{
		
		List<MemberBean> list =  mDao.findbyaccountnumber(accountnumber);
			
		return list;
	}
	
	//圖
	public MemberBean findImgbyaccountnumber(String accountnumber) throws SQLException {
		MemberBean mBean =  mDao.findImgbyaccountnumber(accountnumber);
		
		return mBean;
	}
	
	//用帳號找資料不含圖
	public MemberBean findbyaccountnumberwithoutimage(String accountnumber) throws SQLException {
		MemberBean mBean = null;
		
		mBean = mDao.findbyaccountnumberwithoutimage(accountnumber);
		
		return mBean;
	}
	
	//放入資料庫
	public void insertMemberBean(MemberBean bean) throws SQLException, ParseException {
		
			mDao.insertMemberBean(bean);
			
	}

	//用帳號刪除資料
	public void deleteByAccountnumber(String accountnumber) throws SQLException {
		
			mDao.deleteByAccountnumber(accountnumber);
	}
	
	//用帳號修改
	public void updateByAccountnumber(MemberBean mb) throws SQLException, ParseException {
		
			mDao.updateByAccountnumber(mb);
	}
	
	//確認有無帳號
	public boolean checkaccountnumber(String accountnumber) throws SQLException {
		
			boolean check = mDao.checkaccountnumber(accountnumber);
		
			return check;
	}
	
	//確認帳密
	public String checkaccountnumberpassword(String accountnumber,String password) throws SQLException {

			String checkString = mDao.checkaccountnumberpassword(accountnumber, password);
			
			return checkString;
	}
	
	//修改圖片
	public void updateImgByAccount(String accountnumber,Blob personalimg) throws SQLException {
		
			mDao.updateImgByAccount(accountnumber, personalimg);
	}
	
	//查詢全部
	public List<MemberBean> selectAll() throws SQLException{
		
			List<MemberBean> list = mDao.selectAll();
			
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
