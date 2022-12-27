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

@WebServlet("/checkAccountPasswordServlet.do")
public class checkAccountPasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			System.out.println("------checkAccountPasswordServlet---------");
			
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");
			String accountnumber = request.getParameter("accountnumber");
			String memberpassword = request.getParameter("memberpassword");
			MemberService mService = new MemberService();
		
			String checkString =  mService.checkaccountnumberpassword(accountnumber, memberpassword);
//			String checkString = (check?"T":"F");
			
			response.getWriter().write(checkString);
			response.getWriter().flush();
			response.getWriter().close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
