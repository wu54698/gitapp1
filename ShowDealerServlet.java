package iSpan_Car;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ShowDealer.do")
public class ShowDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		CarDealerBean dealerBean = (CarDealerBean)session.getAttribute("LoginOK");
		if(dealerBean == null) {
			String servletPath = request.getServletPath();
			session.setAttribute("target", servletPath);
			response.sendRedirect(
					response.encodeRedirectURL(
							request.getContextPath()));
			return;
		}
		
		
	
	
	}

}
