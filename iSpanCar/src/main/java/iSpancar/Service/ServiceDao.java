package iSpancar.Service;

import java.sql.SQLException;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class ServiceDao {
	@Autowired
	private SessionFactory factory;

	public ServiceBean fileToBlob(String service_name) throws SQLException {
		Session session = factory.openSession();
		
		ServiceBean result = null;
	
		String hql ="from ServiceBean where service_name = :service_name ";
		
		Query<ServiceBean> query = session.createQuery(hql,ServiceBean.class)
				.setParameter("service_name",service_name);
		result = query.getSingleResult();
		session.close();
		return result;

	}

//增加
	
	public ServiceBean addService(ServiceBean sBean) {
		Session session = factory.openSession();
		if(sBean!=null) {
			session.save(sBean);
		}
		session.flush();
		session.close();
		return sBean;
	}

//刪除

	public boolean deleteService(ServiceBean sBean) {
		Session session = factory.openSession();
		if(sBean!=null) {
			session.delete(sBean);
			session.flush();
			session.close();
			return true;
		}
		return false;
	}

//修改
	public ServiceBean updateByServiceBean(ServiceBean sBean) {
		Session session = factory.openSession();
		if(sBean!=null) {
			session.update(sBean);
			session.flush();
		}
		session.close();
		return sBean;
	}
//查詢
	
	public ServiceBean findByService(String service_name) {
		Session session = factory.openSession();
		ServiceBean resultBean = session.get(ServiceBean.class, service_name);
		session.close();
		return resultBean;
	}
	

//查詢全部
	public List<ServiceBean> findAllService() {
		Session session = factory.openSession();
		Query<ServiceBean> query = session.createQuery("from ServiceBean", ServiceBean.class);

		List<ServiceBean> result = query.getResultList();
		session.close();
		return result;
	}

//	public ServiceBean findById(String Service_name) {
//		Session session = factory.openSession();
//		return session.get(ServiceBean.class, Service_name);
		
	}

