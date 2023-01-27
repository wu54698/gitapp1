package iSpancar.shop.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.model.ShopDetailDao;
import iSpancar.shop.service.ShopDetailService;

@Controller
public class ShopCartController {
	@Autowired
	private ShopDetailService service;
	
	@GetMapping("/iSpancarShop.Shop_Cart.controller")
	public String processToShopCart(Model m) {

		List<ShopDetailBean> list = service.findAll();
		m.addAttribute("queryallproduct", list);

		return "SHOP_DETAIL/Shop_Cart";
	}
}
