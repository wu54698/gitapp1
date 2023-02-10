package iSpancar.carDealer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import iSpancar.carDealer.model.CarDealerBean;
import iSpancar.tw.hibernatedemo.service.ISpanCarService;

//新增車商資訊
//@WebServlet("/CarDealerServlet.do")
//@Controller
public class CarDealerServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

//	@Autowired
	private ISpanCarService iSpanCarService;
	
//	@RequestMapping(path = "/cardealermain.controller", method = RequestMethod.GET)
//	public String processMainAction() {
//		return "CarDealerForm_frame";
//	}
	
//	@PostMapping(path = "/cardealermain.controller")
//	public String processAction(@RequestParam("carDealerName") String carDealName, @RequestParam("carDealerPhone") String carDealPhone,
//							@RequestParam("carDealerAddress") String carDealAddress, @RequestParam("openTime") String openTime,
//							@RequestParam("contactPerson") String contactPerson, @RequestParam("carDealerVATNumber") int carDealVATNumber, Model m) {
		// 定義存放錯誤訊息的 Collection物件
//		Map<String, String> errorMessage = new HashMap<>();
//		m.addAttribute("ErrorMsg", errorMessage);
//		
//		List<CarDealerBean> newlist = iSpanCarService.findAllDealer();
//		
//		List<CarDealerBean> list = newlist;
		
		// 讀取瀏覽器送入的欄位內的資料
//		m.addAttribute("carDealName");
		
		// 檢查使用者所輸入的資料是否重複
//		for(CarDealerBean carDealerBean : list) {
//			if (carDealerBean.getCarDealName().equals(carDealName)) {
//				errorMessage.put("carDealName", "該車商名稱已登錄");
//		}
//	}
//		m.addAttribute("carDealerPhone");
//		m.addAttribute("carDealerAddress");
//		m.addAttribute("openTime");
//		m.addAttribute("contactPerson");
//		m.addAttribute("carDealerVATNumber");
		
		//有錯誤則跳回車商主頁
//		if (!errorMessage.isEmpty()) {
//			return "CarDealerForm_frame";
//		}
//		
//		List<CarDealerBean> addlist = iSpanCarService.findAllDealer();
		
		
//		
//		return "SelectAllDealer_frame";
//		
//	}
		

//	private static final long serialVersionUID = 1L;

//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		try {
			// 定義存放錯誤訊息的 Collection物件
//			Map<String, String> errorMessage = new HashMap<>();
//			request.setAttribute("ErrorMsg", errorMessage);
//
//			request.setCharacterEncoding("UTF-8");
//			ISpanCarService iSpanService = new ISpanCarService();
//			List<CarDealerBean> newlist = iSpanService.findAllDealer();
//			List<CarDealerBean> list = newlist;
			// 讀取瀏覽器送入的欄位內的資料
//			String carDealName = request.getParameter("carDealName");
			
			// 檢查使用者所輸入的資料是否重複
//			for (CarDealerBean carDealerBean : list) {
//				if (carDealerBean.getCarDealName().equals(carDealName)) {
//					errorMessage.put("carDealName", "該車商名稱已登錄");
//				}
//				
//			}

//			String carDealPhone = request.getParameter("carDealPhone");
//			String carDealAddress = request.getParameter("carDealAddress");
//			String openTime = request.getParameter("openTime");
//			String contactPerson = request.getParameter("contactPerson");
//			String carDealVATNumber = request.getParameter("carDealVATNumber");
//			int VATNumber = Integer.parseInt(carDealVATNumber);
//
//			if (!errorMessage.isEmpty()) {
//				RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/CarDealerForm_frame.jsp");
//				rd.forward(request, response);
//				return;
//			}	
			
//			CarDealerBean dealerBean = new CarDealerBean(carDealName, carDealPhone, carDealAddress, openTime,
//					contactPerson, VATNumber);
//			iSpanService.addDealer(dealerBean);
//			List<CarDealerBean> addlist = iSpanService.findAllDealer();
//			request.setAttribute("SelectAllDealer", addlist);
//			RequestDispatcher rd = request.getRequestDispatcher("/Car-Dearler/SelectAllDealer_frame.jsp");
//			rd.forward(request, response);
//			return;
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//	}

}