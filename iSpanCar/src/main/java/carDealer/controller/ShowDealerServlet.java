package carDealer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carDealer.dao.CarDealerDao;
import carDealer.model.CarDealerBean;
import carDealer.model.ISpanCarService;

//import iSpan_Car.dao.CarDealerDao;
//import iSpan_Car.model.CarDealerBean;


@WebServlet("/ShowDealerServlet.do")
public class ShowDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			String carDealName = request.getParameter("carDealName");
			
//			CarDealerDao cDao = new CarDealerDao();
			ISpanCarService iSpanService = new ISpanCarService();
			
			List<CarDealerBean> list = iSpanService.findByCarDealerName(carDealName);
			
			request.setAttribute("selectcarDealName", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/SelectDealer_frame.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}