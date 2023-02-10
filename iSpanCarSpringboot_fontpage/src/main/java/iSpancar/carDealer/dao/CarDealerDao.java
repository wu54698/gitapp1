package iSpancar.carDealer.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import iSpancar.carDealer.model.CarDealerBean;

@Repository
@Transactional
public class CarDealerDao {

	@Autowired
	private SessionFactory factory;

	// 新增車商
	public CarDealerBean addCarDealer(CarDealerBean dealBean) {

		Session session = factory.openSession();
		try {
			session.beginTransaction();

			CarDealerBean dealerBean = session.get(CarDealerBean.class, dealBean.getCarDealName());
			if (dealerBean == null) {
				session.save(dealBean);
				session.getTransaction().commit();
				return dealBean;
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	// 搜尋全車商
	public List<CarDealerBean> findAllDealer() {

		Session session = factory.openSession();

		try {
			session.beginTransaction();
			Query<CarDealerBean> query = session.createQuery("from CarDealerBean", CarDealerBean.class);

			List<CarDealerBean> result = query.getResultList();
			session.getTransaction().commit();
			return result;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return null;
	}

	// 透過車商名稱刪除車商
	public boolean deleteCarDealer(String carDealName) {

		Session session = factory.openSession();

		try {
			session.beginTransaction();

			CarDealerBean dealerBean = session.get(CarDealerBean.class, carDealName);

			if (dealerBean != null) {
				session.delete(dealerBean);
				session.getTransaction().commit();
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return false;
	}

	// 透過車商名稱改其他資訊
	public CarDealerBean updateByCarDealName(CarDealerBean dealerBean) {
		Session session = factory.openSession();
		
		try {
			session.beginTransaction();
			
			CarDealerBean cdBean = session.get(CarDealerBean.class, dealerBean.getCarDealName());
			if (cdBean != null) {
				cdBean.setCarDealPhone(dealerBean.getCarDealPhone());
				cdBean.setCarDealAddress(dealerBean.getCarDealAddress());
				cdBean.setOpenTime(dealerBean.getOpenTime());
				cdBean.setContactPerson(dealerBean.getContactPerson());
				cdBean.setCarDealVATNumber(dealerBean.getCarDealVATNumber());
			}
			
			session.getTransaction().commit();
			return cdBean;
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("ROLLBACK");
			session.getTransaction().rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return null;
	}

	// 透過車商來搜尋車商資訊
	public List<CarDealerBean> findByCarDealerName(String carDealName) {

		String hql = "from CarDealerBean where carDealName = :carDealName";

		Session session = factory.openSession();
		try {
			Query<CarDealerBean> query = session.createQuery(hql, CarDealerBean.class).setParameter("carDealName",
					carDealName);

			List<CarDealerBean> result = query.getResultList();
			return result;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
	}

}