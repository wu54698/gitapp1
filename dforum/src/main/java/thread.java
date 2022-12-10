
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.Date;
import java.sql.Timestamp;
/**
 * Servlet implementation class threads
 */
@WebServlet("/thread")
public class thread extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryHelper query;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public thread() {
		super();
		query = new QueryHelper();

		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String sn = request.getParameter("sn");
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(query.getThread(Integer.parseInt(sn)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
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
		response.setHeader("Location", "threads.jsp");
	}

}
