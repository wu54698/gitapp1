package iSpancar.dforum.service;

import iSpancar.member.model.MemberBean;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Service
public class WebContextService {

	public MemberBean getCurrUser() {
		RequestAttributes attributes = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) attributes;
		HttpServletRequest request = servletRequestAttributes.getRequest();
		MemberBean loginUser = (MemberBean) request.getSession().getAttribute("loginUser");
		return loginUser;
	}

}
