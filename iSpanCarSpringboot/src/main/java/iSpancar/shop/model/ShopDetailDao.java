package iSpancar.shop.model;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository(value = "sDao")
@Transactional
public class ShopDetailDao {

	@Autowired
	private SessionFactory factory;

//	public java.sql.Date stringToSqlDate(String string) throws ParseException {
//		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
//		Date udate = df.parse(string);
//		java.sql.Date update = new java.sql.Date(udate.getTime());
//		return update;
//	}

	public Blob productImgToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

	public String getproductImgName(Part part) {
		for (String content : part.getHeader("content-disposition").split(";")) {
			if (content.trim().startsWith("filename")) {
				return content.substring(content.indexOf('=') + 1).trim().replace("\"", "");
			}
		}
		return null;
	}

	// 拿所有產品資料，回傳List<Member>
	public List<ShopDetailBean> findAllProduct() {

		Session session = factory.openSession();
		// session.beginTransaction();

		Query<ShopDetailBean> query = session.createQuery("from ShopDetailBean", ShopDetailBean.class);

		List<ShopDetailBean> result = query.getResultList();
		// session.getTransaction().commit();
		session.close();

		return result;
	}

	// 新增資料
	public ShopDetailBean insertProduct(ShopDetailBean sdb) {
		Session session = factory.openSession();
		// session.beginTransaction();

//		ShopDetailBean shopDetailBean = session.get(ShopDetailBean.class, sdb);
//		if (shopDetailBean == null) {
//			session.save(sdb);
//			return sdb;
//
//		}
		session.saveOrUpdate(sdb);
		// session.getTransaction().commit();
		session.close();
		return null;
	}

	// 透過productno拿資料
	public List<ShopDetailBean> findByProductno(String productno) throws SQLException {

		String hql = "from ShopDetailBean where productno = :productno";

		int productnonumber = Integer.parseInt(productno);
		Session session = factory.openSession();
		// session.beginTransaction();
		try {
			Query<ShopDetailBean> query = session.createQuery(hql, ShopDetailBean.class).setParameter("productno",
					productnonumber);
			List<ShopDetailBean> result = query.getResultList();
			// session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			// session.getTransaction().rollback();
			System.out.println("hql出事了!");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}

	}

//		// 修改一筆產品資料
	public ShopDetailBean updateProduct(ShopDetailBean sdb) {
		Session session = factory.openSession();
		// session.beginTransaction();

		ShopDetailBean sBean = session.get(ShopDetailBean.class, sdb.getProductno());

		if (sBean != null) {
			sBean.setProductno(sdb.getProductno());
			sBean.setProductname(sdb.getProductname());
			sBean.setPrice(sdb.getPrice());
			sBean.setStock(sdb.getStock());
			sBean.setProductinfo(sdb.getProductinfo());
			sBean.setProductimage(sdb.getProductimage());
			sBean.setProductimagename(sdb.getProductimagename());
//			session.saveOrUpdate(sBean);
		}
		// session.getTransaction().commit();
		session.flush();
		session.close();
		return sBean;

	}

//	// 刪除該產品
	public void deleteProduct(ShopDetailBean sdb) throws SQLException {

		Session session = factory.openSession();
		// session.beginTransaction();

		try {
			session.delete(sdb);
			session.flush();
			// session.getTransaction().commit();

		} catch (Exception e) {
			// session.getTransaction().rollback();
			System.out.println("hql刪除出事了!");
			e.printStackTrace();
		}
	}
	//找的Bean回傳
	public ShopDetailBean findImgbyproductno(String productno) throws SQLException{
		Session session = factory.openSession();
		
		ShopDetailBean result = null;
	
		String hql ="from ShopDetailBean where productno = :productno";
		int productnoint = Integer.parseInt(productno);
		Query<ShopDetailBean> query = session.createQuery(hql,ShopDetailBean.class)
				.setParameter("productno",productnoint);
		result = query.getSingleResult();
		session.close();
		return result;

	}

}
