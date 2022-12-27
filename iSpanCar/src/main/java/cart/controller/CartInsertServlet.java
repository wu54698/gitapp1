package cart.controller;

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

import cart.model.CartBean;
import cart.service.CartService;

@MultipartConfig()
@WebServlet("/CartInsertServlet")
public class CartInsertServlet   extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public CartInsertServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
		try {	
			request.setCharacterEncoding("UTF-8");
			String memberId = request.getParameter("memberId");
			String productNumber = request.getParameter("productNumber");
			String productName = request.getParameter("productName");
			String productPrice = request.getParameter("productPrice");
			String quantity = request.getParameter("quantity");
			CartService service = new  CartService();
		
			CartBean bean = new CartBean(memberId, productNumber,productName,productPrice,quantity);
			
			service.insertCartBean(bean);
				
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath +"/Shop_CartServlet.do");

			
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}  
		}


}
