package tw.hibernatedemo.util;

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

//註冊filter
//@WebFilter(urlPatterns = {"/CarDealerServlet.do", "/DeleteCarDealerServlet.do", "/ShowAllDealerServlet.do", "/ShowDealerServlet.do", "/UpdateCarDealerServlet.do"
//		, "/AllImageServlet.do", "/CarInfoServlet.do", "/DeleteCarInfoServlet.do", "/FindCarBrandServlet.do", "/ShowAllCarInfoServlet.do", "/ShowCarInfoServlet.do", "/UpdateCarInfoServlet.do"})
public class OpenSessionInViewFilter extends HttpFilter implements Filter {

	private Session session;

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// 拿到現有的連線
		try {
			SessionFactory factory = HibernateUtil.getSessionFactory();
			this.session = factory.getCurrentSession();

			session.beginTransaction();
			System.out.println("Begin Transaction...");

			// pass the request along the filter chain
			chain.doFilter(request, response);

			session.getTransaction().commit();
			System.out.println("Commit!!!");
		} catch (Exception e) {
			// TODO: handle exception
			session.getTransaction().rollback();
			System.out.println("ROLLBACK!!!");
			e.printStackTrace();
		}finally {
			System.out.println("Session Closed");
		}

	}

}
