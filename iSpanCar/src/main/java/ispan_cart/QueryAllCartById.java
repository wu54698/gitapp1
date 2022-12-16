package ispan_cart;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@MultipartConfig()
@WebServlet("/QueryAllCartById.do")
	public class QueryAllCartById extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
				CartDao cdao = new CartDao();
				String memberId = request.getParameter("memberId");

			
		     	Collection<CartBean>  coll = cdao.findAllById(memberId) ;
		     
		     	request.setAttribute("AllCartById", coll);
		     	
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				RequestDispatcher rd = 
		     			request.getRequestDispatcher("/order/orderForm.jsp");
				
				rd.forward(request, response);

			}
	     	return ; 
		}
	}


