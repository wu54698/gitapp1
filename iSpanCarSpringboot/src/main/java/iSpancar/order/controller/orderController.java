package iSpancar.order.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;

import javax.servlet.ServletException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iSpancar.cart.model.CartBean;
import iSpancar.cart.service.CartService;
import iSpancar.order.model.OrderBean;
import iSpancar.order.service.OrderService;
import iSpancar.orderItem.model.OrderItemBean;
import iSpancar.orderItem.service.OrderItemService;

@Controller
@RequestMapping("/backstage")
public class orderController {

	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private OrderItemService oiService;
	
	@Autowired
	private CartService cService;
	
	public java.sql.Timestamp stringToSqlDate() throws ParseException {

		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		java.sql.Timestamp sdate = new java.sql.Timestamp(date.getTime());
		return sdate;
	}
	
//	@PostMapping("/order")
	@PostMapping("/orderInsert.controller")
	@RequestMapping(path="/orderInsert.controller" , method= RequestMethod.POST)
	public String orderInsert(@RequestParam("orderStatus") String orderStatus,
//			@RequestParam("paidSate") String paidSate,
			@RequestParam("paidMethod") String paidMethod,
			@RequestParam("deliveryAddress") String deliveryAddress,
			@RequestParam("orderName") String orderName,
			@RequestParam("orderPhone") String orderPhone,
			@RequestParam("totalPrice") String totalPrice,
			@RequestParam("memberId") String memberId,
			@RequestParam("cartId") String cartId,
			@RequestParam( value ="productNumber[]") String[] productNumber,
			@RequestParam( value ="productName[]") String[] productName,
			@RequestParam( value ="quantity[]") String[] quantity,
			@RequestParam( value ="productPrice[]") String[] productPrice
			) throws ParseException, SQLException  {
		String paidSate = "";
		java.sql.Timestamp orderDate = stringToSqlDate();
	
		String orderId = memberId + cartId;
		OrderBean bean = new OrderBean(orderId, orderDate, orderStatus, paidSate, paidMethod, deliveryAddress,
				orderName, orderPhone, totalPrice);
		oService.insertOrderBean(bean);
		
		for (int i = 0; i < productNumber.length; i++) {
			String productNumbe = productNumber[i];
			String productNam = productName[i];
			String quantit = quantity[i];
			String productPric = productPrice[i];

			OrderItemBean oibean = new OrderItemBean(orderId, productNumbe, productNam, quantit, productPric);

			oiService.insertOrderItemBean(oibean);
		}
		
		cService.deleteCartByMemberId(memberId);
		
		
		return "redirect:orderQueryAll.controller";

	}
	
	
	
	@PutMapping("/order/{orderId}") 
	@RequestMapping(path="/orderUpdate.controller" , method= RequestMethod.POST)
	public String orderUpdate(@RequestParam("orderId") String orderId,
			@RequestParam ("orderStatus") String orderStatus) throws SQLException, ParseException {
		java.sql.Timestamp orderDate = stringToSqlDate();

		oService.updateOrderSatusByOrderId(orderStatus, orderDate, orderId);
		
		return "redirect:orderQueryAll.controller";
		
	}
	
	@GetMapping("/order") 
	@RequestMapping(path="/orderQueryAll.controller" , method= RequestMethod.GET)
	public String orderQueryAll (Model order) throws Exception {
		Collection<OrderBean>  coll = oService.findAllOrder() ;
		order.addAttribute("AllOrder", coll);
		Collection<OrderItemBean>  oicoll = oiService.findAllOrderItem() ;
		order.addAttribute("AllOrderItme", oicoll);

		
		return  "order/order";
	}
	
}
