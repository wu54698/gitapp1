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



	@MultipartConfig()
	@WebServlet("/OderItemInsertServlet.do")
	public class OrderItemInsertServlet extends HttpServlet {
		private static final long serialVersionUID = 1L;
	       
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException  {
		try {	
			request.setCharacterEncoding("UTF-8");
//			String shoppingCartId = request.getParameter("shoppingCartId");
			String orderId = request.getParameter("orderId");
			String productNumber = request.getParameter("productNumber");
			String productName = request.getParameter("productName");
			String quantity = request.getParameter("quantity");
			String productPrice = request.getParameter("productPrice");
		
			OrderItemDao oidao = new OrderItemDao();
			OrderItemBean bean = new OrderItemBean(orderId, productNumber,productName,quantity,productPrice);
			
				oidao.insertOrderItemBean(bean);
			
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath +"/Cart/mall.jsp");
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

