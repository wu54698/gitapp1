package tw.hibernatedemo.service;

import java.util.List;

import org.hibernate.Session;

import tw.hibernatedemo.model.CompanyBean;
import tw.hibernatedemo.model.CompanyDao;

public class CompanyService {

	private CompanyDao comDao;

	public CompanyService(Session session) {
		this.comDao = new CompanyDao(session);
	}

	public CompanyBean select(Integer id) {
		// x0.8
		return comDao.findById(id);
	}

	public CompanyBean insert(CompanyBean comBean) {
		return comDao.insertCompany(comBean);
	}

	public List<CompanyBean> findAll() {
		return comDao.selectAll();
	}

	public CompanyBean updateOneCompany(Integer id, String newName) {
		return comDao.updateOneCompany(id, newName);
	}

	public boolean deleteCompanyById(Integer id) {
		return comDao.deleteCompany(id);
	}

	public boolean deleteCompanyByEntity(CompanyBean comBean) {
		return comDao.deleteCompany(comBean);
	}

}
