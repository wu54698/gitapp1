package iSpancar.config;

import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.OAuth2ClientProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;

import iSpancar.login.OAuthHandler;
import iSpancar.member.service.AuthMemberDetailService;
//import iSpancar.member.service.CustomOAuth2UserService;
import iSpancar.member.service.CustomOAuth2UserService;

@EnableWebSecurity //@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
//開啟@Secured角色註解//要加ROLE_ //@PreAuthorize在方法之前驗證
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthMemberDetailService authService;
	
//	@Autowired
//    private DatabaseAuthenticationProvider databaseAuthenticationProvider;

//    @Autowired
//    private OAuth2AuthenticationProvider oauth2AuthenticationProvider;
	
//	@Autowired
//	private OAuth2ClientProperties oAuth2ClientProperties;

//	@Autowired
//	private OAuth2AuthorizedClientService authorizedClientService;
//	
//	@Autowired
//	private ClientRegistrationRepository clientRegistrationRepository;
	
	@Autowired
	private OAuthHandler successHandler;
	
	@Override//驗證相關
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(authService)
			.passwordEncoder(new BCryptPasswordEncoder());//用甚麼加密
//		auth.authenticationProvider(databaseAuthenticationProvider);
//		auth.authenticationProvider(oauth2AuthenticationProvider);
			
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.exceptionHandling().accessDeniedPage("/unauth");//403錯誤頁面
		
		http
			.authorizeRequests()//定義那些需要認證才能進 
			.antMatchers("/backstage/**").hasAnyAuthority("manager,employee")//需管理的路徑
			//.antMatchers("/memberselectall.controller").hasAuthority("admins")
			//只有具admins權限才可訪問此路徑，只能寫單一角色
			//.antMatchers("/memberselectall.controller").hasAnyAuthority("admins,manager").hasAnyAuthority("manager")
			//有admin或manager都可允許進入
			//.antMatchers("/memberselectall.controller").hasRole("admins,manager")	
			//使用hasRole前面要加"ROLE_"+角色名
			.antMatchers(HttpMethod.GET).permitAll()//沒在上面設定的不用驗證
			//.antMatchers(HttpMethod.POST,"/backstage/**").authenticated()
			.antMatchers("/backstage/**").hasAnyAuthority("manager,employee")
			.antMatchers("/cartInsert.controller").hasAnyAuthority("user,manager,employee")
			.antMatchers("/cartdeletecart.controller").hasAnyAuthority("user,manager,employee")
			.antMatchers("/cartInsert").hasAnyAuthority("user,manager,employee")
			.antMatchers("/cart").hasAnyAuthority("user,manager,employee")
			.antMatchers("/checkout").hasAnyAuthority("user,manager,employee")
			.antMatchers("/CartfinalCheckout").hasAnyAuthority("user,manager,employee")
			.antMatchers("/CartCheckout").hasAnyAuthority("user,manager,employee")
			.antMatchers(HttpMethod.POST).permitAll()
			.anyRequest().authenticated()
			.and()
			.rememberMe().tokenValiditySeconds(86400).key("rememberMe-key")
			.and()
			.csrf().disable()//關閉csrf 
			.formLogin().loginPage("/login")//登入頁面
//			.loginProcessingUrl("")//登錄送出的Controller
			.defaultSuccessUrl("/index")//成功頁面
			.and()
			 .oauth2Login(o -> o
                     .loginPage("/login")
                     .authorizationEndpoint(auth -> auth.baseUri("/login/oauth2/authorization"))
                     .successHandler(successHandler)
                     )
//			.oauth2Login()//.loginPage("/login")
//			.successHandler(oAuthHandler)
			//.defaultSuccessUrl("/index")
//			.loginPage("/login").defaultSuccessUrl("/index")
//			.userInfoEndpoint()
//	        .userService(customOAuth2UserService())
//			.and()
			.logout()
			.clearAuthentication(true)
			.deleteCookies("JSESSIONID")
            .logoutUrl("/logout.controller")
            .logoutSuccessUrl("/index");
			
			
	}
	
//	@Bean
//	public CustomOAuth2UserService customOAuth2UserService() {
//	    return new CustomOAuth2UserService();
//	}
	

	
	
	
}
