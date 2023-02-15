package iSpancar.orderservice;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import iSpancar.member.service.EmailSenderService;


@Controller
public class OrderServiceClientController {
	
	@Autowired
	private OrderServiceService oService;
	@Autowired
	private EmailSenderService emailSenderService;
	
	@PostMapping("/orderserviceclientInsert.controller")
	public String serviceInsert(@RequestParam("ordername") String ordername, 
								@RequestParam("orderemail") String orderemail, 
			                    @RequestParam("orderphonenumber") String orderphonenumber,
			                    @RequestParam("orderdate") String orderdate,
			                    @RequestParam("ordertime") String ordertime,
			                    @RequestParam("orderproduct") String orderproduct,
			                    @RequestParam("orderremarks") String orderremarks,
			                    @RequestParam("servicename")String servicename) throws IOException, SQLException, MessagingException
	{
		OrderServiceBean oBean = new OrderServiceBean();
		oBean.setOrdername(ordername);
		oBean.setOrderemail(orderemail);
		oBean.setOrderphonenumber(orderphonenumber);
		oBean.setOrderdate(orderdate);
		oBean.setOrdertime(ordertime);
		oBean.setOrderproduct(orderproduct);
		oBean.setOrderremarks(orderremarks);
		oBean.setServicename(servicename);
		
		oService.insert(oBean);
		String htmltext = "<body>\r\n"
			    + "<div>親愛的會員您好：</div>\r\n"
			    + "<div>您的預約已成功</div>\r\n"
			    + "</body>\r\n";
		emailSenderService.sendEmail("a0926855118@gmail.com", "資車會預約通知", htmltext);
		
		return "/orderservice/clientordersuccess";
	}
	
	@PostMapping("/JumptoOrderService")
	public String JumptoOrderService(@RequestParam("ordername") String ordername, Model m) {

		OrderServiceBean o1 = oService.findbyId(ordername);
		List<OrderServiceBean> list = new ArrayList<OrderServiceBean>();
		list.add(o1);
		System.out.println(list.size());
		m.addAttribute("get", list);

		return "orderservice/clientorder";
	}
	
	 @GetMapping("/OrderServicename")
	 public String OrderServicename(@RequestParam("Servicename") String serviceName, Model m) {
	  
	  m.addAttribute("serviceName", serviceName);
	  return "orderservice/clientorder";
	 }
	 

	
}
