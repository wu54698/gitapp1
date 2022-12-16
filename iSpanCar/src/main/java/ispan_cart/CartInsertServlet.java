package ispan_cart;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



	@MultipartConfig()
	@WebServlet("/CartInsertServlet.do")
	public class CartInsertServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
		try {	
			request.setCharacterEncoding("UTF-8");
//			String shoppingCartId = request.getParameter("shoppingCartId");
			String memberId = request.getParameter("memberId");
			String productNumber = request.getParameter("productNumber");
			String productName = request.getParameter("productName");
			String productPrice = request.getParameter("productPrice");
			String quantity = request.getParameter("quantity");
		
			CartDao cdao = new CartDao();
			CartBean bean = new CartBean(memberId, productNumber,productName,productPrice,quantity);
			
				cdao.insertCartBean(bean);
			
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath +"/Shop_CartServlet.do");
//			response.sendRedirect(contextPath +"/Cart/CartOk.jsp");
//			RequestDispatcher rd = 
//	     			request.getRequestDispatcher("/Cart/NewFile.jsp");
//			
//			rd.forward(request, response);
			
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ParseException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}

	}
