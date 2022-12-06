package carInfo.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carInfo.dao.CarInfoDao;
import carInfo.model.CarInfoBean;

@WebServlet("/UpdateCarInfoServlet.do")
public class UpdateCarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			CarInfoDao infoDao = new CarInfoDao();

			String carNo = request.getParameter("carNo");
			String carDealName = request.getParameter("carDealName");
			String accountNumber = request.getParameter("accountNumber");
			String carBrand = request.getParameter("carBrand");
			String carName = request.getParameter("carName");
			String stock = request.getParameter("stock");
			String carImage = request.getParameter("carImage");
			String carDescription = request.getParameter("carDescription");
			String announceDate = request.getParameter("announceDate");

			List<CarInfoBean> list = infoDao.findByCarBrandLike(carBrand);
			CarInfoBean originInfoBean = new CarInfoBean();
			for() {
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
