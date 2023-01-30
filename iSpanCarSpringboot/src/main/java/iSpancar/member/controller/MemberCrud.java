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

import javax.servlet.ServletRequest;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.member.model.MemberBean;
import iSpancar.member.model.PermissionsOfPosition;
import iSpancar.member.service.MemberService;

@Controller
@RequestMapping("/backstage")
public class MemberCrud {
	
	@Autowired
	private MemberService memberService;
//----------------------select----------------------
	//select all
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
	//select position-------------------權限---------------------
	@GetMapping("/memberposition.controller")
	public String processPositionAction(Model model) {
		
		List<PermissionsOfPosition> list = memberService.findAllPermissions();
		model.addAttribute("selectAll", list);
		
		return "member/memberposition";
	}
	//for ajax
	@PostMapping("/memberpositioncancel.controller")
	@ResponseBody
	public List<PermissionsOfPosition> processPositionActionForCancel() {
		
		List<PermissionsOfPosition> list = memberService.findAllPermissions();
		
		return list;
	}
	//找帳號權限
	@PostMapping("/findmemberposition.controller")
	@ResponseBody
	public PermissionsOfPosition processMemberPosition(@RequestParam("accountnumber") String accountnumber) throws SQLException {
		List<MemberBean> member = memberService.findbyaccountnumber(accountnumber);
		
		return member.get(0).getMemberPosition().getPermissionsofposition();
	}
	
//----------------------insert----------------------
	//insert user
	@PostMapping("memberinsert.controller")
	public String processInsertAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword") String memberpassword,@RequestParam("membername") String membername,
			@RequestParam("phonenumber") String phonenumber,@RequestParam("email") String email,@RequestParam("city") String city,@RequestParam("town") String town,
			@RequestParam("memberaddress") String memberaddress,@RequestParam("platenumber") String platenumber,@RequestParam("year") String year,@RequestParam("month") String month,
			@RequestParam("date")@Nullable String date ,@RequestParam("idnumber") String idnumber,@RequestParam("card1") String card1,@RequestParam("card2") String card2,
			@RequestParam("card3") String card3,@RequestParam("card4") String card4,@RequestParam("file") MultipartFile mf) {
		try {
		String birthday = null;
		Date birthDate = null;
		if(date != null) {
			
			int borthdaylength = month.length();
			month = month.substring(0,borthdaylength-5);
			
			birthday = year.substring(0,4) +"-"+ month +"-"+ date;
			
			birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
		}
		
		String cardnumber = card1 + "-" + card2 + "-" + card3 + "-" + card4;
		
		String filename = mf.getOriginalFilename();
		
		byte[] bytes = mf.getBytes();
		
		Blob blob = null;
		if(bytes.length==0) {
			
		}else {
			blob = new SerialBlob(bytes);
		}
		String encodePwd = new BCryptPasswordEncoder().encode(memberpassword);//密碼加密

		MemberBean bean = new MemberBean(accountnumber, encodePwd, membername, phonenumber, email, city+town+memberaddress, platenumber, birthDate, idnumber, cardnumber,blob,filename);
		memberService.insertForUser(bean);
		
		
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
	//insert employee
	@PostMapping("memberinsertforemployee.controller")
	public String processInsertActionForEmployee(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword") String memberpassword,@RequestParam("membername") String membername,
			@RequestParam("phonenumber") String phonenumber,@RequestParam("email") String email,@RequestParam("city") String city,@RequestParam("town") String town,
			@RequestParam("memberaddress") String memberaddress,@RequestParam("platenumber") String platenumber,@RequestParam("year") String year,@RequestParam("month") String month,
			@RequestParam("date")@Nullable String date ,@RequestParam("idnumber") String idnumber,@RequestParam("card1") String card1,@RequestParam("card2") String card2,
			@RequestParam("card3") String card3,@RequestParam("card4") String card4,@RequestParam("file") MultipartFile mf) {
		try {
			String birthday = null;
			Date birthDate = null;
			if(date != null) {
				
				int borthdaylength = month.length();
				month = month.substring(0,borthdaylength-5);
				
				birthday = year.substring(0,4) +"-"+ month +"-"+ date;
				
				birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			}
			
			String cardnumber = card1 + "-" + card2 + "-" + card3 + "-" + card4;
			
			String filename = mf.getOriginalFilename();
			
			byte[] bytes = mf.getBytes();
			
			Blob blob = null;
			if(bytes.length==0) {
				
			}else {
				blob = new SerialBlob(bytes);
			}
			String encodePwd = new BCryptPasswordEncoder().encode(memberpassword);//密碼加密
			
			MemberBean bean = new MemberBean(accountnumber, encodePwd, membername, phonenumber, email, city+town+memberaddress, platenumber, birthDate, idnumber, cardnumber,blob,filename);
			memberService.insertForEmployee(bean);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return "redirect:memberselectall.controller";
	}
//--------------------delete------------------
	//Delete
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
//----------------------update--------------------
	//update
	@PostMapping("/memberupdate.controller")
	@ResponseBody
	public List<MemberBean> processUpdateAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword")@Nullable String memberpassword,@RequestParam("memberName") String memberName
			,@RequestParam("phonenumber") String phonenumber,@RequestParam("email") String email,@RequestParam("memberaddress") String memberaddress,@RequestParam String platenumber
			,@RequestParam("birthday")@Nullable String birthday,@RequestParam("idnumber") String idnumber,@RequestParam("cardnumber") String cardnumber) {
		List<MemberBean> list = new ArrayList<MemberBean>();

		try {
			Date birthDate = null;
			if(!birthday.equals("")) {
			 birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
			}
			MemberBean oldmb = memberService.findByAccountReturnBean(accountnumber);//找舊的資料
			MemberBean mb = new MemberBean(accountnumber, oldmb.getMemberpassword(), memberName, phonenumber, email, memberaddress, platenumber, birthDate, idnumber,cardnumber);
			MemberBean mBean = memberService.updateByAccountnumber(mb);
			mBean.setFile(null);//json格式中有BLOB會錯誤
			list.add(mBean);
		} catch (SQLException | ParseException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	//updatecancel
	@PostMapping("/memberupdatecancel.controller")
	@ResponseBody
	public List<MemberBean> processUpdateCancel(@RequestParam("accountnumber") String accountnumber){
		List<MemberBean> list = new ArrayList<>();
		try {
			MemberBean newMemberBean = memberService.findByAccountReturnBean(accountnumber);
			newMemberBean.setFile(null);
			newMemberBean.setMemberPosition(null);//不然會無限迴圈
			list.add(newMemberBean);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//updateimage
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
	
	//updatePermission
	@PostMapping("/memberupdateposition.controller")
	@ResponseBody
	public String processUpdatePositionAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("positionfk") String positionfk) {
		memberService.updateMemberPosition(accountnumber, positionfk);
	return positionfk;
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
