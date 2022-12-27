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

@WebServlet("/Shop_CartServlet.do")
public class Shop_CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		ShopDetailDao sDao = new ShopDetailDao();

		List<ShopDetailBean> list = sDao.findAllProduct();

		request.setAttribute("queryallproduct", list);

		RequestDispatcher rd = request.getRequestDispatcher("/SHOP_DETAIL/Shop_Cart.jsp");
		rd.forward(request, response);
		return;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}