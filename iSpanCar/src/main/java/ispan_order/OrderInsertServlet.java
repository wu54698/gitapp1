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
	@WebServlet("/OrderInsertServlet.do")
	public class OrderInsertServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
		protected void doGeet(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
			doPost(request, response);
		}
	       
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
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
			String memberId  = request.getParameter("memberId");
			String cartId  = request.getParameter("cartId");
			String forcount  = request.getParameter("forcount");
			String [] productNumber  = (String [])request.getParameterValues("productNumber[]");
			String [] productName  = (String [])request.getParameterValues("productName[]");
			String  []quantity  = (String [])request.getParameterValues("quantity[]");
			String [] productPrice  = (String [])request.getParameterValues("productPrice[]");

			
	
			String orderId= memberId+cartId;
			OrderDao odao = new OrderDao();
			OrderBean bean = new OrderBean( orderId,orderStatus,paidSate,paidMethod,deliveryAddress,orderName,orderPhone,totalPrice,memberId);
				odao.insertOrderBean(bean);
		
//				Integer.valueOf(forcount)
				OrderItemDao oidao = new OrderItemDao();
				for (int i =0 ; i <   productNumber.length; i++) {
					String productNumbe = productNumber[i];
					String  productNam =productName[i];
					String  quantit=quantity[i] ;
					String productPric =productPrice[i];
					OrderItemBean oibean = new OrderItemBean(orderId, productNumbe,productNam,quantit,productPric);
					
					oidao.insertOrderItemBean(oibean);
				
				}
				
			String contextPath = request.getContextPath();
//			response.sendRedirect(contextPath +"/order/order.jsp");
//			request.getRequestDispatcher("/QueryAllOrder.do");
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
