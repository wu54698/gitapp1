package orderItem.model;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import util.HibernateUtil;
import order.model.OrderBean;

public class OrderItemDao {

	private SessionFactory factory;

	public OrderItemDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}

	public OrderItemBean insertOrderItemBean(OrderItemBean bean) throws SQLException, ParseException {

		Session session = factory.getCurrentSession();
//		OrderItemBean orderItemBean = session.get(OrderItemBean.class, bean.getOrderId());

		session.save(bean);
		session.clear();
		return bean;

	}
	
	
	public List<OrderItemBean> findAllOrderItem() throws Exception {
		String hql = "from OrderItemBean ";
		Session session = factory.getCurrentSession();
		try {
			 Query query = session.createQuery(hql);    
	          List<OrderItemBean> allOrderItem = query.list();    
	           
			return allOrderItem;
			
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();	
			return null;
		}
	}
}
