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


@WebServlet("/serviceDeleteServlet.do")
public class serviceDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			iSpanCarService iSpanService = new iSpanCarService();
			String servicename = request.getParameter("Service_name");
			System.out.println(servicename);
			iSpanService.deleteCarDealer(servicename);
			
//			List<ServiceBean> serviceBean = iSpanService.findAllService();
			
			
			
			request.setAttribute("setService_name", servicename);
			
			RequestDispatcher rd = request.getRequestDispatcher("/Service/DeleteService4.jsp");
			rd.forward(request, response);
			return;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
