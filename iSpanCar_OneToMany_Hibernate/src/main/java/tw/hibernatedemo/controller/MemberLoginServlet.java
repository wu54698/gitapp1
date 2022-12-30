package tw.hibernatedemo.controller;

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

import tw.hibernatedemo.model.Member;
import tw.hibernatedemo.service.MemberLoginService;

@WebServlet("/MemberLoginServlet")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public MemberLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		
		Map<String, String> errorMsgMap = new HashMap<String, String>();
		
		request.setAttribute("errorMsgMap", errorMsgMap);
		//連線狀態，與client端的連線
		HttpSession httpSession = request.getSession();
		
		//uname, pwd
		String username = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		//做service驗證
		MemberLoginService service = new MemberLoginService();
		
		Member tempMember = service.checkLogin(username, pwd);
		
		if(tempMember != null) {
			httpSession.setAttribute("loginMember", tempMember);
		}else {
			errorMsgMap.put("LoginError", "帳密錯誤，請重新輸入");
		}
		
		if(errorMsgMap.isEmpty()) {
			//轉到成功頁面
			RequestDispatcher rd = request.getRequestDispatcher("LoginOK.jsp");
			rd.forward(request, response);
		}else {
			//回到login頁面
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

}
