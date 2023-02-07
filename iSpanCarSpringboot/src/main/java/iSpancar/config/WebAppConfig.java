package iSpancar.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//import iSpancar.member.service.CustomOAuth2UserService;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "index");//將controller重新定向
		
		registry.addViewController("/index").setViewName("index");
		
		registry.addViewController("/login").setViewName("login/login");
		registry.addViewController("/unauth").setViewName("login/unauth");
		registry.addViewController("/forgot-password").setViewName("login/forgot-password");
		registry.addViewController("/resetpassword").setViewName("login/resetpassword");
		
		registry.addViewController("/test").setViewName("userpages/test");
		registry.addViewController("/userinfo").setViewName("userpages/userinfo");
		
		registry.addViewController("/memberInsert").setViewName("member/insertMember");
		registry.addViewController("/memberInsertForEmployee").setViewName("member/insertForEmployee");
		registry.addViewController("/backstage/memberchartjs").setViewName("member/memberchartjs");
		//dforum
//		registry.addViewController("/threadsAdd").setViewName("dforum/threadsAdd");
//		registry.addViewController("/threadsEdit").setViewName("dforum/threadsEdit");
//		registry.addViewController("/threadsList").setViewName("dforum/threadsList");
//		registry.addViewController("/threadsView").setViewName("dforum/threadsView");
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("*.js").addResourceLocations("/WEB-INF/js/");
	}
	
//	@Bean
//    public OAuth2UserService<OAuth2UserRequest, OAuth2User> oauth2UserService() {
//        return new CustomOAuth2UserService();
//    }

}
