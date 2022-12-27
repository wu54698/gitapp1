package cart.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.model.CartBean;
import cart.service.CartService;

@WebServlet("/QueryAllCart.do")
public class QueryAllCart  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public QueryAllCart() {
		super();
	}
		
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	doPost(request, response);
}
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");

			
			
			try {
				CartService service = new CartService();

		     	Collection<CartBean>  coll = service.findAllCart() ;
		     	request.setAttribute("AllCart", coll);
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				RequestDispatcher rd = 
		     			request.getRequestDispatcher("/Cart/cart.jsp");
				
				rd.forward(request, response);

			}
	   
		}

}
