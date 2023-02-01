package iSpancar.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailDao;
import iSpancar.shop.service.ShopDetailService;

@Controller
public class ProductListControllerFront {

	@Autowired
	private ShopDetailService service;

	@GetMapping("/iSpancarShop.ProductListAllShopPage")
	public String processQueryAllShopPage(Model m) {
		
		List<ShopDetailBean> list = service.findAll();
		m.addAttribute("queryallproduct", list);
		
		return "SHOP_DETAIL/iSpanCarShop";
	}
	
	@GetMapping("/iSpancarShop.SearchResultShopPage")
	public String processSearchResultShopPage(@RequestParam("productname") String productname,Model m) {
		List<ShopDetailBean> list = service.findByProductname(productname);
		m.addAttribute("queryallproduct",list);
		return "SHOP_DETAIL/iSpanCarShop";
	}
	
	@GetMapping("/iSpancarShop.DetailShopPage")
	public String processDetailShopPage(@RequestParam("productname") String productname,Model m) {
		System.out.println(productname);
		List<ShopDetailBean> list = service.findByProductname(productname);
		m.addAttribute("productdetail",list);
		return "SHOP_DETAIL/iSpanCarShopDetail";
	}

	@GetMapping("productimgfront.controller")
	@ResponseBody
	public byte[] processProductImgAction(@RequestParam("productno") String productno) {
		try {
			ShopDetailBean sBean = service.findImgByProductno(productno);
			InputStream is = sBean.getProductimage().getBinaryStream();
			
			return IOUtils.toByteArray(is);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
//	@PostMapping("/iSpancarShop.SendIdToUpdate.controller")
//	public String processSendIdToUpdateAction(@RequestParam("productno") String productno,Model m) {
//		List<ShopDetailBean> list = service.findByProductno(productno);
//		m.addAttribute("sentno",list);
//		return "SHOP_DETAIL/UpdateProduct_form";
//	}
	
	@GetMapping("/iSpancarShop.rtrtr")
	public String forward2() {
		return "forward:/WEB-INF/jsp/SHOP_DETAIL/iSpanCarShopDetail.jsp";
	}

	
	
}
        


