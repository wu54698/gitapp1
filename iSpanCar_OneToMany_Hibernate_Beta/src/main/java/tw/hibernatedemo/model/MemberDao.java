package tw.hibernatedemo.model;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import tw.hibernatedemo.util.HibernateUtil;

public class MemberDao {
	
	private SessionFactory factory;
	
	public MemberDao() {
		this.factory = HibernateUtil.getSessionFactory();
	}
	
	public Member findByNameAndPwd(String username, String pwd) {
		
		String hql = "from Member m where m.memberName = :username and m.memberPwd = :pwd";
		
		Session session = factory.getCurrentSession();
		
//		session.beginTransaction(); 要用filter註冊
		
		try {
			Member result = session.createQuery(hql, Member.class)
					.setParameter("username", username)
					.setParameter("pwd", pwd)
					.getSingleResult();
			
			return result;
			
		} catch (NoResultException | NonUniqueResultException e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		
		
		
		
	}
	
	
}
