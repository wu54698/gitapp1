package iSpan_Car.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iSpan_Car.dao.CarDealerDao;

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
			
			RequestDispatcher rd = request.getRequestDispatcher("/iSpan_Car/CarDealerSuccess.jsp");
			rd.forward(request, response);
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
