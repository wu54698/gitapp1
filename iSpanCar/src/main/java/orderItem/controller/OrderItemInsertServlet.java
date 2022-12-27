package orderItem.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cart.service.CartService;
import orderItem.model.OrderItemBean;
import orderItem.service.OrderItemService;

@MultipartConfig()
@WebServlet("/OrderItemInsertServlet.do")
public class OrderItemInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public OrderItemInsertServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  ServletException, IOException  {
		try {
		String memberId  = request.getParameter("memberId");
		String cartId  = request.getParameter("cartId");
		String [] productNumber  = (String [])request.getParameterValues("productNumber[]");
		String [] productName  = (String [])request.getParameterValues("productName[]");
		String  []quantity  = (String [])request.getParameterValues("quantity[]");
		String [] productPrice  = (String [])request.getParameterValues("productPrice[]");
		String orderId= memberId+cartId;
		System.out.println("錯誤"+memberId);
		OrderItemService oiservice = new  OrderItemService();
		for (int i =0 ; i <   productNumber.length; i++) {
			String productNumbe = productNumber[i];
			String  productNam =productName[i];
			String  quantit=quantity[i] ;
			String productPric =productPrice[i];
			OrderItemBean oibean = new OrderItemBean(orderId, productNumbe,productNam,quantit,productPric);
			
		
				oiservice.insertOrderItemBean(oibean);
			} 
		CartService cservice = new  CartService();
		cservice.deleteCartByMemberId(memberId);
		
		
		}catch (SQLException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/QueryAllOrderServlet.do");
//				response.sendRedirect("/QueryAllOrderServlet.do");
			}
		}
	}


