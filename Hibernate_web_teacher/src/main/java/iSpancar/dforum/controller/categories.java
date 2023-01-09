package iSpancar.dforum.controller;
/*
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import iSpancar.dforum.model.CategoryDao;
import iSpancar.dforum.service.QueryHelper;

@Controller
public class categories {
	private static final long serialVersionUID = 1L;
	
	@Autowired
	private CategoryDao categoryDao;

	@GetMapping("/categories")
	public void getCategories(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(categoryDao.getCategories());
	}

}
*/

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iSpancar.dforum.service.QueryHelper;


@WebServlet("/categories")
public class categories extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QueryHelper query ;
       
 
    public categories() {
        super();
        query = new QueryHelper();
        
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().append(query.getCategories());
	}

}
