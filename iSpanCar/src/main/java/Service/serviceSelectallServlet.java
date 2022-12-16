package Service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/serviceSelectallServlet.do")
public class serviceSelectallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			ServiceDao sDao = new ServiceDao();
			List<ServiceBean> list = sDao.findallservice();
			
			for(ServiceBean sBean :list) {
				sBean.toString();
			}
			request.setAttribute("serviceSelectall", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Service/SelectallService.jsp");
			rd.forward(request, response);
			return ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}