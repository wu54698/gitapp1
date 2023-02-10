package iSpancar.member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;

import iSpancar.member.model.MemberBean;
import iSpancar.member.service.MemberService;

@Controller
public class ImageController {
	
	@Autowired
	private MemberService memberService;
	
	@GetMapping("/showimage.controller")
	@ResponseBody
	public byte[] processShowAction(@RequestParam("accountnumber") String accountnumber){
		try {
			MemberBean mBean = memberService.findImgbyaccountnumber(accountnumber);
			InputStream is = mBean.getFile().getBinaryStream();
			
			return IOUtils.toByteArray(is);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@GetMapping("/showimageforthismember.controller")
	@ResponseBody
	public byte[] processShowActionForSession(@RequestParam("accountnumber") String accountnumber){
		try {
			
			MemberBean mBean = memberService.findImgbyaccountnumber(accountnumber);
			
			InputStream is = mBean.getFile().getBinaryStream();
			
			return IOUtils.toByteArray(is);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
