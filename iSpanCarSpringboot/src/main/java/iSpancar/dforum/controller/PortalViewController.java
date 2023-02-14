package iSpancar.dforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalViewController {

	@GetMapping("/dforum/home")
	public String threadsView2() {
		return "dforum/home";
	}
}
