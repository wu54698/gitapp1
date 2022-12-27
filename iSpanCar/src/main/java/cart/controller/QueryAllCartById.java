package cart.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.model.CartBean;
import cart.service.CartService;
@MultipartConfig()
@WebServlet("/QueryAllCartById.do")
public class QueryAllCartById  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryAllCartById() {
		super();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CartService service = new CartService();
			String memberId = request.getParameter("memberId");

	     	Collection<CartBean>  coll = service.findAllById(memberId) ;
			
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
