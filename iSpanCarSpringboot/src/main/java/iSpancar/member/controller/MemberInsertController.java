package iSpancar.member.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.member.model.MemberBean;
import iSpancar.member.service.MemberService;

@Controller
public class MemberInsertController {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("memberinsert.controller")
	public String processInsertAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword") String memberpassword,@RequestParam("membername") String membername,
			@RequestParam("phonenumber") String phonenumber,@RequestParam("email") String email,@RequestParam("city") String city,@RequestParam("town") String town,
			@RequestParam("memberaddress") String memberaddress,@RequestParam("platenumber") String platenumber,@RequestParam("year") String year,@RequestParam("month") String month,
			@RequestParam("date") String date,@RequestParam("idnumber") String idnumber,@RequestParam("card1") String card1,@RequestParam("card2") String card2,
			@RequestParam("card3") String card3,@RequestParam("card4") String card4,@RequestParam("file") MultipartFile mf) {
		try {
		int borthdaylength = month.length();
		month = month.substring(0,borthdaylength-5);
		String birthday = year.substring(0,4) +"-"+ month +"-"+ date;
		
		String cardnumber = card1 + "-" + card2 + "-" + card3 + "-" + card4;
		
		String filename = mf.getOriginalFilename();
		
		byte[] bytes = mf.getBytes();
		
		Blob blob = null;
		if(bytes.length==0) {
			
		}else {
			blob = new SerialBlob(bytes);
		}
		
		
		MemberBean bean = new MemberBean(accountnumber, memberpassword, membername, phonenumber, email, city+town+memberaddress, platenumber, birthday, idnumber, cardnumber,blob,filename);
		memberService.insertMemberBean(bean);
		
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "index";
	}

}
