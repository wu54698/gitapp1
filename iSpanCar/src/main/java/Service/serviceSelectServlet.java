package Service;

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


@WebServlet("/serviceSelectServlet.do")
public class serviceSelectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		iSpanCarService iSpanService = new iSpanCarService();
		String Service_name =request.getParameter("Servicename");	
		List<ServiceBean> list = iSpanService.findByService(Service_name);
		for(ServiceBean sb :list) {
			request.setAttribute("Service", sb);
		}
//		for(ServiceBean sb:list) {
//			System.out.println(sb.getService_name());
//			
//		}
		RequestDispatcher rd = request.getRequestDispatcher("/Service/SelectService4.jsp");
		rd.forward(request, response);
		return;
		
	}
}


