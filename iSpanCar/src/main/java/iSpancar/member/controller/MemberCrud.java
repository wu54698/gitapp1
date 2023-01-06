package iSpancar.member.controller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import iSpancar.member.model.MemberBean;
import iSpancar.member.service.MemberService;

@Controller
public class MemberCrud {
	
	@Autowired
	private MemberService memberService;
	
	@DeleteMapping("memberdelete.controller")
	public void processDeleteAction(@RequestBody MemberBean memberBean) {
		try {
			memberService.deleteByAccountnumber(memberBean.getAccountnumber());
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
