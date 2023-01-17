package iSpancar.member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.member.model.MemberBean;
import iSpancar.member.model.PermissionsOfPosition;
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
			,@RequestParam("birthday")@Nullable String birthday,@RequestParam("idnumber") String idnumber,@RequestParam("cardnumber") String cardnumber) {
		List<MemberBean> list = new ArrayList<MemberBean>();

		try {
			Date birthDate = null;
			if(!birthday.equals("")) {
			 birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			}
		MemberBean oldmb = memberService.findbyaccountnumberwithoutimage(accountnumber);
		MemberBean mb = new MemberBean(accountnumber, oldmb.getMemberpassword(), memberName, phonenumber, email, memberaddress, platenumber, birthDate, idnumber,cardnumber);
			MemberBean mBean = memberService.updateByAccountnumber(mb);
			mBean.setFile(null);//json格式中有BLOB會錯誤
			list.add(mBean);
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
		//---------------------------------權限---------------------------------------
	@PostMapping("/permissionupdate.controller")
	@ResponseBody
	public List<PermissionsOfPosition> processUpdatePermission(@RequestBody List<PermissionsOfPosition> list) {
		
		for(PermissionsOfPosition pop : list) {
			memberService.updatePermission(pop);
		}
		
		return list;
	}
	

}
