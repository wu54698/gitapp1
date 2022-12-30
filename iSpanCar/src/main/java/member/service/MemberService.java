package member.service;

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

import member.dao.MemberDao;
import member.model.MemberBean;
import member.model.MemberPosition;
import member.model.PermissionsOfPosition;
import util.HibernateUtil;

public class MemberService {

	private MemberDao mDao;
	private SessionFactory factory;
	
	public MemberService() {
		this.mDao = new MemberDao();
		this.factory =	HibernateUtil.getSessionFactory();
	}
	
	//用帳號找資料
	public List<MemberBean> findbyaccountnumber(String accountnumber) throws SQLException{
		List<MemberBean> list = null;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			list  = mDao.findbyaccountnumber(accountnumber);
			
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
		return list;
	}
	
	//圖
	public MemberBean findImgbyaccountnumber(String accountnumber) throws SQLException {
		MemberBean mBean = null;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			mBean = mDao.findImgbyaccountnumber(accountnumber);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
		return mBean;
	}
	
	//用帳號找資料不含圖
	public MemberBean findbyaccountnumberwithoutimage(String accountnumber) throws SQLException {
		MemberBean mBean = null;
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
		mBean = mDao.findbyaccountnumberwithoutimage(accountnumber);
		session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
		return mBean;
	}
	
	//放入資料庫
	public void insertMemberBean(MemberBean bean) throws SQLException, ParseException {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			mDao.insertMemberBean(bean);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
	}

	//用帳號刪除資料
	public void deleteByAccountnumber(String accountnumber) throws SQLException {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			mDao.deleteByAccountnumber(accountnumber);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	//用帳號修改
	public void updateByAccountnumber(MemberBean mb) throws SQLException, ParseException {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			mDao.updateByAccountnumber(mb);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	//確認有無帳號
	public boolean checkaccountnumber(String accountnumber) throws SQLException {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			boolean check = mDao.checkaccountnumber(accountnumber);
			session.getTransaction().commit();
			return check;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return false;
		}
	}
	
	//確認帳密
	public String checkaccountnumberpassword(String accountnumber,String password) throws SQLException {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			String checkString = mDao.checkaccountnumberpassword(accountnumber, password);
			session.getTransaction().commit();
			return checkString;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return "錯誤";
		}
	}
	
	//修改圖片
	public void updateImgByAccount(String accountnumber,Blob personalimg) throws SQLException {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			mDao.updateImgByAccount(accountnumber, personalimg);
			session.getTransaction().commit();
		}catch (Exception e) {
			session.getTransaction().rollback();
		}
	}
	
	//查詢全部
	public List<MemberBean> selectAll() throws SQLException{
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		try {
			List<MemberBean> list = mDao.selectAll();
			session.getTransaction().commit();
			return list;
		}catch (Exception e) {
			session.getTransaction().rollback();
			return null;
		}
	}
	
	//取得職位
		public String getEmployeePosition() {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			try {
				String employee = mDao.getEmployeePosition();
				session.getTransaction().commit();
				return employee;
			}catch (Exception e) {
				session.getTransaction().rollback();
				return null;
			}
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
