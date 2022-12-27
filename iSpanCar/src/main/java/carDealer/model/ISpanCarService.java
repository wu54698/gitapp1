package carDealer.model;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import carDealer.dao.CarDealerDao;
import carDealer.model.CarDealerBean;
import carInfo.dao.CarInfoDao;
import carInfo.model.CarInfoBean;
import util.HibernateUtil;

public class ISpanCarService {

	SessionFactory factory = HibernateUtil.getSessionFactory();

	private CarDealerDao dealerDao;

	private CarInfoDao infoDao;

	public ISpanCarService() {
		this.dealerDao = new CarDealerDao();
		this.infoDao = new CarInfoDao();
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
	public CarDealerBean addDealer(CarDealerBean dealBean) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			HibernateUtil.getSessionFactory();
			CarDealerBean dealerBean = dealerDao.addCarDealer(dealBean);

			session.getTransaction().commit();
			return dealerBean;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	// 搜尋全車商
	public List<CarDealerBean> findAllDealer() {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<CarDealerBean> dealerBeans = dealerDao.findAllDealer();
			session.getTransaction().commit();

			return dealerBeans;

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			return null;
		}

	}

	// 透過車商名稱刪除車商
	public void deleteCarDealer(String carDealName) {

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			dealerDao.deleteCarDealer(carDealName);

			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	// 透過車商名稱改其他資訊
	public CarDealerBean updateByCarDealName(CarDealerBean dealBean) {

		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			CarDealerBean dealerBean = dealerDao.updateByCarDealName(dealBean);

			session.getTransaction().commit();
			return dealerBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	// 透過車商來搜尋車商資訊
	public List<CarDealerBean> findByCarDealerName(String carDealName) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<CarDealerBean> dealerBeans = dealerDao.findByCarDealerName(carDealName);
			session.getTransaction().commit();

			return dealerBeans;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	// 車輛的Service
	// 新增車輛商品
	public CarInfoBean addCarInfo(CarInfoBean infoBean) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			CarInfoBean carInfoBean = infoDao.addCarInfo(infoBean);
			session.getTransaction().commit();

			return carInfoBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	// 搜尋全車輛
	public List<CarInfoBean> findAllCar() {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<CarInfoBean> carInfoBean = infoDao.findAllCar();
			session.getTransaction().commit();
			return carInfoBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	// 透過車輛編號刪除車輛
	public void deleteCarInfo(int carNo) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			infoDao.deleteCarInfo(carNo);

			session.getTransaction().commit();
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
		}

	}

	// 透過車輛編號修改車輛資訊
	public CarInfoBean updateByCarNo(CarInfoBean infoBean) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			CarInfoBean carInfoBean = infoDao.updateByCarNo(infoBean);
			session.getTransaction().commit();

			return carInfoBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

	// 透過品牌找車輛
	public List<CarInfoBean> findByCarBrandLike(String carBrand) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<CarInfoBean> carInfoBean = infoDao.findByCarBrandLike(carBrand);
			session.getTransaction().commit();

			return carInfoBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK!!");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}

	}

	// 透過carNo找車輛(圖片用)
	public List<CarInfoBean> findByCarNoLike(int carNo) {
		Session session = factory.getCurrentSession();

		try {
			session.beginTransaction();

			List<CarInfoBean> carInfoBean = infoDao.findByCarNoLike(carNo);

			session.getTransaction().commit();
			return carInfoBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
			return null;
		}
	}

}
