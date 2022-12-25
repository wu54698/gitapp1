package iSpanShop.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iSpanShop.model.ShopDetailBean;
import iSpanShop.model.ShopDetailDao;

@WebServlet("/SendIdToUpdate.do")
public class SendIdToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String productno = request.getParameter("productno");
		ShopDetailDao sDao = new ShopDetailDao();
		List<ShopDetailBean> list;
		try {
			list = sDao.findByProductno(productno);
//		
		request.setAttribute("sentno", list);
		
		RequestDispatcher rd = request.getRequestDispatcher("/SHOP_DETAIL/UpdateProduct_form.jsp");
		rd.forward(request, response);
		return;
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
