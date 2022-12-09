

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class threads
 */
@WebServlet("/categories")
public class categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryHelper query ;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public categories() {
        super();
        query = new QueryHelper();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(query.getCategories());
	}

}
