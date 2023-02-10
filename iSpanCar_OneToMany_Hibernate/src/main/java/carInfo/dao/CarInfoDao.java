package carInfo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import carDealer.model.CarDealerBean;
import carInfo.model.CarInfoBean;
import tw.hibernatedemo.util.HibernateUtil;

public class CarInfoDao {

	private SessionFactory factory;
	private Session session;

	public CarInfoDao() {
		this.factory = HibernateUtil.getSessionFactory();
		this.session = factory.getCurrentSession();
	}
	

	public Blob filetoBlob(InputStream is, long size) throws IOException, SerialException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;

	}

	// 新增車輛商品
	public CarInfoBean addCarInfo(CarDealerBean dealerBean, String accountNumber, String carBrand, String carName,
			int stock, Blob carImage, String carDescription, String announceDate) {

		Session session = factory.getCurrentSession();
		
		String carDealName = dealerBean.getCarDealName();
		
		CarDealerBean carDealerBean = session.get(CarDealerBean.class, carDealName);
		
		CarInfoBean infoBean = new CarInfoBean();
		infoBean.setAccountNumber(accountNumber);
		infoBean.setCarBrand(carBrand);
		infoBean.setCarName(carName);
		infoBean.setStock(stock);
		infoBean.setCarImage(carImage);
		infoBean.setCarDescription(carDescription);
		infoBean.setAnnounceDate(announceDate);
		infoBean.setCarDealerBean(dealerBean);
		
		// 透過carDealer set carInfo
		Set<CarInfoBean> setInfoBean = new LinkedHashSet<CarInfoBean>();
		setInfoBean.add(infoBean);
		carDealerBean.setCarInfo(setInfoBean);

		session.save(carDealerBean);
		return infoBean;

	}


	// 搜尋全車輛
	public List<CarInfoBean> findAllCar() {

		
		Session session = factory.getCurrentSession();

		Query<CarInfoBean> query = session.createQuery("from CarInfoBean", CarInfoBean.class);

		List<CarInfoBean> result = query.getResultList();
		return result;
	}

	// 透過車輛編號刪除車輛
	
	public boolean deleteCarInfo(int carNo) {
		
		Session session = factory.getCurrentSession();
		
		CarInfoBean carInfoBean = session.get(CarInfoBean.class, carNo);
		
		if (carInfoBean != null) {
			session.delete(carInfoBean);
			return true;
		}
		return false;
	}

	// 透過車輛編號修改車輛資訊
	public CarInfoBean updateByCarNo(CarInfoBean infoBean) {

		Session session = factory.getCurrentSession();
		
		CarInfoBean carInfoBean = session.get(CarInfoBean.class, infoBean.getCarNo());
		if (carInfoBean != null) {
			carInfoBean.setCarDealerBean(infoBean.getCarDealerBean());
			carInfoBean.setAccountNumber(infoBean.getAccountNumber());
			carInfoBean.setCarBrand(infoBean.getCarBrand());
			carInfoBean.setCarName(infoBean.getCarName());
			carInfoBean.setStock(infoBean.getStock());
			carInfoBean.setCarImage(infoBean.getCarImage());
			carInfoBean.setCarDescription(infoBean.getCarDescription());
			carInfoBean.setAnnounceDate(infoBean.getAnnounceDate());
		}

		return carInfoBean;

	}


	// 透過品牌找車輛
	public List<CarInfoBean> findByCarBrandLike(String carBrand) {

		String hql = "from CarInfoBean where carBrand = :Brand ";

		Session session = factory.getCurrentSession();

		try {
			Query<CarInfoBean> query = session.createQuery(hql, CarInfoBean.class).setParameter("Brand", carBrand);

			List<CarInfoBean> result = query.getResultList();

			return result;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

	// 透過carNo找車輛(圖片用)
	public List<CarInfoBean> findByCarNoLike(int carNo) {

		String hql = "from CarInfoBean where  carNo = :Number";

		Session session = factory.getCurrentSession();

		try {
			Query<CarInfoBean> query = session.createQuery(hql, CarInfoBean.class).setParameter("Number", carNo);

			List<CarInfoBean> result = query.getResultList();

			return result;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}

	}

}