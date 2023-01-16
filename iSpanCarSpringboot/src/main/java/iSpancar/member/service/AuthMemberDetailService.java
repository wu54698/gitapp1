//package iSpancar.member.service;
//
//import java.sql.SQLException;
//import java.util.Collections;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import iSpancar.member.model.MemberBean;
//
//@Service
//public class AuthMemberDetailService implements UserDetailsService {
//	
//	@Autowired
//	private MemberService mService;
//
//	@Override
//	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//		MemberBean member = null;
//		try {
//			member = mService.findImgbyaccountnumber(username);
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return new User(member.getAccountnumber(),member.getMemberpassword(),Collections.emptyList());
//	}
//
//}
