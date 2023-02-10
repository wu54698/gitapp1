package iSpancar.member.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import iSpancar.member.model.MemberBean;
import iSpancar.member.model.MemberPosition;
import iSpancar.member.model.PermissionsOfPosition;

@Repository(value = "mDao")
@Transactional
public class MemberDao {

	@Autowired
	private SessionFactory factory;
	
	public MemberDao() {
	}
	
	public java.sql.Date stringToSqlDate(String string) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date udate = df.parse(string);
		java.sql.Date sdate = new java.sql.Date(udate.getTime());
		return sdate;
	}
	
	//用帳號找資料
	public List<MemberBean> findbyaccountnumber(String accountnumber) throws SQLException{
		Session session = factory.openSession();
		String hql ="from MemberBean where accountnumber = :accountnumber ";
		
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class)
				.setParameter("accountnumber",accountnumber);
		List<MemberBean> resultList = query.getResultList();
		session.close();
		return resultList;

	}
	//圖
	public MemberBean findImgbyaccountnumber(String accountnumber) throws SQLException{
		Session session = factory.openSession();
		
		MemberBean result = null;
	
		String hql ="from MemberBean where accountnumber = :accountnumber ";
		
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class)
				.setParameter("accountnumber",accountnumber);
		result = query.getSingleResult();
		session.close();
		return result;

	}
	//用帳號找資料不含圖
	public MemberBean findbyaccountnumberwithoutimage(String accountnumber) throws SQLException{
		
		Session session = factory.openSession();
		System.out.println(session +"DAO session");
		
		MemberBean memberBean = session.get(MemberBean.class, accountnumber);
		MemberBean newBean = new MemberBean();
		newBean.setAccountnumber(memberBean.getAccountnumber());
		newBean.setMemberpassword(memberBean.getMemberpassword());
		newBean.setMemberName(memberBean.getMemberName());
		newBean.setPhonenumber(memberBean.getPhonenumber());
		newBean.setEmail(memberBean.getEmail());
		newBean.setMemberaddress(memberBean.getMemberaddress());
		newBean.setPlatenumber(memberBean.getPlatenumber());
		newBean.setBirthday(memberBean.getBirthday());
		newBean.setIdnumber(memberBean.getIdnumber());
		newBean.setCardnumber(memberBean.getCardnumber());
		session.close();
		return newBean;
	}
	//取得檔名
	public String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}
	
	//放入資料庫
	public void insertMemberBean(MemberBean bean) throws SQLException, ParseException {
		
		Session session = factory.openSession();
		if(bean != null) {
			
			session.save(bean);
			MemberPosition position = new MemberPosition();
			position.setMemberBean(bean);
			PermissionsOfPosition employee = new PermissionsOfPosition();
			employee.setPositionPk("employee");
			position.setPermissionsofposition(employee);
			session.save(position);
			session.flush();
		}
		session.close();
		
	}
	
	//用帳號刪除資料
	public void deleteByAccountnumber(String accountnumber) throws SQLException {
		Session session = factory.openSession();

		MemberPosition mpbean = session.get(MemberPosition.class, accountnumber);
		MemberBean mbean = session.get(MemberBean.class, accountnumber);
		if(mpbean != null) {
			session.delete(mpbean);
		}
		if(mbean != null) {
		session.delete(mbean);
		}
		session.flush();
		session.close();
	}
	//用帳號修改
	public void updateByAccountnumber(MemberBean mb) throws SQLException, ParseException {
		Session session = factory.openSession();
		
		MemberBean memberBean = session.get(MemberBean.class, mb.getAccountnumber());
		
		memberBean.setMemberpassword(mb.getMemberpassword());
		memberBean.setMemberName(mb.getMemberName());
		memberBean.setPhonenumber(mb.getPhonenumber());
		memberBean.setEmail(mb.getEmail());
		memberBean.setMemberaddress(mb.getMemberaddress());
		memberBean.setPlatenumber(mb.getPlatenumber());
		memberBean.setBirthday(mb.getBirthday());
		memberBean.setIdnumber(mb.getIdnumber());
		memberBean.setCardnumber(mb.getCardnumber());
		session.flush();
		session.close();
	}
	
	public boolean checkaccountnumber(String accountnumber) throws SQLException{
		Session session = factory.openSession();
		
		MemberBean memberBean = session.get(MemberBean.class, accountnumber);
		boolean check = false;
		session.close();
		
		if(memberBean != null) {
			check = true;
		}
			return check;
	}
	
	public String checkaccountnumberpassword(String accountnumber,String password) throws SQLException{
		Session session = factory.openSession();
		MemberBean memberBean = session.get(MemberBean.class, accountnumber);
		session.close();
		
		String checkpwd;
		if(memberBean != null) {
			String memberpassword = memberBean.getMemberpassword();
			
			if(memberpassword.trim().equals(password.trim())) {
				checkpwd ="資料正確";
			}else {
				checkpwd = "資料有誤";
			}
		}else {
			checkpwd = "無資料";
		}

		return checkpwd;
		
	}
	public void updateImgByAccount(String accountnumber,Blob personalimg) throws SQLException {
		Session session = factory.openSession();

		MemberBean memberBean = session.get(MemberBean.class, accountnumber);
		
		memberBean.setFile(personalimg);
		session.flush();
		
		session.close();
	}
	
	public List<MemberBean> selectAll() throws SQLException{
		Session session = factory.openSession();
		
		List<MemberBean> resultList = null;
		
		String hql = "from MemberBean";
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class);
		resultList = query.getResultList();
		
		session.close();
		return resultList;
	}
	
	//取得職位
	public String getEmployeePosition() {
		Session session = factory.openSession();
		
		PermissionsOfPosition employee = session.get(PermissionsOfPosition.class, "employee");
		
		session.close();
		
		return employee.getPositionPk();
	}
	
}
