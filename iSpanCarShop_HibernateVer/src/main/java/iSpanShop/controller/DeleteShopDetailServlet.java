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

@WebServlet("/DeleteShopDetailServlet.do")
public class DeleteShopDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String productno = request.getParameter("productno");
//			int productnnoint = Integer.parseInt(productno); 
			ShopDetailDao sDao = new ShopDetailDao();
			System.out.println(productno);
			List<ShopDetailBean> list = sDao.findByProductno(productno);
			for(ShopDetailBean sdb :list) {
				sDao.deleteProduct(sdb);
			}
//			RequestDispatcher rd = request.getRequestDispatcher("/SHOP_DETAIL/DeleteProductSucess.jsp");
//			rd.forward(request, response);
//			return;
		}catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}
}
