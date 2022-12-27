package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.annotation.WebServlet;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import util.HibernateUtil;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;

public class ServiceDao {

	private SessionFactory factory;

	public ServiceDao() {
		this.factory = HibernateUtil.getSessionFactory();;
	}

	public Blob fileToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;

	}

//增加
	public ServiceBean addService(ServiceBean sBean) {
		Session session = factory.getCurrentSession();
		ServiceBean servicebean = session.get(ServiceBean.class, sBean.getService_name());

		if (servicebean == null) {
			session.save(sBean);
			return sBean;
		}
		return null;
	}

//刪除
	public boolean deleteCarDealer(String Service_name) {
		Session session = factory.getCurrentSession();
		ServiceBean servicebean = session.get(ServiceBean.class, Service_name);
		
		
		if(servicebean != null) {
			session.delete(servicebean);
			return true;
		}
		return false;
	
	}

//修改
	public ServiceBean updateByServiceBean(ServiceBean serviceBean) {
		Session session = factory.getCurrentSession();
		ServiceBean sBean = session.get(ServiceBean.class, serviceBean.getService_name());
		if(sBean!=null ) {
					sBean.setService_name(serviceBean.getService_name());
					sBean.setCarimage(serviceBean.getCarimage());
					sBean.setServicedescription(serviceBean.getServicedescription());
					sBean.setServiceinfomation(serviceBean.getServiceinfomation());
					sBean.setContactperson(serviceBean.getContactperson());
					sBean.setReseller_nonreseller(serviceBean.getReseller_nonreseller());
		}
		
		return sBean;
	}
//查詢
	public List<ServiceBean> findByService(String Service_name) {
		Session session = factory.getCurrentSession();
		String hql = "from ServiceBean where Service_name = :Service_name";
		try {
			Query<ServiceBean> query = session.createQuery(hql, ServiceBean.class)
					.setParameter("Service_name",Service_name);
			List<ServiceBean> result = query.getResultList();
			return result;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	

//查詢全部
	public List<ServiceBean> findAllService() {
		Session session = factory.getCurrentSession();
		Query<ServiceBean> query = session.createQuery("from ServiceBean", ServiceBean.class);

		List<ServiceBean> result = query.getResultList();
		return result;
	}

	public ServiceBean findById(String Service_name) {
		Session session = factory.getCurrentSession();
		return session.get(ServiceBean.class,Service_name );
	}



}
