package iSpancar.member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.member.model.MemberBean;
import iSpancar.member.service.MemberService;

@Controller
public class MemberCrud {
	
	@Autowired
	private MemberService memberService;
	
	@PostMapping("/memberdelete.controller")
	@ResponseBody
	public String processDeleteAction(@RequestParam("accountnumber") String accountnumber) {
		try {
			memberService.deleteByAccountnumber(accountnumber);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "delete";
	}
	
	@PostMapping("/memberupdate.controller")
	@ResponseBody
	public List<MemberBean> processUpdateAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword") String memberpassword,@RequestParam("memberName") String memberName
			,@RequestParam("phonenumber") String phonenumber,@RequestParam("email") String email,@RequestParam("memberaddress") String memberaddress,@RequestParam String platenumber
			,@RequestParam("birthday") String birthday,@RequestParam("idnumber") String idnumber,@RequestParam("cardnumber") String cardnumber) {
		List<MemberBean> list = new ArrayList<MemberBean>();
		MemberBean mb = new MemberBean(accountnumber, memberpassword, memberName, phonenumber, email, memberaddress, platenumber, birthday, idnumber,cardnumber);
		try {
			memberService.updateByAccountnumber(mb);
			MemberBean newMemberBean = memberService.findbyaccountnumberwithoutimage(accountnumber);
			list.add(newMemberBean);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	@PostMapping("/memberupdatecancel.controller")
	@ResponseBody
	public List<MemberBean> processUpdateCancel(@RequestParam("accountnumber") String accountnumber){
		List<MemberBean> list = new ArrayList<>();
		try {
			MemberBean newMemberBean = memberService.findbyaccountnumberwithoutimage(accountnumber);
			list.add(newMemberBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	@PostMapping("/memberupdateimg.controller")
	@ResponseBody
	public void processUpdateAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("file") MultipartFile mf) {
		try {
			byte[] bytes = mf.getBytes();
			
			if(bytes.length==0) {
				
			}else {
				Blob blob = new SerialBlob(bytes);
			
				memberService.updateImgByAccount(accountnumber, blob);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
		
	

}
