package carInfo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import carInfo.dao.CarInfoDao;
import carInfo.model.CarInfoBean;

//新增車輛資訊
@MultipartConfig()
@WebServlet("/CarInfoServlet.do")
public class CarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			CarInfoDao infoDao = new CarInfoDao();

			// 讀取瀏覽器送入的欄位內的資料
			String carNo = request.getParameter("carNo");
			int carNumber = Integer.parseInt(carNo);
			String carDealName = request.getParameter("carDealName");
			String accountNumber = request.getParameter("accountNumber");
			String carBrand = request.getParameter("carBrand");
			String carName = request.getParameter("carName");
			String stock = request.getParameter("stock");
			int amount = Integer.parseInt(stock);
			

			Part filePart = request.getPart("carImage");
			InputStream is = filePart.getInputStream();
			long size = filePart.getSize();

			Blob blob = infoDao.filetoBlob(is, size);
			
			String carDescription = request.getParameter("carDescription");
			String announceDate = request.getParameter("announceDate");
			
			CarInfoBean infoBean = new CarInfoBean
					(carNumber, carDealName, accountNumber, carBrand, carName, amount, blob, carDescription, announceDate);
			infoDao.addCarInfo(infoBean);
			List<CarInfoBean> newList = infoDao.findAllCar();
			
			request.setAttribute("SelectAllCar", newList);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Infomation/SelectAllCar_frame.jsp");
			rd.forward(request, response);
			return;
//			String contextPath = request.getContextPath();
//			response.sendRedirect(
//					contextPath + "/iSpan_Car/SelectAllCar.jsp"
//					);
			//RequestDispatcher rd = request.getRequestDispatcher("???????");
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

}