//package iSpancar.shop.service;
//
//import java.sql.SQLException;
//import java.util.List;
//
//import org.hibernate.Session;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import iSpancar.shop.model.ShopDetailBean;
//import iSpancar.shop.model.ShopDetailDao;
//@Service
//@Transactional
//public class ShopDetailService {
//
//	@Autowired
//	@Qualifier("sDao")
//	private ShopDetailDao sDao;
//	
//	public ShopDetailService() {
//	}
//
//
//
//	public List<ShopDetailBean> findAll() {
//		return sDao.findAllProduct();
//	}
//
//	public ShopDetailBean insert(ShopDetailBean sBean) {
//		return sDao.insertProduct(sBean);
//	}
//
////	public CompanyBean updateOneCompany(Integer id, String newName) {
////		return comDao.updateOneCompany(id, newName);
////	}
////
//	public void delete(ShopDetailBean sdb) {
//		try {
//			sDao.deleteProduct(sdb);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//	}
//
//}
