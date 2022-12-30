package dforum.controller;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dforum.model.ForumMember;
import dforum.model.Post;
import dforum.model.Thread;
import dforum.service.QueryHelper;

/**
 * Servlet implementation class NewPost
 */
@WebServlet("/newpost.do")
public class NewPost extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryHelper query;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewPost() {
        super();
        query = new QueryHelper();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		Post post = new Post();
		post.setOP(false);
		ForumMember member = new ForumMember();
		member.setId(Integer.parseInt(request.getParameter("memberId")));
		post.setMember(member);
		post.setTime(new Timestamp(Long.parseLong(request.getParameter("time"))));
		post.setBody(request.getParameter("body"));
		post.setTitle(request.getParameter("title")) ;
		Thread thread = new Thread();
		thread.setId(Integer.parseInt(request.getParameter("threadId")));
		post.setThread(thread);
		query.newPost(post);
		response.setStatus(HttpServletResponse.SC_TEMPORARY_REDIRECT);
		String context = request.getContextPath();
		response.sendRedirect(context+"/dforum/thread.jsp?id="+request.getParameter("threadId"));
//		response.setHeader("Location", "thread.jsp?id="+request.getParameter("threadId"));

	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		query.deletePost(Integer.parseInt(request.getParameter("id")));
		//response.getWriter().append("deleted "+updateCount+" data");
	}

}
