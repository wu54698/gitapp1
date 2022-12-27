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

@WebServlet("/ShowAllDealerServlet.do")
public class ShowAllDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
//			CarDealerDao cDao = new CarDealerDao();
			
			ISpanCarService iSpanService = new ISpanCarService();
			List<CarDealerBean> list = iSpanService.findAllDealer();
			request.setAttribute("SelectAllDealer", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/SelectAllDealer_frame.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
