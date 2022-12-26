package tw.hibernatedemo.model;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CompanyDao {
	
	private Session session;
	
	
	// 依賴注入，Dependency Injection
	public CompanyDao(Session session) {
		this.session = session;
	}
	
	public CompanyBean insertCompany(CompanyBean comBean) {
		CompanyBean companyBean = session.get(CompanyBean.class, comBean.getCompanyId());
		
		if(companyBean == null) {
			session.save(comBean);
			return comBean;
		}
		
		return null;
	}
	
	public CompanyBean findById(Integer id) {
		return session.get(CompanyBean.class, id);
	}
	
	public CompanyBean updateOneCompany(Integer id, String newName) {
		CompanyBean comBean = session.get(CompanyBean.class, id);
		
		if(comBean != null) {
			comBean.setCompanyName(newName);
		}
		
		return comBean;
	}
	
	public boolean deleteCompany(Integer id) {
		CompanyBean comBean = session.get(CompanyBean.class, id);
		
		if(comBean != null) {
			session.delete(comBean);
			return true;
		}
		
		return false;
	}
	
    public boolean deleteCompany(CompanyBean comBean) {
    	if(comBean != null) {
			session.delete(comBean);
			return true;
		}
    	return false;
	}
    
    public List<CompanyBean> selectAll(){
    	Query<CompanyBean> query = session.createQuery("from CompanyBean", CompanyBean.class);
    	
//    	query.list();
    	List<CompanyBean> result = query.getResultList();
    	
    	return result;
    }
	
}
