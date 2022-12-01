package iSpanCar;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/serviceSelectServlet.do")
public class serviceSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		
		ServiceDao sdao = new ServiceDao();

		request.getParameter(getServletName());
		ServiceBean sBean = sdao.findById();
		
		request.setAttribute("selectaccountnumber", sBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/member/selectMember.jsp");
		rd.forward(request, response);
		return;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
