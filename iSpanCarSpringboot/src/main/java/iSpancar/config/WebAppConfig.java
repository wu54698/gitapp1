package iSpancar.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebAppConfig implements WebMvcConfigurer {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addRedirectViewController("/", "index");//將controller重新定向
		
		registry.addViewController("/index").setViewName("index");
		
		registry.addViewController("/login").setViewName("login/login");
		registry.addViewController("/unauth").setViewName("login/unauth");
		
		registry.addViewController("/test").setViewName("userpages/test");
		
		registry.addViewController("/insertMember").setViewName("member/insertMember");
		registry.addViewController("/memberInsertForEmployee").setViewName("member/insertForEmployee");

	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("*.js").addResourceLocations("/WEB-INF/js/");
	}
	

}
