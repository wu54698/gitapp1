package carInfo.controller;

import java.io.IOException;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carInfo.dao.CarInfoDao;
import carInfo.model.CarInfoBean;

@MultipartConfig
@WebServlet("/DeleteCarInfoServlet.do")
public class DeleteCarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			CarInfoDao infoDao = new CarInfoDao();
			String Stock = request.getParameter("stock");
			System.out.println(Stock);
			int amount = Integer.parseInt(Stock);

			infoDao.deleteCarInfo(amount);
			List<CarInfoBean> list = infoDao.findAllCar();
			request.setAttribute("SelectAllCar", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Infomation/SelectAllCar.jsp");
			rd.forward(request, response);
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
