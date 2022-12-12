package dforum;

import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newpost")
public class NewPost2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryHelper query;
    public NewPost2() {
        super();
        query = new QueryHelper();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		Post post = new Post();
		post.isOP = false ;
		post.memberSN = Integer.parseInt(request.getParameter("memberSN"));
		post.time = new Timestamp(Long.parseLong(request.getParameter("time")));
		post.body = request.getParameter("body");
		post.title = request.getParameter("title");
		post.threadSN = Integer.parseInt(request.getParameter("threadSN")); ;
		query.newPost(post);

	}

}
