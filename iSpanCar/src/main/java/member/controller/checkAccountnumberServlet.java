package member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.service.MemberService;

@WebServlet("/checkAccountnumberServlet.do")
public class checkAccountnumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("---------checkAccountnumberServlet------------");
			
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String accountnumber = request.getParameter("accountnumber");
		MemberService mService = new MemberService();
		
		boolean check =	mService.checkaccountnumber(accountnumber);
		String checkstring = "";
			if(check) {
				checkstring = "帳號已存在";
			}else {
				checkstring = "帳號不存在";
			}
			response.getWriter().write(checkstring);
			response.getWriter().flush();
			response.getWriter().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
