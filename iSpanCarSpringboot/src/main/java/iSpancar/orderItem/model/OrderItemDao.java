package iSpancar.orderItem.model;

import java.sql.SQLException;
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
public class OrderItemDao {
	@Autowired
	private SessionFactory factory;



	public OrderItemBean insertOrderItemBean(OrderItemBean bean) throws SQLException, ParseException {

		Session session = factory.openSession();
//		OrderItemBean orderItemBean = session.get(OrderItemBean.class, bean.getOrderId());

		session.save(bean);
		session.clear();
		session.close();
		return bean;

	}
	
	
	public List<OrderItemBean> findAllOrderItem() throws Exception {
		String hql = "from OrderItemBean ";
		Session session = factory.openSession();
		try {
			 Query query = session.createQuery(hql);    
	          List<OrderItemBean> allOrderItem = query.list();    
	           
			return allOrderItem;
			
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();	
			return null;
		}finally {
			session.close();
		}
	}
}
