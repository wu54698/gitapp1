package member.dao;

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

import member.model.MemberBean;
import util.HibernateUtil;


public class MemberDao {


	
	private SessionFactory factory;
	
	public MemberDao() {
		this.factory =	HibernateUtil.getSessionFactory();
	}
	
	public java.sql.Date stringToSqlDate(String string) throws ParseException {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date udate = df.parse(string);
		java.sql.Date sdate = new java.sql.Date(udate.getTime());
		return sdate;
	}
	
	//用帳號找資料
	public List<MemberBean> findbyaccountnumber(String accountnumber) throws SQLException{
		String hql ="from MemberBean where accountnumber = :accountnumber ";
		Session session = factory.getCurrentSession();
		
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class)
				.setParameter("accountnumber",accountnumber);
		List<MemberBean> resultList = query.getResultList();
		return resultList;

	}
	//圖
	public MemberBean findImgbyaccountnumber(String accountnumber) throws SQLException{
		Session session = factory.getCurrentSession();
		
		MemberBean result = null;
	
		String hql ="from MemberBean where accountnumber = :accountnumber ";
		
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class)
				.setParameter("accountnumber",accountnumber);
		result = query.getSingleResult();
		
		return result;

	}
	//用帳號找資料不含圖
	public MemberBean findbyaccountnumberwithoutimage(String accountnumber) throws SQLException{
		
		Session session = factory.getCurrentSession();
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
		Session session = factory.getCurrentSession();
		if(bean != null) {
			session.save(bean);
		}
		
	}
	
	//用帳號刪除資料
	public void deleteByAccountnumber(String accountnumber) throws SQLException {
		Session session = factory.getCurrentSession();

		MemberBean bean = session.get(MemberBean.class, accountnumber);
		session.delete(bean);
	}
	//用帳號修改
	public void updateByAccountnumber(MemberBean mb) throws SQLException, ParseException {
		Session session = factory.getCurrentSession();
		
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
		
	}
	
	public boolean checkaccountnumber(String accountnumber) throws SQLException{
		Session session = factory.getCurrentSession();
		
		MemberBean memberBean = session.get(MemberBean.class, accountnumber);
		boolean check = false;
		if(memberBean != null) {
			check = true;
		}
			return check;
	}
	
	public String checkaccountnumberpassword(String accountnumber,String password) throws SQLException{
		Session session = factory.getCurrentSession();

		MemberBean memberBean = session.get(MemberBean.class, accountnumber);
		
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
		Session session = factory.getCurrentSession();

		MemberBean memberBean = session.get(MemberBean.class, accountnumber);
		
		memberBean.setFile(personalimg);
	}
	
	public List<MemberBean> selectAll() throws SQLException{
		Session session = factory.getCurrentSession();
		
		List<MemberBean> resultList = null;
		
		String hql = "from MemberBean";
		Query<MemberBean> query = session.createQuery(hql,MemberBean.class);
		resultList = query.getResultList();
		
		return resultList;
	}
	
}
