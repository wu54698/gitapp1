package carInfo.dao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import carInfo.model.CarInfoBean;
import util.HibernateUtil;

//import iSpan_Car.model.CarInfoBean;


public class CarInfoDao {
	
	private SessionFactory factory;
	
		public CarInfoDao() {
			this.factory = HibernateUtil.getSessionFactory();
		}
	
	
	public Blob filetoBlob(InputStream is, long size) 
							throws IOException, SerialException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
		
	}
	
	//新增車輛商品
	public CarInfoBean addCarInfo(CarInfoBean infoBean) {
		
		Session session = factory.getCurrentSession();
		
		CarInfoBean carInfoBean = session.get(CarInfoBean.class, infoBean.getCarNo());
		
		if (carInfoBean == null) {
			session.save(infoBean);
			return infoBean;
		}
		return null;
	}
	
	
	//搜尋全車輛
	public List<CarInfoBean> findAllCar() {
		
		Session session = factory.getCurrentSession();
		
		Query<CarInfoBean> query = session.createQuery("from CarInfoBean", CarInfoBean.class);
		
		List<CarInfoBean> result = query.getResultList();
		return result;
	}
	
	
	//透過車輛編號刪除車輛
	public boolean deleteCarInfo(int carNo) {
		
		Session session = factory.getCurrentSession();
		
		CarInfoBean carInfoBean = session.get(CarInfoBean.class, carNo);
		
		if (carInfoBean != null) {
			session.delete(carInfoBean);
			return true;
		}
		return false;
	}
	
	//透過車輛編號修改車輛資訊
	public CarInfoBean updateByCarNo(CarInfoBean infoBean) {
		
		Session session = factory.getCurrentSession();
		
		CarInfoBean carInfoBean = session.get(CarInfoBean.class, infoBean.getCarNo());
		if (carInfoBean != null) {
			carInfoBean.setCarDealName(infoBean.getCarDealName());
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
	
	//透過品牌找車輛
	public List<CarInfoBean> findByCarBrandLike(String carBrand) {
		
		String hql = "from CarInfoBean where carBrand = :Brand ";
		
		Session session = factory.getCurrentSession();
		
		try {
			Query<CarInfoBean> query = session.createQuery(hql, CarInfoBean.class)
					.setParameter("Brand", carBrand);
			
			List<CarInfoBean> result = query.getResultList();
			
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
	//透過carNo找車輛(圖片用)
	public List<CarInfoBean> findByCarNoLike(int carNo) {
		
		String hql = "from CarInfoBean where  carNo = :Number";
		
		Session session = factory.getCurrentSession();
		
		try {
			Query<CarInfoBean> query = session.createQuery(hql, CarInfoBean.class)
					.setParameter("Number", carNo);
			
			List<CarInfoBean> result = query.getResultList();
			
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
	}
	
}