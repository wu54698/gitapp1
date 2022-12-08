package iSpanCar;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.x.protobuf.MysqlxConnection.Close;

@WebServlet("/serviceSelectServlet.do")
public class serviceSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		
		ServiceDao sdao = new ServiceDao();
		String Service_name =request.getParameter("Service_name");	
		ServiceBean sBean = sdao.findById(Service_name);
		
		request.setAttribute("Service", sBean);
		
		RequestDispatcher rd = request.getRequestDispatcher("/Service/SelectService4.jsp");
		rd.forward(request, response);
		return;
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}


