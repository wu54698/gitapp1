package iSpancar.login;

import java.net.http.HttpRequest;
import java.security.Principal;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties.Registration;
import org.springframework.security.config.web.servlet.oauth2.resourceserver.OAuth2ResourceServerSecurityMarker;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.endpoint.OAuth2AccessTokenResponse;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginOauth2Google {

	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;
	
	@Autowired
	private OAuth2AuthorizedClientService authorizedClientService;

	@Autowired
	private OAuth2ClientProperties oAuth2ClientProperties;
	
	@GetMapping("/login/oauth2/code/google") 
	@ResponseBody
	public void processAction(OAuth2AuthenticationToken authentication) {
		ClientRegistration googleRegistration = this.clientRegistrationRepository.findByRegistrationId("google");
		String s = googleRegistration.getProviderDetails().getAuthorizationUri();
		
		OAuth2AuthorizedClient client = authorizedClientService
			      .loadAuthorizedClient(
			    	        authentication.getAuthorizedClientRegistrationId(), 
			    	          authentication.getName());
//		 OAuth2AuthorizedClient authorizedClient = 
//			        this.authorizedClientService.loadAuthorizedClient(
//			            authentication.getAuthorizedClientRegistrationId(), 
//			            authentication.getName());
//		
	}
	
}
