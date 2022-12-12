package dforum;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
@WebServlet("/thread.do")
public class threadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryHelper query;

	public threadServlet() {
		super();
		query = new QueryHelper();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sn = request.getParameter("sn");
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		System.out.println(sn);
		response.getWriter().append(query.getThread(Integer.parseInt(sn)));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int threadSN = query.newThread(Integer.parseInt(request.getParameter("category")));

		Post post = new Post();
		post.isOP = true ;
		post.memberSN = Integer.parseInt(request.getParameter("memberSN"));
		post.time = new Timestamp(Long.parseLong(request.getParameter("time")));
		post.body = request.getParameter("body");
		post.title = request.getParameter("title");
		post.threadSN = threadSN ;
		query.newPost(post);
//		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
//		response.setHeader("Location", "/dforum/threads.jsp");
		String context = request.getContextPath();
		response.sendRedirect(context+"/dforum/threads.jsp");
	}

}
