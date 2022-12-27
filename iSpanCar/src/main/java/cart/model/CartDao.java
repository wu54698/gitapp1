package cart.model;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import util.HibernateUtil;

public class CartDao {

	
	private SessionFactory factory;

	public CartDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}
		

	public List<CartBean>  findAllById(String memberId) {
		String hql = "from CartBean  where memberId = :memberId ";
		
		Session session = factory.getCurrentSession();
		try {
//			CartBean result = session.createQuery(hql, CartBean.class)
//					.setParameter("memberId", memberId)
//					.getSingleResult();
		    Query query = session.createQuery(hql);   
		    query.setParameter("memberId", memberId) ;
		    List<CartBean> list = query.list();    
			return list;
			
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();	
			return null;
		}

	}

	
	
	public List<CartBean> findAllCart() {
		String hql = "from CartBean ";

		Session session = factory.getCurrentSession();
		try {
			 Query query = session.createQuery(hql);    
	           List<CartBean> allCart = query.list();    
	           
			return allCart;
			
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();	
			return null;
		}

	}

	
	
	public CartBean insertCartBean(CartBean ctBean) {
		Session session = factory.getCurrentSession();
//		CartBean cartBean = session.get(CartBean.class, ctBean.getMemberId());

			session.save(ctBean);
			return ctBean;
	}
	
	
	public void deletecartById(String cartId) {
		String hql = "delete from CartBean where cartId =:cartId ";
		Session session = factory.getCurrentSession();
		
			Query query = session.createQuery(hql) ;	
			query.setParameter("cartId", cartId) ;     
			query.executeUpdate();
		
	}
	
	
	public void deleteCartByMemberId(String memberId) {
		String hql = "delete from CartBean where memberId =:memberId ";

		Session session = factory.getCurrentSession();
		
//			CartBean result = session.createQuery(hql, CartBean.class)
//					.setParameter("memberId", memberId)
//					.getSingleResult();

			Query query = session.createQuery(hql) ;	
			query.setParameter("memberId", memberId) ;     
			query.executeUpdate();
//			session.clear();
		
	}
	
	public void updateQuantityByCartId(String quantity, String cartId) {
		String hql="update CartBean  set quantity=:quantity where cartId=:cartId";
		Session session = factory.getCurrentSession();
		Query query  = session.createQuery(hql); 
		query.setParameter("quantity",quantity);
		query.setParameter("cartId",cartId);
		query.executeUpdate();
		

	}
	
}
