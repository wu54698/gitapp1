package carDealer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carDealer.dao.CarDealerDao;
import carDealer.model.CarDealerBean;


//新增車商資訊
@WebServlet("/CarDealerServlet.do")
public class CarDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			CarDealerDao cDao = new CarDealerDao();

			// 讀取瀏覽器送入的欄位內的資料
			String carDealName = request.getParameter("carDealName");
			String carDealPhone = request.getParameter("carDealPhone");
			String carDealAddress = request.getParameter("carDealAddress");
			String openTime = request.getParameter("openTime");
			String contactPerson = request.getParameter("contactPerson");
			String carDealVATNumber = request.getParameter("carDealVATNumber");
			int VATNumber = Integer.parseInt(carDealVATNumber);

//			java.sql.Time time = cDao.StringToTime(openTime);

			
			CarDealerBean dealerBean = new CarDealerBean(carDealName, carDealPhone, 
					carDealAddress, openTime, contactPerson, VATNumber);
			cDao.addCarDealer(dealerBean);
			List<CarDealerBean> list = cDao.findAllDealer();
			request.setAttribute("SelectAllDealer", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/SelectAllDealer.jsp");
			rd.forward(request, response);
			return;
		} catch (ParseException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}