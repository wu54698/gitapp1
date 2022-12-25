package iSpanShop.model;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import iSpanShop.util.HibernateUtil;

public class MemberDao {
	
	private SessionFactory factory;
	
	public MemberDao() {
		this.factory =  HibernateUtil.getSessionFactory();
	}
	
	public Member findByNameAndPwd(String username, String pwd) {
		
		String hql = "from Member m where m.memberName = :username and m.memberPwd = :pwd";
		
		Session session = factory.getCurrentSession();
		
		
		try {
			Member result = session.createQuery(hql, Member.class)
					.setParameter("username", username)
					.setParameter("pwd", pwd)
			        .getSingleResult();
			
			return result;
		}catch(NoResultException | NonUniqueResultException e) {
			e.printStackTrace();
			return null;
		}
		
		
		
	}

}
