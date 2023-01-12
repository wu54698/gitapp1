package iSpancar.cart.model;

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
public class CartDao {

	@Autowired
	private SessionFactory factory;

	
		

	public List<CartBean>  findAllById(String memberId) {
		String hql = "from CartBean  where memberId = :memberId ";
		
		Session session = factory.openSession();
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
		}finally {
			session.close();
		}

	}

	
	
	public List<CartBean> findAllCart() {
		String hql = "from CartBean ";

		Session session = factory.openSession();
		try {
			 Query query = session.createQuery(hql);    
	           List<CartBean> allCart = query.list();    
	           
			return allCart;
			
		} catch (NoResultException | NonUniqueResultException e) {
			e.printStackTrace();	
			return null;
		}finally {
			session.close();
		}

	}

	
	
	public CartBean insertCartBean(CartBean ctBean) {
		Session session = factory.openSession();
//		CartBean cartBean = session.get(CartBean.class, ctBean.getMemberId());

			session.save(ctBean);
			session.close();
			return ctBean;
			
	}
	
	
	public void deletecartById(String cartId) {
		String hql = "delete from CartBean where cartId =:cartId ";
		Session session = factory.openSession();
		
			Query query = session.createQuery(hql) ;	
			query.setParameter("cartId", cartId) ;     
			query.executeUpdate();
			session.close();
		
	}
	
	
	public void deleteCartByMemberId(String memberId) {
		String hql = "delete from CartBean where memberId =:memberId ";

		Session session = factory.openSession();
		
//			CartBean result = session.createQuery(hql, CartBean.class)
//					.setParameter("memberId", memberId)
//					.getSingleResult();

			Query query = session.createQuery(hql) ;	
			query.setParameter("memberId", memberId) ;     
			query.executeUpdate();
			session.close();
	}
	
	public void updateQuantityByCartId(String quantity, String cartId) {
		String hql="update CartBean  set quantity=:quantity where cartId=:cartId";
		Session session = factory.openSession();
		Query query  = session.createQuery(hql); 
		query.setParameter("quantity",quantity);
		query.setParameter("cartId",cartId);
		query.executeUpdate();
		session.close();

	}
	
}
