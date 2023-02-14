package iSpancar.member.service;
import java.util.HashSet;
//
//import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AccessToken;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2UserAuthority;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User>{

	@Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
				 OAuth2UserService delegate = new DefaultOAuth2UserService();
			      OAuth2User oAuth2User = delegate.loadUser(userRequest);
		        // 獲取OAuth2UserRequest中的ClientRegistration實例
		        ClientRegistration clientRegistration = userRequest.getClientRegistration();
		        
		        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
		        // 獲取令牌
		        OAuth2AccessToken accessToken = userRequest.getAccessToken();
		        
		        // 通過令牌獲取用戶資訊
		        Map<String, Object> attributes = oAuth2User.getAttributes();
		        String userName = (String) attributes.get(userNameAttributeName);
//		        		getUserAttributes(accessToken, clientRegistration);
		       
		        // 將用戶資訊映射到OAuth2User的實例中
		        return oAuth2User;
		    }
		    
//	private Map<String, Object> getUserAttributes(OAuth2AccessToken accessToken, ClientRegistration clientRegistration) {
//	    // 通過OAuth2AccessToken獲取用戶資訊
//	    OAuth2AuthorizedClient authorizedClient = new OAuth2AuthorizedClient(clientRegistration,"principalName",accessToken);
//	    OAuth2AuthorizedClientService clientService = new OAuth2AuthorizedClientService(clientRegistration.getClientId(), "principalName");
//	    String userInfoEndpointUri = clientService.;
//	    // 建立一個RestTemplate對象來獲取用戶資訊
//	    RestTemplate restTemplate = new RestTemplate();
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.add(HttpHeaders.AUTHORIZATION, "Bearer " + accessToken.getTokenValue());
//	    HttpEntity entity = new HttpEntity<>(headers);
//	    // 發送一個GET請求到userInfoEndpointUri，獲取用戶資訊
//	    ResponseEntity<Map<String, Object>> response = restTemplate.exchange(userInfoEndpointUri, HttpMethod.GET, entity, new ParameterizedTypeReference<Map<String, Object>>() {});
//	    return response.getBody();
//	}

	private OAuth2User mapToOAuth2User(Map<String, Object> attributes, ClientRegistration clientRegistration) {
	    // 將用戶資訊映射到OAuth2User的實例中
	    Set<GrantedAuthority> authorities = new HashSet<>();
	    authorities.add(new OAuth2UserAuthority(attributes));
	    return new DefaultOAuth2User(authorities, attributes, clientRegistration.getClientName());
	}
//
//		
//
//    
}
