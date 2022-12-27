package order.model;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import cart.model.CartBean;
import util.HibernateUtil;

public class OrderDao {

	private SessionFactory factory;

	public OrderDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}



	public OrderBean insertOrderBean(OrderBean bean) throws SQLException, ParseException {

		Session session = factory.getCurrentSession();
		OrderBean orderBean = session.get(OrderBean.class, bean.getOrderId());
		session.save(bean);
//		session.clear();

		return bean;

	}
	
	public List<OrderBean> findAllOrder() throws Exception {
		String hql = "from OrderBean ";
		Session session = factory.getCurrentSession();
		try {
			 Query query = session.createQuery(hql);    
	          List<OrderBean> allOrder = query.list();    
	           
			return allOrder;
			
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();	
			return null;
		}
	}
	
	public void updateOrderSatusByOrderId(String Satus,Timestamp newDate,String orderId  ) throws SQLException, ParseException {
		String hql="update OrderBean  set orderStatus=:Satus ,newDate=:newDate where orderId=:orderId";
		Session session = factory.getCurrentSession();
		Query query  = session.createQuery(hql); 
		query.setParameter("Satus",Satus);	
		query.setParameter("orderId",orderId);
		query.setParameter("newDate",newDate);
		query.executeUpdate();
	}
	

}
