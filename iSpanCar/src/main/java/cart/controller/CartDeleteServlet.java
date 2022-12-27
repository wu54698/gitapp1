package cart.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.service.CartService;

@MultipartConfig()
@WebServlet("/CartDeleteServlet.do")
public class CartDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CartDeleteServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
			String cartId = request.getParameter("cartId");
			System.out.println("錯誤"+cartId);
			CartService service = new  CartService();
			service.deletecartById(cartId);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/QueryAllCart.do");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
