package iSpancar.config;

import javax.naming.AuthenticationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.client.authentication.OAuth2LoginAuthenticationToken;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Component;

@Component
public class OAuth2AuthenticationProvider implements AuthenticationProvider {
 
	@Autowired
	private OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService;
	@Autowired
	private ClientRegistrationRepository clientRegistrationRepository;
 
	public OAuth2AuthenticationProvider(OAuth2UserService<OAuth2UserRequest, OAuth2User> oAuth2UserService,
			ClientRegistrationRepository clientRegistrationRepository) {
    this.oAuth2UserService = oAuth2UserService;
    this.clientRegistrationRepository = clientRegistrationRepository;
  }
 
  @Override
  public Authentication authenticate(Authentication authentication) {
    OAuth2LoginAuthenticationToken authenticationToken = (OAuth2LoginAuthenticationToken) authentication;
    String clientRegistrationId = authenticationToken.getClientRegistration().getClientId();
    ClientRegistration clientRegistration = clientRegistrationRepository.findByRegistrationId(clientRegistrationId);
    OAuth2UserRequest oAuth2UserRequest = new OAuth2UserRequest(clientRegistration, authenticationToken.getAccessToken());
    OAuth2User oAuth2User = oAuth2UserService.loadUser(oAuth2UserRequest);
    return new OAuth2LoginAuthenticationToken(clientRegistration,authenticationToken.getAuthorizationExchange(), authenticationToken.getPrincipal(), authentication.getAuthorities(), authenticationToken.getAccessToken());
//    		new OAuth2LoginAuthenticationToken(authenticationToken.getPrincipal(), authenticationToken.getCredentials(),
//        oAuth2User.getAuthorities(), clientRegistrationId, oAuth2User);
  }
 
  @Override
  public boolean supports(Class<?> authentication) {
    return OAuth2LoginAuthenticationToken.class.isAssignableFrom(authentication);
  }
}

