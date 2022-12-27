package iSpanShop.service;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.Session;

import iSpanShop.model.ShopDetailBean;
import iSpanShop.model.ShopDetailDao;

public class ShopDetailService {


	private ShopDetailDao sDao;
	
	public ShopDetailService() {
		this.sDao = new ShopDetailDao();
	}



	public List<ShopDetailBean> findAll() {
		return sDao.findAllProduct();
	}

	public ShopDetailBean insert(ShopDetailBean sBean) {
		return sDao.insertProduct(sBean);
	}

//	public CompanyBean updateOneCompany(Integer id, String newName) {
//		return comDao.updateOneCompany(id, newName);
//	}
//
//	public boolean deleteCompanyById(Integer id) {
//		return comDao.deleteCompany(id);
//	}
//
	public void delete(ShopDetailBean sdb) {
		try {
			sDao.deleteProduct(sdb);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
