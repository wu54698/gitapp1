package iSpancar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import iSpancar.member.service.AuthMemberDetailService;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthMemberDetailService authService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(authService)
			.passwordEncoder(new BCryptPasswordEncoder());//用甚麼加密
			
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
	
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
			.antMatchers(HttpMethod.GET,"/memberselectall.controller").authenticated()//需管理的路徑
			.antMatchers(HttpMethod.GET).permitAll()//沒在上面設定的不用驗證
			.antMatchers(HttpMethod.POST,"/users/**").authenticated()
			.antMatchers(HttpMethod.POST).permitAll()
			.anyRequest().authenticated()
			.and()
			.rememberMe().tokenValiditySeconds(86400).key("rememberMe-key")
			.and()
			.csrf().disable()
			.formLogin().loginPage("/login")//登入頁面
			.defaultSuccessUrl("/memberselectall.controller");//成功頁面
			
			
	}
	
}
