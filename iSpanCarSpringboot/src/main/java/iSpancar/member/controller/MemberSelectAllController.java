package iSpancar.member.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import iSpancar.member.model.MemberBean;
import iSpancar.member.model.PermissionsOfPosition;
import iSpancar.member.service.MemberService;

@Controller
public class MemberSelectAllController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/memberselectall.controller")
	public String processAction(Model model) {
		
		try {
			List<MemberBean> list = memberService.findAll();
			model.addAttribute("selectAll", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "member/MemberSelectAll";
		
	}
	
	@GetMapping("/memberposition.controller")
	public String processPositionAction(Model model) {
		
		List<PermissionsOfPosition> list = memberService.findAllPermissions();
		model.addAttribute("selectAll", list);
		
		return "member/memberposition";
	}
}
