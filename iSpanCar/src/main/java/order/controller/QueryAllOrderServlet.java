package order.controller;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import util.HibernateUtil;
import order.model.OrderBean;
import order.service.OrderService;
import orderItem.model.OrderItemBean;
import orderItem.service.OrderItemService;

@WebServlet("/QueryAllOrderServlet.do")
public class QueryAllOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public QueryAllOrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
	doPost(request, response);
}

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("UTF-8");

			try {
				SessionFactory factory = HibernateUtil.getSessionFactory();
				Session session=factory.getCurrentSession();

				session.beginTransaction();
				OrderService oservice = new  OrderService();
				
				
		     	Collection<OrderBean>  coll = oservice.findAllOrder() ;
		     	System.out.println("錯誤"+coll);
		     	OrderItemService oiservice = new  OrderItemService();
		     	Collection<OrderItemBean>  collItem = oiservice.findAllOrderItem() ;
		     	
		     	request.setAttribute("AllOrder", coll);
		     	request.setAttribute("AllOrderItme", collItem);
		    	session.getTransaction().commit();
			} catch(Exception ex) {
				ex.printStackTrace();
			} finally {
				RequestDispatcher rd = 
		     			request.getRequestDispatcher("/order/order.jsp");						
				rd.forward(request, response);

			}
	     	
		}
	}





