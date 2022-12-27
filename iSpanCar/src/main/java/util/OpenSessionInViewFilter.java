package util;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

@WebFilter(filterName = "Transaction",urlPatterns ={"/CartDeleteServlet.do", "/CartInsertServlet","/CartUpdateServlet.do","/QueryAllCart.do","/QueryAllCartById.do"
		,"/OrderInsertServlet.do","/OrderUpdateServlet.do","/QueryAllOrder.do","/OrderItemInsertServlet.do"})
public class OpenSessionInViewFilter extends HttpFilter implements Filter {
       

	private Session session;
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			this.session = factory.getCurrentSession();
			
			System.out.println("Filter 上半部------"+(session.getTransaction().isActive()?"已經開":"開交易"));

			if( !session.getTransaction().isActive()){
				session.beginTransaction();
				System.out.println("Begin Transaction...");
			}
			
			chain.doFilter(request, response);
			
			System.out.println("Filter 下半部------"+(session.getTransaction().isActive()?"關交易":"沒交易"));
			
			if( session.getTransaction().isActive()){
				session.getTransaction().commit();
				System.out.println("Commit!!");
				System.out.println("Session close!!");
			}
			
			
			
		} catch (Exception e) {
			if( session.getTransaction().isActive()){
				session.getTransaction().rollback();
				System.out.println("Rollback!!");
				System.out.println("Session close!!");
			}
			
			e.printStackTrace();
		}finally {
			//System.out.println("Session close!!");
		}
		
		
		
	}

	

}
