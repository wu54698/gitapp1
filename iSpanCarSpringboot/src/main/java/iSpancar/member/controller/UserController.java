package iSpancar.member.controller;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.member.model.MemberBean;
import iSpancar.member.service.MemberService;

@Controller
@SessionAttributes("LoginOK")
public class UserController {
	
	@Autowired
	private MemberService memberService;
	
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
		
		@PostMapping("/findaccountnumber.controller")
		public String processAction(@RequestParam("accountnumber") String accountnumber,Model model) {
			model.addAttribute("accountnumber",accountnumber);
			return "login/resetpassword";
		}
		
		@PostMapping("/changepassword.controller")
		public String processResetPassword(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword") String memberpassword) {
			try {
				MemberBean mBean = memberService.findByAccountReturnBean(accountnumber);
				String encodePwd = new BCryptPasswordEncoder().encode(memberpassword);//密碼加密
				mBean.setMemberpassword(encodePwd);
				memberService.updateByAccountnumber(mBean);
				
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
			return "index";
		}
		
		
		@GetMapping("/testsession.controller")
		@ResponseBody
		public MemberBean processAction3(Model model)
			{
			//MemberBean attribute = (MemberBean) httpSession.getAttribute("LoginOK");
			MemberBean member = (MemberBean) model.getAttribute("LoginOK");
//			MemberBean member2 = new MemberBean();
//			member2.setAccountnumber("54545");
				return member;
			}
		
		//update
		@PostMapping("/usermemberupdate.controller")
		@ResponseBody
		public List<MemberBean> processUpdateAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("memberpassword")@Nullable String memberpassword,@RequestParam("memberName") String memberName
				,@RequestParam("phonenumber") String phonenumber,@RequestParam("email") String email,@RequestParam("memberaddress") String memberaddress,@RequestParam String platenumber
				,@RequestParam("birthday")@Nullable String birthday,@RequestParam("idnumber") String idnumber,@RequestParam("cardnumber") String cardnumber,Model model) {
			List<MemberBean> list = new ArrayList<MemberBean>();

			try {
				Date birthDate = null;
				if(!birthday.equals("")) {
				 birthDate = new SimpleDateFormat("yyyy-MM-dd").parse(birthday);
				}
				MemberBean oldmb = memberService.findByAccountReturnBean(accountnumber);//找舊的資料
				MemberBean mb = new MemberBean(accountnumber, oldmb.getMemberpassword(), memberName, phonenumber, email, memberaddress, platenumber, birthDate, idnumber,cardnumber);
				MemberBean mBean = memberService.updateByAccountnumber(mb);
				//mBean.setFile(null);//json格式中有BLOB會錯誤
				list.add(mBean);
				
			} catch (SQLException | ParseException e) {
				e.printStackTrace();
			}
			return list;
		}
		
		@PostMapping("/userupdateimg.controller")
		@ResponseBody
		public void processUpdateAction(@RequestParam("accountnumber") String accountnumber,@RequestParam("file") MultipartFile mf,Model model) {
			try {
				byte[] bytes = mf.getBytes();

				if(bytes.length==0) {
					
				}else {
					Blob blob = new SerialBlob(bytes);
				
					memberService.updateImgByAccount(accountnumber, blob);
					
					MemberBean mBean = memberService.findByAccountReturnBean(accountnumber);
					model.addAttribute("LoginOK",mBean);
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		@PostMapping("/showdate.controller")
		@ResponseBody
		public String processActionLoginDate(@RequestParam("logindate") String loginString) {
			try {
				String loginString2 = loginString.substring(0,10);
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				long logintime = sdf.parse(loginString2).getTime();
				
				Date date = new Date();
				long now = date.getTime();
				
				int loginDays = (int) ((now -logintime) /(24 * 60 * 60 * 1000));
				String Days = Integer.toString(loginDays+1);
				return Days;
			} catch (ParseException e) {
				e.printStackTrace();
			}
	        return "xx";
		}
		
		@PostMapping("/usersetsession.controller")
		@ResponseBody
		public String processActionSession(@RequestParam("accountnumber") String accountnumber,Model model) {
			try {
				 MemberBean mBean = memberService.findByAccountReturnBean(accountnumber);
				 model.addAttribute("LoginOK", mBean);
				return "OK";
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return "XX";
		}
}
