package iSpancar.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import iSpancar.member.service.AuthMemberDetailService;

@EnableWebSecurity //@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
//開啟@Secured角色註解//要加ROLE_ //@PreAuthorize在方法之前驗證
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private AuthMemberDetailService authService;
	
	@Override//驗證相關
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
		http.exceptionHandling().accessDeniedPage("/unauth");//403錯誤頁面
		
		http
			.authorizeRequests()//定義那些需要認證才能進 
			.antMatchers(HttpMethod.GET,"/memberselectall.controller").hasAnyAuthority("manager,employee")//需管理的路徑
			//.antMatchers("/memberselectall.controller").hasAuthority("admins")
			//只有具admins權限才可訪問此路徑，只能寫單一角色
			//.antMatchers("/memberselectall.controller").hasAnyAuthority("admins,manager").hasAnyAuthority("manager")
			//有admin或manager都可允許進入
			//.antMatchers("/memberselectall.controller").hasRole("admins,manager")	
			//使用hasRole前面要加"ROLE_"+角色名
			.antMatchers(HttpMethod.GET).permitAll()//沒在上面設定的不用驗證
			.antMatchers(HttpMethod.POST,"/users/**").authenticated()
			.antMatchers(HttpMethod.POST).permitAll()
			.anyRequest().authenticated()
			.and()
			.rememberMe().tokenValiditySeconds(86400).key("rememberMe-key")
			.and()
			.csrf().disable()//關閉csrf 
			.formLogin().loginPage("/login")//登入頁面
			//.loginProcessingUrl("")登錄送出的Controller
			.defaultSuccessUrl("/index");//成功頁面
			
			
	}
	
}
