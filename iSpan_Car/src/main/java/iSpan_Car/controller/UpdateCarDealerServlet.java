package iSpan_Car.controller;

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

import iSpan_Car.dao.CarDealerDao;
import iSpan_Car.model.CarDealerBean;


@WebServlet("/UpdateCarDealerServlet.do")
public class UpdateCarDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
		request.setCharacterEncoding("UTF-8");
		CarDealerDao cDao = new CarDealerDao();
		
		String carDealName = request.getParameter("carDealName");
		String carDealPhone = request.getParameter("carDealPhone");
		int Phone = Integer.parseInt(carDealPhone);
		String carDealAddress = request.getParameter("carDealAddress");
		String openTime = request.getParameter("openTime");
		String contactPerson = request.getParameter("contactPerson");
		String carDealVATNumber = request.getParameter("carDealVATNumber");
		int VATNumber = Integer.parseInt(carDealVATNumber);
		List<CarDealerBean> list = cDao.findByCarDealerName(carDealName);
		CarDealerBean originBean = new CarDealerBean();
		for(CarDealerBean cdb :list) {
			originBean.setCarDealName(cdb.getCarDealName());
			originBean.setCarDealPhone(cdb.getCarDealPhone());
			
		}
		String name = (carDealName != "")?carDealName : originBean.getCarDealName();
		
		
		CarDealerBean dealerBean = new CarDealerBean(carDealName, Phone, 
				carDealAddress, openTime,contactPerson, VATNumber);
		
			cDao.updateByCarDealName(dealerBean);
		RequestDispatcher rd = request.getRequestDispatcher("/iSpan_Car/CarDealerSuccess.jsp");
		rd.forward(request, response);
		return;
		} catch (SQLException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
