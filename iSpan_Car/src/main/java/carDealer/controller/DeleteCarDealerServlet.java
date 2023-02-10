package carDealer.controller;

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

import carDealer.dao.CarDealerDao;
import carDealer.model.CarDealerBean;

@MultipartConfig()
@WebServlet("/DeleteCarDealerServlet.do")
public class DeleteCarDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			CarDealerDao cDao = new CarDealerDao();
			String carDealName = request.getParameter("carDealName");

			cDao.deleteCarDealer(carDealName);
			List<CarDealerBean> list = cDao.findAllDealer();
			request.setAttribute("SelectAllDealer", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/SelectAllDealer_frame.jsp");
			rd.forward(request, response);
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
