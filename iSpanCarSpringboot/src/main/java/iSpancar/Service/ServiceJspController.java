package iSpancar.Service;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ServiceJspController {
	
	@GetMapping("/service.deleteService")
	public String servicedeletController() {
		return "service/DeleteService3";
	}
	@GetMapping("/service.SelectAllService")
	public String selectAllServiceController() {
		return "service/SelectallService";
	}
	@GetMapping("/service.SelectService")
	public String selectServiceController() {
		return "service/SelectService3";
	}
	@GetMapping("/service.signinService")
	public String signinServiceController() {
		return "service/signin2";
	}
	@GetMapping("/service.UpdateService")
	public String serviceUpdateController() {
		return "service/UpdateService3";
	}
}
