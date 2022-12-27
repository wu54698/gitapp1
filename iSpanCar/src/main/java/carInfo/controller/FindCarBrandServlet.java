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

import carDealer.model.ISpanCarService;
import carInfo.dao.CarInfoDao;
import carInfo.model.CarInfoBean;

@MultipartConfig()
@WebServlet("/FindCarBrandServlet.do")
public class FindCarBrandServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			request.setCharacterEncoding("UTF-8");
			String carBrand = request.getParameter("carBrand");
//			CarInfoDao infoDao = new CarInfoDao();
			ISpanCarService iSpanService = new ISpanCarService();
			
			List<CarInfoBean> list = iSpanService.findByCarBrandLike(carBrand);
			
			request.setAttribute("Brand", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Infomation/SelectCarByBrand_frame.jsp");
			rd.forward(request, response);
			return;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
