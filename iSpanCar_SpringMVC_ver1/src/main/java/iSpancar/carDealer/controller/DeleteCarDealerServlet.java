package iSpancar.carDealer.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import iSpancar.carDealer.model.CarDealerBean;
import iSpancar.tw.hibernatedemo.service.ISpanCarService;

@MultipartConfig()
//@WebServlet("/DeleteCarDealerServlet.do")
public class DeleteCarDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			
			ISpanCarService iSpanService = new ISpanCarService();
			String carDealName = request.getParameter("carDealName");

			iSpanService.deleteCarDealer(carDealName);
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
