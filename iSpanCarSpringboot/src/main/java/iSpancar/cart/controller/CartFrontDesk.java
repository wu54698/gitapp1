package iSpancar.cart.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;
import iSpancar.cart.model.CartBean;
import iSpancar.cart.service.CartService;
import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.service.ShopDetailService;

@Controller
public class CartFrontDesk {

	@Autowired
	private CartService cService;

	@Autowired
	private ShopDetailService service;
	
	//新增商品至購物車
	 @RequestMapping(path="/cartInsert.controller" , method= RequestMethod.POST)
	 public void cartInsert(@RequestParam("memberId") String memberId,
	   @RequestParam("productNumber") String productNumber,@RequestParam("quantity") String quantity ) {
	  CartBean cBean = new CartBean();
	  cBean.setMemberId(memberId);
	  cBean.setProductNumber(productNumber);
	  cBean.setQuantity(quantity);
	  cService.insertCartBean(cBean);
	 }
	
	
	//將商品從購物車移除
	@RequestMapping(path="/cartdeletecart.controller" , method= RequestMethod.POST)
	public @ResponseBody Object cartDelete (@RequestParam ("cartId") String cartId) {
		System.out.println("cartId: " + cartId);
		
			cService.deletecartById(cartId);
			System.out.println("刪除成功");
			Map<String, Object> result = new HashMap<>();
			  result.put("success", true);
			 
			  
			return result;
		
	}
	
	//更改購物車商品的購買數量
	@PostMapping("/cartInsert")
	public String cartInsertQuantity(@RequestParam("quantity") String quantity,
			@RequestParam("cartId") String cartId
			) {
		
		cService.updateQuantityByCartId(quantity,cartId);
		return "/Cart/cart";
	}
	
	
	//查詢購物車商品
//	@RequestMapping(path="/cartQueryAllCartById.controller" , method= RequestMethod.POST)
	@PostMapping("/cart") 
	public String cartQueryAllCartByIdpost(@RequestParam ("memberId") String memberId,Model cart, Model shopDetailMapModel
			) {
		Collection<CartBean>  coll = cService.findAllById(memberId) ;
		Map<Integer, ShopDetailBean> shopDetailMap = new HashMap<>();
		List<ShopDetailBean> list = service.findAll();
		for (ShopDetailBean shopDetail : list) {
			shopDetailMap.put(shopDetail.getProductno(), shopDetail);
		}
		shopDetailMapModel.addAttribute("shopDetailMap", shopDetailMap);
		cart.addAttribute("AllCartById", coll);
		return "/Cart/cart";
	}
	
	@GetMapping("/cart") 
	public String cartQueryAllCartByIdget(Principal principal,Model cart, Model shopDetailMapModel
			) {
		if(principal == null) {
			return "login/login";
		}else {
			String memberId = principal.getName();
			System.out.println(memberId);
			Collection<CartBean>  coll = cService.findAllById(memberId) ;
			Map<Integer, ShopDetailBean> shopDetailMap = new HashMap<>();
			List<ShopDetailBean> list = service.findAll();
			for (ShopDetailBean shopDetail : list) {
				shopDetailMap.put(shopDetail.getProductno(), shopDetail);
			}
			shopDetailMapModel.addAttribute("shopDetailMap", shopDetailMap);
			cart.addAttribute("AllCartById", coll);
			return "/Cart/cart";
		}
	}
	
	//訂單確認
	@GetMapping("/checkout") 
	public String checkout(@RequestParam ("memberId") String memberId,Model cart, Model shopDetailMapModel
			) {
		Collection<CartBean>  coll = cService.findAllById(memberId) ;
		
		Map<Integer, ShopDetailBean> shopDetailMap = new HashMap<>();
		List<ShopDetailBean> list = service.findAll();
		for (ShopDetailBean shopDetail : list) {
			shopDetailMap.put(shopDetail.getProductno(), shopDetail);
		
		}
		shopDetailMapModel.addAttribute("shopDetailMap", shopDetailMap);
		
		cart.addAttribute("AllCartById", coll);
		return "/Cart/finalcheckout";
	}
	
	//訂單確認
	@GetMapping("/CartfinalCheckout")
	public String processViewController4(@RequestParam ("memberId") String memberId,Model cart, Model shopDetailMapModel
			,HttpServletRequest request, Model model) {
	  HttpSession session = request.getSession();
	  String orderName = (String) session.getAttribute("orderName");
	  String orderPhone = (String) session.getAttribute("orderPhone");
	  String payment = (String) session.getAttribute("payment");
	  String deliveryAddress = (String) session.getAttribute("deliveryAddress");
	  model.addAttribute("orderName", orderName);
	  model.addAttribute("orderPhone", orderPhone);
	  model.addAttribute("payment", payment);
	  model.addAttribute("deliveryAddress", deliveryAddress);
	  Collection<CartBean>  coll = cService.findAllById(memberId) ;
		
		Map<Integer, ShopDetailBean> shopDetailMap = new HashMap<>();
		List<ShopDetailBean> list = service.findAll();
		for (ShopDetailBean shopDetail : list) {
			shopDetailMap.put(shopDetail.getProductno(), shopDetail);
		
		}
		shopDetailMapModel.addAttribute("shopDetailMap", shopDetailMap);
		
		cart.addAttribute("AllCartById", coll);
	  return "Cart/finalcheckout";
	}
	
	
	@GetMapping("/CartCheckout")
	public String processViewController3() {
		return "/Cart/checkout";
	}
	
	
}