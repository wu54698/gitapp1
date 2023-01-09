package iSpancar.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iSpancar.member.service.MemberService;

@Controller
public class checkAccountPasswordController {

	@Autowired
	private MemberService memberService;
	
	@PostMapping(path = "/checkAccountPassword.controller",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String processAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword") String memberpassword) {
		try {
			String checkString = memberService.checkaccountnumberpassword(accountnumber, memberpassword);
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
