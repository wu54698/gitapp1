package carDealer.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

@WebServlet("/UpdateCarDealerServlet.do")
public class UpdateCarDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		try {
			// 定義存放錯誤訊息的 Collection物件
			Map<String, String> errorMessage = new HashMap<>();
			request.setAttribute("NotFoundMsg", errorMessage);
			
			
			request.setCharacterEncoding("UTF-8");
//			CarDealerDao cDao = new CarDealerDao();
			ISpanCarService iSpanService = new ISpanCarService();
			List<CarDealerBean> verifyList = iSpanService.findAllDealer();
			
			// 讀取瀏覽器送入的欄位內的資料
			String carDealName = request.getParameter("carDealName");
			
			// 檢查使用者所輸入的資料是否錯誤
			boolean duplicateCheck = false;
			for (CarDealerBean cdb : verifyList) {
				if (cdb.getCarDealName().equals(carDealName)) {
					duplicateCheck = true;
				}
			}
			if(!duplicateCheck) {
				errorMessage.put("carDealName", "找無此車商");
			}
			
			String carDealPhone = request.getParameter("carDealPhone");
//		int Phone = Integer.parseInt(carDealPhone);
			String carDealAddress = request.getParameter("carDealAddress");
			String openTime = request.getParameter("openTime");
			String contactPerson = request.getParameter("contactPerson");
			String carDealVATNumber = request.getParameter("carDealVATNumber");
//		int VATNumber = Integer.parseInt(carDealVATNumber);

			List<CarDealerBean> list = iSpanService.findByCarDealerName(carDealName);
			CarDealerBean originBean = new CarDealerBean();
			for (CarDealerBean cdb : list) {
				originBean.setCarDealName(cdb.getCarDealName());
				originBean.setCarDealPhone(cdb.getCarDealPhone());
				originBean.setCarDealAddress(cdb.getCarDealAddress());
				originBean.setOpenTime(cdb.getOpenTime());
				originBean.setContactPerson(cdb.getContactPerson());
				originBean.setCarDealVATNumber(cdb.getCarDealVATNumber());
			}

			String name = (carDealName.equals("")) ? originBean.getCarDealName() : carDealName;
			String mobile = (carDealPhone.equals("")) ? originBean.getCarDealPhone() : carDealPhone;
			String address = (carDealAddress.equals("")) ? originBean.getCarDealAddress() : carDealAddress;
			String time = (openTime.equals("")) ? originBean.getOpenTime() : openTime;
			String person = (contactPerson.equals("")) ? originBean.getContactPerson() : contactPerson;
			int VAT = (carDealVATNumber.equals("")) ? originBean.getCarDealVATNumber()
					: Integer.parseInt(carDealVATNumber);

			if (!errorMessage.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/CarDealerForm_frame.jsp");
				rd.forward(request, response);
				return;
			}
			
//		System.out.println(name+" "+mobile+" "+address+" "+time+" "+person+" "+VAT);
			CarDealerBean dealerBean = new CarDealerBean(name, mobile, address, time, person, VAT);

			iSpanService.updateByCarDealName(dealerBean);
			List<CarDealerBean> newList = iSpanService.findByCarDealerName(carDealName);
			request.setAttribute("UpdateDealer", newList);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/UpdateDealer_frame.jsp");
			rd.forward(request, response);
			return;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
