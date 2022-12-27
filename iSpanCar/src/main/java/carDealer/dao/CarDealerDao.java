package carDealer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.taglibs.standard.lang.jstl.test.beans.PublicBean1;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import carDealer.model.CarDealerBean;
import util.HibernateUtil;



public class CarDealerDao {
	
	private SessionFactory factory;
	
	public CarDealerDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	
	//新增車商
	public CarDealerBean addCarDealer(CarDealerBean dealBean) {
		
		Session session = factory.getCurrentSession();

		CarDealerBean dealerBean = session.get(CarDealerBean.class, dealBean.getCarDealName());
		
		if (dealerBean == null ) {
			session.save(dealBean);
			return dealBean;
		}
		return null;
	}
	
	//搜尋全車商
	public List<CarDealerBean> findAllDealer() {
		
		Session session = factory.getCurrentSession();
		
		Query<CarDealerBean> query = session.createQuery("from CarDealerBean", CarDealerBean.class);
		
		List<CarDealerBean> result = query.getResultList();
		return result;
	}
	
	//透過車商名稱刪除車商
	public boolean deleteCarDealer(String carDealName) {
		
		Session session = factory.getCurrentSession();
		
		CarDealerBean dealerBean = session.get(CarDealerBean.class, carDealName);
		
		if(dealerBean != null) {
			session.delete(dealerBean);
			return true;
		}
		return false;
	}
	
	//透過車商名稱改其他資訊
	public CarDealerBean updateByCarDealName(CarDealerBean dealerBean) {
		Session session = factory.getCurrentSession();
		CarDealerBean cdBean = session.get(CarDealerBean.class, dealerBean.getCarDealName());
		if(cdBean != null) {
			cdBean.setCarDealPhone(dealerBean.getCarDealPhone());
			cdBean.setCarDealAddress(dealerBean.getCarDealAddress());
			cdBean.setOpenTime(dealerBean.getOpenTime());
			cdBean.setContactPerson(dealerBean.getContactPerson());
			cdBean.setCarDealVATNumber(dealerBean.getCarDealVATNumber());
		}
		return cdBean;
	}
	
	//透過車商來搜尋車商資訊
	public List<CarDealerBean> findByCarDealerName(String carDealName) {
		
		String hql = "from CarDealerBean where carDealName = :carDealName";
		
		Session session = factory.getCurrentSession();
		try {
			Query<CarDealerBean> query = session.createQuery(hql, CarDealerBean.class)
					.setParameter("carDealName", carDealName);
			
			List<CarDealerBean> result = query.getResultList();
			return result;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
	}
	
	
}