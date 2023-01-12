package iSpancar.shop.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailDao;
@Service
@Transactional
public class ShopDetailService {

	@Autowired
	@Qualifier("sDao")
	private ShopDetailDao sDao;
	
	public ShopDetailService() {
	}


	public List<ShopDetailBean> findAll() {
		List<ShopDetailBean> list = sDao.findAllProduct();
		return list;
	}

	public ShopDetailBean insert(ShopDetailBean sBean) {
		sDao.insertProduct(sBean);
		return null;
	}
	
	public ShopDetailBean update(ShopDetailBean serviceBean) {
		ShopDetailBean sBean = sDao.updateProduct(serviceBean);
		return sBean;
	}
	
	public List<ShopDetailBean> findByservice(String serviceno) throws SQLException{
		List<ShopDetailBean> list = sDao.findByProductno(serviceno);
		return list;
	}
	
	public ShopDetailBean findImgByService(String service_no) throws SQLException {
		ShopDetailBean result = sDao.findImgbyproductno(service_no);
		return result;
	}
	
	public void delete(ShopDetailBean sdb) throws SQLException {
			sDao.deleteProduct(sdb);
	}
	
	public Blob filetoBlob(InputStream is, long size) throws SerialException, SQLException, IOException {
		Blob sb = sDao.fileToBlob(is, size);
		return sb;
	}
	
	public String getFileName(Part part) {
		String fname = sDao.getFileName(part);
		return fname;
	}

}
