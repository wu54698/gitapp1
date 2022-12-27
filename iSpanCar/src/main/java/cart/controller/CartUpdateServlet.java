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
@WebServlet("/CartUpdateServlet.do")
public class CartUpdateServlet  extends HttpServlet{
	private static final long  serialVersionUID = 1L;

	public CartUpdateServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		  try {
		   request.setCharacterEncoding("UTF-8");
		   String quantity = request.getParameter("quantity");	
		   String cartId = request.getParameter("cartId");
			CartService service = new  CartService();
			service.updateQuantityByCartId(quantity,cartId);
		   String contextPath = request.getContextPath();
		   response.sendRedirect(contextPath + "/QueryAllCart.do");
		  } catch (UnsupportedEncodingException e) {
		   e.printStackTrace();
		  } catch (IOException e) {
		   e.printStackTrace();
		  }
		 }
		}
