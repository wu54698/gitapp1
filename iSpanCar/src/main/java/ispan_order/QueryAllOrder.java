package ispan_order;



	import java.io.IOException;
	import java.util.Collection;

	import javax.servlet.RequestDispatcher;
	import javax.servlet.ServletException;
//import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

//	@MultipartConfig()
	@WebServlet("/QueryAllOrder.do")
		public class QueryAllOrder extends HttpServlet {
			private static final long serialVersionUID = 1L;
			protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request, response);
			}

			protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				try {
					OrderDao odao = new OrderDao();
					
			     	Collection<OrderBean>  coll = odao.findAllOrder() ;
			     	
			     	OrderItemDao oidao = new OrderItemDao();
			     	Collection<OrderItemBean>  collItem = oidao.findAllOrderItem() ;
			     	
			     	request.setAttribute("AllOrder", coll);
			     	request.setAttribute("AllOrderItme", collItem);

				} catch(Exception ex) {
					ex.printStackTrace();
				} finally {
					RequestDispatcher rd = 
			     			request.getRequestDispatcher("/order/order.jsp");						
					rd.forward(request, response);

				}
		     	return ; 
			}
		}


