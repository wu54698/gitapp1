package iSpancar.orderservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class OrderServiceJspController {
	@GetMapping("/service.signinorderService")
	public String orderserviceinserController() {
		return "/orderservice/addorder";
	}
	
		@GetMapping("/order.clientOrder")
		public String clientOrderController() {
			return "/orderservice/clientorder";
		}
	
	@GetMapping("/orderserviceSelect")
	public String clientOrderselect() {
		return "/orderservice/selectorderservice";
	}
}
