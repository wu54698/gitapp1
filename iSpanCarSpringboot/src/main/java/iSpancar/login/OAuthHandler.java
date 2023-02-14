package iSpancar.login;

import java.io.IOException;
import java.security.AuthProvider;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import iSpancar.member.model.Oauth2MemberBean;
import iSpancar.member.service.MemberService;

@Component
public class OAuthHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private MemberService mService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
		Authentication authentication) throws IOException, ServletException {
		OAuth2User principal =(OAuth2User) authentication.getPrincipal();
		String email = (String) principal.getAttributes().get("email");
		String name = (String) principal.getAttributes().get("name");
		String picture = (String) principal.getAttributes().get("picture");
		
		Oauth2MemberBean oBean = new Oauth2MemberBean(email,name,picture);
		HttpSession session = request.getSession();
		session.setAttribute("GoogleLogin", oBean);
		if(!mService.checkOAuthMember(oBean)) {
			mService.insertOAuthMember(oBean);
		}
		
		response.sendRedirect("/index");
		
	}
	
}
