package iSpancar.dforum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PortalViewController {

	@GetMapping("/test")
	public String threadsView() {
		return "dforum/test";
	}
}
