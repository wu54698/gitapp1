package carInfo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carInfo.model.CarInfoBean;
import tw.hibernatedemo.service.ISpanCarService;


@WebServlet("/SelectIdToUpdate.do")
public class SelectIdToUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doPost(request, response);
//	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		try {
			request.setCharacterEncoding("UTF-8");
			String carNo = request.getParameter("carNo");
			int carNumber = Integer.parseInt(carNo);
			
			ISpanCarService iService = new ISpanCarService();
			List<CarInfoBean> list = iService.findByCarNoLike(carNumber);
			request.setAttribute("toUpdate", list);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Infomation/JumpToUpdateCarInfoSheet_frame.jsp");
			rd.forward(request, response);
			return;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
