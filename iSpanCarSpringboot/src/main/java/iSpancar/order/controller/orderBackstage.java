package iSpancar.order.controller;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.ArrayList;
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
import iSpancar.member.service.MemberService;
import ecpay.payment.integration.AllInOne;
import ecpay.payment.integration.domain.AioCheckOutALL;
import iSpancar.order.model.OrderBean;
import iSpancar.order.service.OrderService;
import iSpancar.orderItem.model.OrderItemBean;
import iSpancar.orderItem.service.OrderItemService;
import iSpancar.shop.model.ShopDetailBean;
import iSpancar.shop.service.ShopDetailService;

@Controller
@RequestMapping("/backstage")
public class orderBackstage {
	
	@Autowired
	private OrderService oService;
	
	@Autowired
	private OrderItemService oiService;
	
	@Autowired
	private CartService cService;
	
	@Autowired
	private ShopDetailService service;
	
	@Autowired
	private MemberService mService;

	
	private java.sql.Timestamp stringToSqlDate() {
	    java.util.Date date = new java.util.Date();
	    return new java.sql.Timestamp(date.getTime());
	}
	

	
	
	@RequestMapping(path="/orderUpdate.controller" , method= RequestMethod.POST)
	public @ResponseBody Object orderUpdate(@RequestParam("orderId") String orderId,
	    @RequestParam ("orderStatus") String orderStatus) throws SQLException, ParseException {
	  java.sql.Timestamp orderDate = stringToSqlDate();
	  
	  oService.updateOrderSatusByOrderId(orderStatus, orderDate, orderId);
	  
	  Map<String, Object> result = new HashMap<>();
	  result.put("success", true);
	  result.put("newDate", orderDate);
	  
	  return result;
	}
	//查詢全部訂單
	@GetMapping("/orderBack") 
	public String orderQueryAll2 (Model order) throws Exception {
		Collection<OrderBean>  coll = oService.findAllOrder() ;
		order.addAttribute("AllOrder", coll);
		Collection<OrderItemBean>  oicoll = oiService.findAllOrderItem() ;
		order.addAttribute("AllOrderItme", oicoll);
		return  "order/orderBack";
	}
	
	//查詢訂單明細
	@PostMapping("/orderEdit")
	public String processViewController4(@RequestParam("orderId") String orderId,Model order, Model shopDetailMapModel)throws Exception  {
		Collection<OrderBean>  coll = oService.findOrderByOrderId(orderId);
		order.addAttribute("AllOrder", coll);

		Collection<OrderItemBean>  oicoll =oiService.findOrderItemByOrderId(orderId) ;
		order.addAttribute("AllOrderItme", oicoll);
		Map<Integer, ShopDetailBean> shopDetailMap = new HashMap<>();
		List<ShopDetailBean> list = service.findAll();
		for (ShopDetailBean shopDetail : list) {
			shopDetailMap.put(shopDetail.getProductno(), shopDetail);
		}
		shopDetailMapModel.addAttribute("shopDetailMap", shopDetailMap);
	
		OrderBean orderBean = coll.iterator().next();
		String memberId = orderBean.getAccountnumber();
		Collection<MemberBean> mcoll= mService.findbyaccountnumber(memberId);
		order.addAttribute("Orderdata", mcoll);
		return "/order/orderEdit";
	}
	
	//訂單圖表
	@GetMapping("/orderChart")
	public String processViewController1(Model order) throws Exception{
		Collection<OrderBean>  coll = oService.findAllOrder() ;
		order.addAttribute("AllOrder", coll);
		Collection<OrderItemBean>  oicoll = oiService.findAllOrderItem() ;
		order.addAttribute("AllOrderItme", oicoll);

		LocalDate today = LocalDate.now();
		long todayTotalPrice = 0;
		long thisMonthTotalPrice = 0;
		long yearTotalPrice = 0;

		for (OrderBean orders : coll) {
			LocalDate orderDate = orders.getOrderDate().toLocalDateTime().toLocalDate();
			if (orderDate.compareTo(today) == 0) {
				todayTotalPrice += Long.parseLong(orders.getTotalPrice());
			}
			if (orderDate.getMonthValue() == today.getMonthValue()) {
				thisMonthTotalPrice += Long.parseLong(orders.getTotalPrice());
			}
			if (orderDate.getYear() == today.getYear()) {
				yearTotalPrice += Long.parseLong(orders.getTotalPrice());
			}
		}
		order.addAttribute("todayTotalPrice", todayTotalPrice);
		order.addAttribute("thisMonthTotalPrice", thisMonthTotalPrice);
		order.addAttribute("yearTotalPrice", yearTotalPrice);

		
		return "/order/orderChart";
	}
	
	@GetMapping("/orderCharts")
	public @ResponseBody Map<String, Object> processViewController1() throws Exception{
	  Map<String, Object> result = new HashMap<>();
	  LocalDate today = LocalDate.now();
	  DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
	  String todayStr = today.format(formatter);

	  Collection<OrderBean>  thisMonthOrders = oService.findOrdersByMonth(todayStr);
	 
//	  Map<String, Integer> orderDateToQuantity = new HashMap<>();
//	  for (OrderBean order : thisMonthOrders) {
//	  String orderId = order.getOrderId();
//	  Collection<OrderItemBean> oicoll = oiService.findOrderItemByOrderId(orderId);
//	  int quantity = 0;
//	  for (OrderItemBean orderItem : oicoll) {
//	  quantity += Integer.parseInt(orderItem.getQuantity());
//	  }
//	  String orderDate = order.getOrderDate().toString();
//	  if (orderDateToQuantity.containsKey(orderDate)) {
//	      orderDateToQuantity.put(orderDate, orderDateToQuantity.get(orderDate) + quantity);
//	  } else {
//	      orderDateToQuantity.put(orderDate, quantity);
//	  }
//	  }
	  
	  Map<String, Integer> orderDateToQuantity = new HashMap<>();
	  for (OrderBean order : thisMonthOrders) {
	    String orderId = order.getOrderId();
	    Collection<OrderItemBean> oicoll = oiService.findOrderItemByOrderId(orderId);
	    int quantity = 0;
	    for (OrderItemBean orderItem : oicoll) {
	      quantity += Integer.parseInt(orderItem.getQuantity());
	    }
	    Date orderDate = order.getOrderDate();
	    SimpleDateFormat formatter2 = new SimpleDateFormat("yyyy-MM-dd");
	    String orderDateStr = formatter2.format(orderDate);
	    if (orderDateToQuantity.containsKey(orderDateStr)) {
	      orderDateToQuantity.put(orderDateStr, orderDateToQuantity.get(orderDateStr) + quantity);
	    } else {
	      orderDateToQuantity.put(orderDateStr, quantity);
	    }
	  }
	  result.put("OrderIdToQuantity", orderDateToQuantity);
	  result.put("ThisMonthOrders", thisMonthOrders);

	  return result;
	}
	
}
