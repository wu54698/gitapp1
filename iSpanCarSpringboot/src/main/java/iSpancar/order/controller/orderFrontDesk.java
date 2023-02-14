package iSpancar.order.controller;


import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.print.DocFlavor.URL;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iSpancar.cart.service.CartService;
import iSpancar.member.model.MemberBean;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import iSpancar.order.model.OrderBean;
import iSpancar.order.service.OrderService;
import iSpancar.orderItem.model.OrderItemBean;
import iSpancar.orderItem.service.OrderItemService;
import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.service.ShopDetailService;

@Controller
@SessionAttributes("LoginOK")

public class orderFrontDesk {
	
	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private OrderItemService oiService;
	
	@Autowired
	private CartService cService;
	
	@Autowired
	private ShopDetailService service;
	
	private java.sql.Timestamp stringToSqlDate() {
	    java.util.Date date = new java.util.Date();
	    return new java.sql.Timestamp(date.getTime());
	}
	
	@PostMapping("/orderInsert.controller")
	@ResponseBody
	public String orderInsert(@RequestParam("orderStatus") String orderStatus,
			@RequestParam("paidMethod") String paidMethod,
			@RequestParam("deliveryAddress") String deliveryAddress,
			@RequestParam("orderName") String orderName,
			@RequestParam("orderPhone") String orderPhone,
			@RequestParam("totalPrice") String totalPrice,
			@RequestParam("memberId") String memberId,
			@RequestParam("cartId") String cartId,
			@RequestParam( value ="productNumber[]") String[] productNumber,
			@RequestParam( value ="productName[]") String[] productName,
			@RequestParam( value ="stock[]") String[] stock,
			@RequestParam( value ="quantity[]") String[] quantity,
			 Model model,RedirectAttributes redirectAttributes ,HttpServletRequest request 	) throws ParseException, SQLException  {
		String paidSate = "未支付";
		java.sql.Timestamp orderDate = stringToSqlDate();
		String orderId = memberId + cartId;
		OrderBean bean = new OrderBean(orderId, orderDate, orderStatus, paidSate, paidMethod, deliveryAddress,orderName, orderPhone, totalPrice,memberId);
		oService.insertOrderBean(bean);
		String itemName = null;
		for (int i = 0; i < productNumber.length; i++) {
			String productNumbe = productNumber[i];
			String cstock = stock[i];
			String quantit = quantity[i];
			String Name = productName[i];
			int nstock =(Integer.parseInt(cstock) - Integer.parseInt(quantit));
			itemName +=Name+"#";
			OrderItemBean oibean = new OrderItemBean(orderId, productNumbe,  quantit);
			
			oiService.insertOrderItemBean(oibean);
			
			service.updateByProductnoStock(nstock,productNumbe);
		}
		
		cService.deleteCartByMemberId(memberId);

		   redirectAttributes.addAttribute("memberId", memberId);

		   String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(orderDate);
		   AllInOne allinone = new AllInOne(null);
			AioCheckOutALL acot = new AioCheckOutALL();
			acot.setMerchantID("2000132");
			acot.setMerchantTradeNo(orderId);
			acot.setMerchantTradeDate(timeStamp);
			acot.setTotalAmount(totalPrice);
			acot.setTradeDesc("限時搶購優惠專案");
			acot.setItemName(itemName);
			acot.setReturnURL("http://localhost:8080/order");
			acot.setClientRedirectURL("http://localhost:8080/order");
			acot.setClientBackURL("http://localhost:8080/order");
			acot.setChooseSubPayment("Credit");
			acot.setNeedExtraPaidInfo("N");
			HttpSession session = request.getSession();
			session.setAttribute("memberid", memberId);
			session.setAttribute("orderId", orderId);

			String form = allinone.aioCheckOut(acot, null);
			return form;

	}
	
	@GetMapping("/order")
	public String processpaysuccess(HttpServletRequest request,Model order, Model shopDetailMapModel  ,Model model) throws Exception {
		HttpSession session = request.getSession();
			MemberBean sessionmb = (MemberBean) model.getAttribute("LoginOK");
			  String memberid = sessionmb.getAccountnumber();

//		String memberid = (String) session.getAttribute("memberid");
		String orderId = (String) session.getAttribute("orderId");
		
		oService.updateOrderpaidSateByOrderId("已支付",orderId);
		
		Collection<OrderBean>  coll = oService.findOrderById(memberid);
		order.addAttribute("AllOrder", coll);
		
		Collection<OrderItemBean>  oicoll = oiService.findAllOrderItem() ;
		order.addAttribute("AllOrderItme", oicoll);
		Map<Integer, ShopDetailBean> shopDetailMap = new HashMap<>();
		List<ShopDetailBean> list = service.findAll();
		for (ShopDetailBean shopDetail : list) {
			shopDetailMap.put(shopDetail.getProductno(), shopDetail);
		
		}
		shopDetailMapModel.addAttribute("shopDetailMap", shopDetailMap);
		
		return "/order/order";
	}


	
}
