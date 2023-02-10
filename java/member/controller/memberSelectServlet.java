package member.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import member.dao.MemberDao;
import member.model.MemberBean;

@WebServlet("/memberSelectServlet.do")
public class memberSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		String accountnumber = request.getParameter("accountnumber");
		MemberDao mDao = new MemberDao();
		
		List<MemberBean> list= mDao.findbyaccountnumber(accountnumber);
		request.setAttribute("selectaccountnumber", list);
		
	
			RequestDispatcher rd = request.getRequestDispatcher("/member/ShowMember.jsp");
			rd.forward(request, response);
			return;
		
		
		
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
