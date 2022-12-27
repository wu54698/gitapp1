package dforum.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dforum.model.ForumMember;
import dforum.model.Post;
import dforum.service.QueryHelper;

import java.sql.Date;
import java.sql.Timestamp;
import dforum.model.Thread;

/**
 * Servlet implementation class threads
 */
@WebServlet("/thread.do")
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
		String id = request.getParameter("id");
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(query.getThread(Integer.parseInt(id)));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		String category = request.getParameter("category");
		Thread thread = query.newThread(1);

		Post post = new Post();
		post.setOP(true);
		ForumMember member = new ForumMember();
		member.setId(Integer.parseInt(request.getParameter("memberId")));
		post.setMember(member);
		post.setTime(new Timestamp(Long.parseLong(request.getParameter("time"))));
		post.setBody(request.getParameter("body"));
		post.setTitle(request.getParameter("title")) ;
		post.setThread(thread);
		query.newPost(post);
		
//		response.setContentType("text/html;charset=utf-8");
//		response.setCharacterEncoding("utf-8");
		response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
		String context = request.getContextPath();
		response.sendRedirect(context+"/dforum/threads.jsp");
//		response.setHeader("Location", "dforum/threads.jsp");
		
	}

}
