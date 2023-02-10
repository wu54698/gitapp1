package iSpan_Car;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


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
			int Phone =  Integer.parseInt(carDealPhone);
			String carDealAddress = request.getParameter("carDealAddress");
			String openTime = request.getParameter("openTime");
			String contactPerson = request.getParameter("contactPerson");
			String carDealVATNumber = request.getParameter("carDealVATNumber");
			int VATNumber = Integer.parseInt(carDealVATNumber);

//			java.sql.Time time = cDao.StringToTime(openTime);

			
			CarDealerBean dealerBean = new CarDealerBean(carDealName, Phone, 
					carDealAddress, openTime, contactPerson, VATNumber);
			cDao.addCarDealer(dealerBean);
			
			RequestDispatcher rd = request.getRequestDispatcher("/iSpan_Car/CarDealerSuccess.jsp");
			rd.forward(request, response);
			return;
		} catch (ParseException | SQLException e) {
			e.printStackTrace();
		}
		
	}

}
