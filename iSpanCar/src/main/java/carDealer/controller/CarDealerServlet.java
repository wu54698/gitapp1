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
import javax.servlet.http.HttpSession;

import org.hibernate.Session;

import carDealer.dao.CarDealerDao;
import carDealer.model.CarDealerBean;
import carDealer.model.ISpanCarService;

//新增車商資訊
@WebServlet("/CarDealerServlet.do")
public class CarDealerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 定義存放錯誤訊息的 Collection物件
			Map<String, String> errorMessage = new HashMap<>();
			request.setAttribute("ErrorMsg", errorMessage);

			request.setCharacterEncoding("UTF-8");
//			CarDealerDao cDao = new CarDealerDao();
			ISpanCarService iSpanService = new ISpanCarService();
			List<CarDealerBean> newlist = iSpanService.findAllDealer();
			List<CarDealerBean> list = newlist;
			// 讀取瀏覽器送入的欄位內的資料
			String carDealName = request.getParameter("carDealName");
			
			// 檢查使用者所輸入的資料是否重複
			for (CarDealerBean carDealerBean : list) {
				if (carDealerBean.getCarDealName().equals(carDealName)) {
					errorMessage.put("carDealName", "該車商名稱已登錄");
				}
				
			}

			String carDealPhone = request.getParameter("carDealPhone");
			String carDealAddress = request.getParameter("carDealAddress");
			String openTime = request.getParameter("openTime");
			String contactPerson = request.getParameter("contactPerson");
			String carDealVATNumber = request.getParameter("carDealVATNumber");
			int VATNumber = Integer.parseInt(carDealVATNumber);

//			java.sql.Time time = cDao.StringToTime(openTime);
			
			if (!errorMessage.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/CarDealerForm_frame.jsp");
				rd.forward(request, response);
				return;
			}	
			
			CarDealerBean dealerBean = new CarDealerBean(carDealName, carDealPhone, carDealAddress, openTime,
					contactPerson, VATNumber);
			iSpanService.addDealer(dealerBean);
			List<CarDealerBean> addlist = iSpanService.findAllDealer();
			request.setAttribute("SelectAllDealer", addlist);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/SelectAllDealer_frame.jsp");
			rd.forward(request, response);
			return;

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}