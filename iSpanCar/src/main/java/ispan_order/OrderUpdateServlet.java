package ispan_order;

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

import ispan_cart.CartDao;

@MultipartConfig()
@WebServlet("/OrderUpdateServlet.do")
public class OrderUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {
			request.setCharacterEncoding("UTF-8");
			String orderStatus = request.getParameter("orderStatus");
			String orderId = request.getParameter("orderId");
			OrderDao odao = new OrderDao();
			odao.updateOrderSatusByOrderId(orderStatus, orderId);
			String contextPath = request.getContextPath();
			response.sendRedirect("QueryAllOrder.do");
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