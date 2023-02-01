package iSpancar.member.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import iSpancar.member.model.MemberBean;
import iSpancar.member.service.MemberService;

@Controller
@SessionAttributes("LoginOK")
public class checkAccountPasswordController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping(path = "/checkAccountPassword.controller",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String processAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword") String memberpassword,Model m) {
		try {
			String checkString = memberService.checkaccountnumberpassword(accountnumber, memberpassword);

			if(checkString.equals("資料正確")) {
				List<MemberBean> mBean = memberService.findbyaccountnumber(accountnumber);
	
				m.addAttribute("LoginOK", mBean.get(0));
			}
			
			return checkString;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	@PostMapping(path = "/checkAccount.controller",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String processAction(@RequestParam("accountnumber") String accountnumber) {
		boolean check;
		try {
			check = memberService.checkaccountnumber(accountnumber);
			if(check) {
			return "帳號已存在";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return  "OK";
	}
}
