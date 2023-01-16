package iSpancar.cart.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.ui.Model;
import iSpancar.cart.model.CartBean;
import iSpancar.cart.service.CartService;

@Controller
public class CartController {
	
	@Autowired
	private CartService cService;

//	@PostMapping("/cart")
	@RequestMapping(path="/cartInsert.controller" , method= RequestMethod.POST)
//	@ResponseBody
	public String cartInsert(@RequestParam("memberId") String memberId,
			@RequestParam("productNumber") String productNumber,
			@RequestParam("productName") String productName,
			@RequestParam("productPrice") String productPrice,
			@RequestParam("quantity") String quantity ) {
		CartBean cBean = new CartBean();
		cBean.setMemberId(memberId);
		cBean.setProductName(productName);
		cBean.setProductNumber(productNumber);
		cBean.setProductPrice(productPrice);
		cBean.setQuantity(quantity);
		cService.insertCartBean(cBean);
		return "redirect:Shop_Cart.controller";
	}
	
//	@DeleteMapping("/deletecart")
	@RequestMapping(path="/cartdeletecart.controller" , method= RequestMethod.POST)
	public  String cartDelete (@RequestParam ("cartId") String cartId) {
		cService.deletecartById(cartId);
		return "redirect:/QueryAllCart.controller";

	}
	
//	@PutMapping("/cart/{cartId}") 
	@RequestMapping(path="/cartUpdate.controller" , method= RequestMethod.POST)
	public String cartUpdate(@RequestParam ("cartId") String cartId,
			@RequestParam ("quantity") String quantity) {
		cService.updateQuantityByCartId(quantity,cartId);
		return "redirect:/QueryAllCart.controller";

	}
	
	
	@GetMapping("/cart") 
	@RequestMapping(path="/QueryAllCart.controller" , method= RequestMethod.GET)
	public String cartQueryAll (Model cart) {
		Collection<CartBean>  coll = cService.findAllCart() ;
	
		cart.addAttribute("AllCart", coll);

		
		return  "Cart/cart";
	}
	
//	@GetMapping("/cart/{memberId}") 
	@RequestMapping(path="/cartQueryAllCartById.controller" , method= RequestMethod.POST)
	public String cartQueryAllCartById(@RequestParam ("memberId") String memberId,Model cart
			) {
		Collection<CartBean>  coll = cService.findAllById(memberId) ;

		cart.addAttribute("AllCartById", coll);
		return "order/orderForm";
	}
	
	
	
}
