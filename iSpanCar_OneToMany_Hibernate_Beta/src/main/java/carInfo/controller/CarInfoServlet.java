package carInfo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import carDealer.model.CarDealerBean;
import carInfo.dao.CarInfoDao;
import carInfo.model.CarInfoBean;
import tw.hibernatedemo.service.ISpanCarService;
import tw.hibernatedemo.util.HibernateUtil;

//新增車輛資訊
@MultipartConfig()
@WebServlet("/CarInfoServlet.do")
public class CarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private SessionFactory factory;
	private Session session;

	public CarInfoServlet() {
		this.factory = HibernateUtil.getSessionFactory();
		this.session = factory.getCurrentSession();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			// 定義存放錯誤訊息的 Collection物件
			Map<String, String> errorMessage = new HashMap<>();
			request.setAttribute("ErrorMsg", errorMessage);
			
			request.setCharacterEncoding("UTF-8");
//			CarInfoDao infoDao = new CarInfoDao();
			
			ISpanCarService iSpanService = new ISpanCarService();
			
			// 讀取瀏覽器送入的欄位內的資料
//			String carNo = request.getParameter("carNo");
//			int carNumber = Integer.parseInt(carNo);
			String dealerBean = request.getParameter("carDealName");

			String accountNumber = request.getParameter("accountNumber");
			String carBrand = request.getParameter("carBrand");
			String carName = request.getParameter("carName");
			String stock = request.getParameter("stock");
			int amount = Integer.parseInt(stock);
			
			Part filePart = request.getPart("carImage");
			InputStream is = filePart.getInputStream();
			long size = filePart.getSize();

			Blob blob = iSpanService.filetoBlob(is, size);
			
			String carDescription = request.getParameter("carDescription");
			String announceDate = request.getParameter("announceDate");
			
			List<CarDealerBean> checkDealer = iSpanService.findByCarDealerName(dealerBean);
			
			CarDealerBean firstSellerBean = null;
				if(checkDealer.size()==0) {
					errorMessage.put("carDealName", "該車商名稱尚未登錄");
				}else {
					firstSellerBean = checkDealer.get(0);
				}
			
			iSpanService.addCarInfo(firstSellerBean, accountNumber, carBrand, carName, amount, blob, carDescription, announceDate);
			List<CarInfoBean> newList = iSpanService.findAllCar();

			
			//錯誤成立則跳轉至原頁面
			if (!errorMessage.isEmpty()) {
				RequestDispatcher rd = request.getRequestDispatcher("/Car-Infomation/CarInfoForm_frame.jsp");
				rd.forward(request, response);
				return;
			}	
			
			request.setAttribute("SelectAllCar", newList);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Infomation/SelectAllCar_frame.jsp");
			rd.forward(request, response);
			return;
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}