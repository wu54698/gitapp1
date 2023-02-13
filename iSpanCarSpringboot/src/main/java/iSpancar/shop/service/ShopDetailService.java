package iSpancar.shop.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iSpancar.member.dao.MemberDao;
import iSpancar.member.model.MemberBean;
import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailDao;
import iSpancar.shop.model.ShopDetailImagesRepository;
import iSpancar.shop.model.ShopDetailImgsBean;
import iSpancar.shop.model.ShopDetailRepository;

@Service
@Transactional
public class ShopDetailService {

	@Autowired
	private ShopDetailRepository sRepo;
	
	@Autowired
	private ShopDetailImagesRepository siRepo;

	@Autowired
	@Qualifier("sDao")
	private ShopDetailDao sDao;

	public List<ShopDetailBean> findAll() {
		List<ShopDetailBean> list = sRepo.findAll();
		return list;
	}
	
	//前台分頁前台分頁前台分頁前台分頁前台分頁前台分頁前台分頁前台分頁前台分頁前台分頁前台分頁前台分頁
	//自定義查詢 : 在獲得全部的數據之後再進行分頁
	public Page<ShopDetailBean> findAllByPage(Pageable pageable) {
	    List<ShopDetailBean> allData = sRepo.findAll();
	    int start = (int) pageable.getOffset();
	    int end = (start + pageable.getPageSize()) > allData.size() ? allData.size() : (start + pageable.getPageSize());
	    return new PageImpl<>(allData.subList(start, end), pageable, allData.size());
	}
	
	//
	public List<ShopDetailBean> findByPriceLow() {
		List<ShopDetailBean> list = sRepo.findAllOrderByLowPrice();
		return list;
	}
	public List<ShopDetailBean> findByPriceHigh() {
		List<ShopDetailBean> list = sRepo.findAllOrderByHightPrice();
		return list;
	}
	

	public List<ShopDetailBean> findByProductno(String productno){
		int productnoint = Integer.parseInt(productno);
		List<ShopDetailBean> list = sRepo.findByProductno(productnoint);
		return list;
	}
	
	//前台做模糊搜尋
	public List<ShopDetailBean> findByProductname(String productname){
		List<ShopDetailBean> list = sRepo.findbyProductname(productname);
		return list;
	}
	
	//前台依分類產生產品
	public List<ShopDetailBean> findByType(String type){
		List<ShopDetailBean> list = sRepo.findbyType(type);
		return list;
	}


	//	CRUD
	public void insertProduct(ShopDetailBean sBean) {
		sRepo.save(sBean);
	}

	public void updateByProductno(ShopDetailBean sBean) {
		sRepo.saveAndFlush(sBean);
	}
	
	public void delete(ShopDetailBean sBean) {
		sRepo.delete(sBean);
	}
	
	//圖片處理邏輯	
	public ShopDetailBean findImgByProductno(String productno) throws SQLException {
		int productnoint = Integer.parseInt(productno);
		Optional<ShopDetailBean> op =  sRepo.findById(productnoint);
		ShopDetailBean shopdetailBean = null;
		if(op.isPresent()) {
			shopdetailBean = op.get();
		}
		return shopdetailBean;
	}
	
	//多圖
		//新增多圖
		public ShopDetailImgsBean addMultiImgs(ShopDetailImgsBean imgsBean) {
			
			siRepo.save(imgsBean);
			return imgsBean;
		}
		
		//修改車輛多圖
		public ShopDetailImgsBean updateMultiImgsByProductno(ShopDetailImgsBean imgsBean) {
			
			ShopDetailImgsBean multiImgsBean = siRepo.save(imgsBean);
			return multiImgsBean;
		}
		
	
	//查詢多圖中的一張圖
		public ShopDetailImgsBean findsingleImgByImgno(int imgNo) {

			Optional<ShopDetailImgsBean> op = siRepo.findById(imgNo);
			
			return op.get();
		}
		
	//查詢產品下全部多圖
		public List<ShopDetailImgsBean> findMultiImgsByProductno(int productno){
			System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxproductnoxxxxxxxxxxxxxxxxxxxxxxxxxxx" + productno);
			List<ShopDetailImgsBean> shopDetailImgsBean = siRepo.findMultiImageByProductno(productno);
//			int imgsnotest = shopDetailImgsBean.get(0).g;
//			System.out.println("ServiceOUTxxxxxxxxxxxxxxxxxxxxxxxxxxxxxximgsnoxxxxxxxxxxxxxxxxxxxxxxxxxxximgsno=" + imgsnotest);
			return shopDetailImgsBean;
		}
	
		//查詢車輛底下多圖中的一張照片
		public ShopDetailImgsBean findsingleImgByImgsNo(int imgNo) {
			Optional<ShopDetailImgsBean> op = siRepo.findById(imgNo);
			
			return op.get();
		}
		
		//刪除多圖的Service
		public void deleteMultiImgsByProductno(int productno) {
			siRepo.deleteByProductno(productno);
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
