package iSpancar.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MemberJspController {
	
	@GetMapping("/memberInsert")
	public String processViewController() {
		return "member/insertMember";
	}

	@GetMapping("/index")
	public String processIndexViewController() {
		return "index";
	}
	
	@GetMapping("/login")
	public String processLoginController() {
		return "login/login";
	}
}