package iSpancar.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import iSpancar.member.model.MemberBean;

@Controller
@SessionAttributes("LoginOK")
public class CheckLoginController {

	@GetMapping("/checkogin.controller")
	public String processCheckLogin(Model model) {
		MemberBean sessionmb = (MemberBean) model.getAttribute("LoginOK");
		if(sessionmb==null) {
			return "login/login";
		}
		return "redirect:backstage/memberselectall.controller";
	}
	
}
