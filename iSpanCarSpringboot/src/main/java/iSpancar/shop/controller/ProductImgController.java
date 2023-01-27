package iSpancar.shop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailDao;
import iSpancar.shop.service.ShopDetailService;
@Controller
public class ProductImgController {

	@Autowired
	private ShopDetailService service;
	
	@GetMapping("productimg.controller")
	@ResponseBody
	public byte[] processProductImgAction(@RequestParam("productno") String productno) {
		System.out.println("aaaaaaaaaaaaaaaaaaa");
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
	
}
