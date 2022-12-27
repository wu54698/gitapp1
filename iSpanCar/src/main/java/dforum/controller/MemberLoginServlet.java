package dforum.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dforum.model.ForumMember;
import dforum.service.MemberLoginService;


@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public MemberLoginServlet() {
        super();
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		request.setAttribute("errorMsgMap", errorMsgMap);
		
		HttpSession httpSession = request.getSession();
		
//		uname , pwd
		
		String username = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		
		MemberLoginService service = new MemberLoginService();
		
		ForumMember tempMember = service.checkLogin(username, pwd);
		
		if(tempMember != null) {
			httpSession.setAttribute("loginMember", tempMember);
		}else {
			errorMsgMap.put("LoginError", "帳密錯誤，請重新輸入");
		}
		
		if(errorMsgMap.isEmpty()) {
			// 轉到 成功頁面
			RequestDispatcher rs = request.getRequestDispatcher("loginOK.jsp");
			rs.forward(request, response);
		}else {
			// 回到 login 頁面
			RequestDispatcher rs = request.getRequestDispatcher("login.jsp");
			rs.forward(request, response);
		}
		
	}

}
