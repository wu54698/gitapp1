package model;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductListServlet.do")
public class ProductListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		ShopDetailDao sDao = new ShopDetailDao();
		
		List<ShopDetailBean> list= sDao.findAllProduct();
		
		request.setAttribute("queryallproduct", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/SHOP_DETAIL/ShowProductList.jsp");
		rd.forward(request, response);
		return;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		ShopDetailDao sDao = new ShopDetailDao();
		
		List<ShopDetailBean> list= sDao.findAllProduct();
		
		request.setAttribute("queryallproduct", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/SHOP_DETAIL/ShowProductList.jsp");
		rd.forward(request, response);
		return;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
