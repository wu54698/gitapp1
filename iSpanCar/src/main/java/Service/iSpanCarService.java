package Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;

public class iSpanCarService {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	private ServiceDao seviceDao;


	public iSpanCarService() {
		this.seviceDao = new ServiceDao();
	}

	public Blob filetoBlob(InputStream is, long size) throws IOException, SerialException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;

	}

	// 車商的Service
	// 新增車商
	public ServiceBean addService(ServiceBean seviceBean) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			HibernateUtil.getSessionFactory();
			ServiceBean serviceBean = seviceDao.addService(seviceBean);

			session.getTransaction().commit();
			return seviceBean;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	// 搜尋全車商
	public List<ServiceBean> findAllService() {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<ServiceBean> serviceBean = seviceDao.findAllService();
			session.getTransaction().commit();

			return serviceBean;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			return null;
		}

	}

	// 透過車商名稱刪除車商
	public void deleteCarDealer(String Service_name) {

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			seviceDao.deleteCarDealer(Service_name);

			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	// 透過車商名稱改其他資訊
	public ServiceBean updateByCarDealName(ServiceBean seviceBean) {

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			ServiceBean serviceBean = seviceDao.updateByServiceBean(seviceBean);

			session.getTransaction().commit();
			return serviceBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	// 透過車商來搜尋車商資訊
	public List<ServiceBean> findByService(String Service_name) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();
		
			List<ServiceBean> serviceBean = seviceDao.findByService(Service_name);
			
			session.getTransaction().commit();

			return serviceBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}
}
