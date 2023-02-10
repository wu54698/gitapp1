package iSpancar.carDealer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarDealerJspController {
	
	@GetMapping("/backstage/CarDealerForm")
	public String processViewController() {
		return "Car-Dealer/CarDealerForm_frame";
	}
	
	@GetMapping("/UpdateDealer")
	public String processUpdateController() {
		return "Car-Dealer/UpdateDealer_frame";
	}
	
	@GetMapping("/SelectDealer")
	public String processSelectController() {
		return "Car-Dealer/SelectDealer_frame";
	}
	
	@GetMapping("/SelectAllDealer")
	public String processSelectAllController() {
		return "Car-Dealer/SelectAllDealer_frame";
	}
	
}
