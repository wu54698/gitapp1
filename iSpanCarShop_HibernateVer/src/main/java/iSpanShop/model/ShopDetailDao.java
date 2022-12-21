package iSpanShop.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
//import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.http.Part;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import iSpanShop.util.HibernateUtil;

public class ShopDetailDao {

	private SessionFactory factory;
	
	public ShopDetailDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}

//	public java.sql.Date stringToSqlDate(String string) throws ParseException {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date udate = df.parse(string);
//		java.sql.Date update = new java.sql.Date(udate.getTime());
//		return update;
//	}

	public Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

	public String getFileName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	// 拿所有產品資料，回傳List<Member>
	public List<ShopDetailBean> findAllProduct(){
		
		Session session = factory.getCurrentSession();
		
		Query<ShopDetailBean> query = session.createQuery("from ShopDetailBean",ShopDetailBean.class);
		
		List<ShopDetailBean> result = query.getResultList();
		
		return result;
	}

	// 新增資料
	public ShopDetailBean insertProduct(ShopDetailBean sdb){
		Session session = factory.getCurrentSession();
		
		ShopDetailBean shopDetailBean = session.get(ShopDetailBean.class, sdb.getProductno());
		if(shopDetailBean == null) {
			session.save(sdb);
			return sdb;
		}
		return null;
	}

	// 透過productno拿資料
	public List<ShopDetailBean> findByProductno(String productno) throws SQLException {
		
		String hql = "from SHOP_DETAIL where productno = :productno";
		
		Session session = factory.getCurrentSession();
		try {
			Query<ShopDetailBean> query = session.createQuery(hql,ShopDetailBean.class).setParameter("productno", productno);
			List<ShopDetailBean> result = query.getResultList();
			return result;
		} catch (Exception e) {
			System.out.println("hql出事了!");
			e.printStackTrace();
			return null;
		}
	}

//		// 修改一筆產品資料
		public ShopDetailBean updateProduct(ShopDetailBean sdb) {
			Session session = factory.getCurrentSession();
			ShopDetailBean sBean = session.get(ShopDetailBean.class, sdb.getProductno());
			
			if (sBean != null) {
				sBean.setProductname(sdb.getProductname());
				sBean.setPrice(sdb.getPrice());
				sBean.setStock(sdb.getStock());
				sBean.setProductinfo(sdb.getProductinfo());
				sBean.setProductimage(sdb.getProductimage());
			}
			return sBean;
	}

//	// 刪除該產品 用productno找
	public boolean deleteProduct(int productno) throws SQLException {
		Session session = factory.getCurrentSession();
		
		ShopDetailBean sBean = session.get(ShopDetailBean.class, productno);
		
		if (sBean != null) {
			session.delete(sBean);
			return true;
		}
		return false;
	}

}
