package iSpancar.order.model;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;



@Repository
@Transactional
public class OrderDao {
	@Autowired
	private SessionFactory factory;



	public OrderBean insertOrderBean(OrderBean bean)  {
		Session session = factory.openSession();
		session.beginTransaction();
		session.save(bean);
		session.getTransaction().commit();
		session.close();
		return bean;}

	


	
	
	public List<OrderBean> findAllOrder() throws Exception {
		String hql = "from OrderBean ";
		Session session = factory.openSession();
		try {
			 Query query = session.createQuery(hql);    
	          List<OrderBean> allOrder = query.list();    
	           
			return allOrder;
			
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();	
			return null;
		}finally {
			session.close();
		}
	}
	
	public void updateOrderSatusByOrderId(String Satus,Timestamp newDate,String orderId  ) throws SQLException, ParseException {
		String hql="update OrderBean  set orderStatus=:Satus ,newDate=:newDate where orderId=:orderId";
		Session session = factory.openSession();
		Query query  = session.createQuery(hql); 
		query.setParameter("Satus",Satus);	
		query.setParameter("orderId",orderId);
		query.setParameter("newDate",newDate);
		query.executeUpdate();
		session.close();
	}
	

}
