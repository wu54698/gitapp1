package login;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.dao.MemberDao;
import member.model.MemberBean;

@WebServlet("/loginServlet.do")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
		request.setCharacterEncoding("UTF-8");
		String accountnumber = request.getParameter("accountnumber");
		String memberpassword = request.getParameter("memberpassword");
		HttpSession session = request.getSession();
		String requestURI = (String) session.getAttribute("requestURI");
		MemberDao mDao = new MemberDao();
		String check = mDao.checkaccountnumberpassword(accountnumber, memberpassword);
		List<MemberBean> list =	mDao.findbyaccountnumber(accountnumber);
		if(list.size()>0) {
			for(MemberBean mb :list) {
				if(check.equals("資料正確")) {
					session.setAttribute("LoginOK", mb);
					
						requestURI = (requestURI.length() == 0 ? request.getContextPath() : requestURI);
						
					
					response.sendRedirect(response.encodeRedirectURL(requestURI));
				}else {
					RequestDispatcher rd = request.getRequestDispatcher("/login/login2.jsp");
					rd.forward(request, response);
				}
				
			}
		}else {
			RequestDispatcher rd = request.getRequestDispatcher("/login/login2.jsp");
			rd.forward(request, response);
		}
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
