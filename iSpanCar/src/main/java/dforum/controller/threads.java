package dforum.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dforum.service.QueryHelper;

@WebServlet("/threads.do")
public class threads extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryHelper query ;
       
    public threads() {
        super();
        query = new QueryHelper();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(query.getThreads());
	}

}
