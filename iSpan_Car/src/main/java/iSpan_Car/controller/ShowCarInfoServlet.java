package iSpan_Car.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iSpan_Car.dao.CarInfoDao;
import iSpan_Car.model.CarInfoBean;

@WebServlet("/ShowCarInfoServlet.do")
public class ShowCarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			request.setCharacterEncoding("UTF-8");
			String carBrand = request.getParameter("carBrand");
			CarInfoDao infoDao = new CarInfoDao();

			List<CarInfoBean> list = infoDao.findByCarBrandLike(carBrand);
			
			request.setAttribute("selectCarBrand", list);
			//連線jsp，輸入至EL屬性物件
			RequestDispatcher rd = request.getRequestDispatcher("/iSpan_Car/SelectInfo.jsp");
			rd.forward(request, response);
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}