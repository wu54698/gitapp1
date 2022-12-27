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

import order.service.OrderService;

@MultipartConfig()
@WebServlet("/OrderUpdateServlet.do")
public class OrderUpdateServlet  extends HttpServlet{
	private static final long serialVersionUID = 1L;

	public OrderUpdateServlet() {
		super();
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
				java.sql.Timestamp orderDate = stringToSqlDate();
				String orderStatus = request.getParameter("orderStatus");
				String orderId = request.getParameter("orderId");
				OrderService service = new  OrderService();
				service.updateOrderSatusByOrderId(orderStatus,orderDate,orderId);
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


