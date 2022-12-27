package order.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.service.CartService;
import order.model.OrderBean;
import order.service.OrderService;
import orderItem.model.OrderItemBean;
import orderItem.service.OrderItemService;


@MultipartConfig()
@WebServlet("/OrderInsertServlet.do")
public class OrderInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderInsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		doPost(request, response);
	}

	public java.sql.Timestamp stringToSqlDate() throws ParseException {

		SimpleDateFormat sdFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		java.sql.Timestamp sdate = new java.sql.Timestamp(date.getTime());
		return sdate;
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		try {

			request.setCharacterEncoding("UTF-8");
//			String orderDate = request.getParameter("orderDate");
			String orderStatus = request.getParameter("orderStatus");
			String paidSate = request.getParameter("paidSate");
			String paidMethod = request.getParameter("paidMethod");
			String deliveryAddress = request.getParameter("deliveryAddress");
			String orderName = request.getParameter("orderName");
			String orderPhone = request.getParameter("orderPhone");
			String totalPrice = request.getParameter("totalPrice");
			String memberId = request.getParameter("memberId");
			String cartId = request.getParameter("cartId");
			String forcount = request.getParameter("forcount");
			String[] productNumber = (String[]) request.getParameterValues("productNumber[]");
			String[] productName = (String[]) request.getParameterValues("productName[]");
			String[] quantity = (String[]) request.getParameterValues("quantity[]");
			String[] productPrice = (String[]) request.getParameterValues("productPrice[]");

			java.sql.Timestamp orderDate = stringToSqlDate();

			String orderId = memberId + cartId;
			OrderService oservice = new OrderService();
			OrderBean bean = new OrderBean(orderId, orderDate, orderStatus, paidSate, paidMethod, deliveryAddress,
					orderName, orderPhone, totalPrice);
			oservice.insertOrderBean(bean);

			OrderItemService oiservice = new OrderItemService();
			for (int i = 0; i < productNumber.length; i++) {
				String productNumbe = productNumber[i];
				String productNam = productName[i];
				String quantit = quantity[i];
				String productPric = productPrice[i];

				OrderItemBean oibean = new OrderItemBean(orderId, productNumbe, productNam, quantit, productPric);

				oiservice.insertOrderItemBean(oibean);
			}
			CartService cservice = new CartService();
			cservice.deleteCartByMemberId(memberId);

//			response.sendRedirect("/QueryAllOrderServlet.do");

			 String contextPath = request.getContextPath();
			   response.sendRedirect(contextPath + "/QueryAllOrderServlet.do");
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
