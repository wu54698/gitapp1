package iSpancar.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.HiddenHttpMethodFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
//相當於web.xml的java程式組態

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override //用來設定相當於beans.config.xml的java程式組態類別
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] {RootAppConfig.class};
//		return null;
	}

	@Override //用來設定相當於mvc-servlet.xml的java程式組態類別
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] {WebAppConfig.class}; 
//		return null;

	}

	@Override  //用來設定url-pattern的路徑
	protected String[] getServletMappings() {
		return new String[] {"/"};
//		return null;

	}

	@Override
	protected Filter[] getServletFilters() {
		CharacterEncodingFilter cef1 = new CharacterEncodingFilter("UTF-8",true);
		HiddenHttpMethodFilter hhmf = new HiddenHttpMethodFilter();
		return new Filter[] {cef1 , hhmf};
	}

}
