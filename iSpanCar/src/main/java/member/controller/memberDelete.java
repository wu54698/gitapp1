package member.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;

@WebServlet("/memberDelete.do")
public class memberDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String accountnumber = request.getParameter("accountnumber");
			MemberDao mDao = new MemberDao();
			
			mDao.deleteByAccountnumber(accountnumber);
			
			
			response.getWriter().write(accountnumber);
			response.getWriter().flush();
			response.getWriter().close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
