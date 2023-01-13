package iSpancar.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import iSpancar.member.service.MemberService;

@Controller
@SessionAttributes("LoginOK")
public class LogoutController {

	@GetMapping("/logout.controller")
	public String processLogoutAction(SessionStatus status) {
		status.setComplete();
		return "redirect:index";
	}
}
