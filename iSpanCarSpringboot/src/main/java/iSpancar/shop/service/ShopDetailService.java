package iSpancar.shop.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iSpancar.member.dao.MemberDao;
import iSpancar.member.model.MemberBean;
import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailDao;
import iSpancar.shop.model.ShopDetailRepository;

@Service
@Transactional
public class ShopDetailService {

	@Autowired
	private ShopDetailRepository sRepo;

	@Autowired
	@Qualifier("sDao")
	private ShopDetailDao sDao;

	public List<ShopDetailBean> findAll() {
		List<ShopDetailBean> list = sRepo.findAll();
		return list;
	}

	public List<ShopDetailBean> findByProductno(String productno){
		int productnoint = Integer.parseInt(productno);
		List<ShopDetailBean> list = sRepo.findByProductno(productnoint);
		return list;
	}
	
	public ShopDetailBean findImgByProductno(String productno) throws SQLException {
		int productnoint = Integer.parseInt(productno);
		Optional<ShopDetailBean> op =  sRepo.findById(productnoint);
		ShopDetailBean shopdetailBean = null;
		if(op.isPresent()) {
			shopdetailBean = op.get();
		}
		return shopdetailBean;
	}
	
	public void insertProduct(ShopDetailBean sBean) {
		sRepo.save(sBean);
	}

	public void updateByProductno(ShopDetailBean sBean) {
		sRepo.saveAndFlush(sBean);
	}
	
	public void delete(ShopDetailBean sBean) {
		sRepo.delete(sBean);
	}
	
	public Blob productImgToBlob(InputStream is, long size) throws IOException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;
	}

	public String getproductImgName(Part part) {
		String ImgName = sDao.getproductImgName(part);
		return ImgName;
	}

}
