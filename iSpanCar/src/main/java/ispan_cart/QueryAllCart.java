package ispan_cart;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/QueryAllCart.do")
	public class QueryAllCart extends HttpServlet {
		private static final long serialVersionUID = 1L;

		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			try {
//		     	RegisterService  rs = new RegisterService();   
				CartDao cdao = new CartDao();

		     	Collection<CartBean>  coll = cdao.findAllCart() ;
		     	request.setAttribute("AllCart", coll);
			} catch(Exception ex) {
//				request.setAttribute("ErrorMessage", ex.getMessage() + "請檢查memberExample表格是否存在");
				ex.printStackTrace();
			} finally {
				RequestDispatcher rd = 
		     			request.getRequestDispatcher("/Cart/cart.jsp");
//				request.getRequestDispatcher("http://localhost:8080/ispan_car/Cart/cart.jsp");
				
				rd.forward(request, response);

			}
	     	return ; 
		}
	}


