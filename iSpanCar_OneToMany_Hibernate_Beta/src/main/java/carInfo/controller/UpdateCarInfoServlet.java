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

import org.eclipse.jdt.internal.compiler.env.IModule.IPackageExport;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import carDealer.model.CarDealerBean;
import carInfo.dao.CarInfoDao;
import carInfo.model.CarInfoBean;
import tw.hibernatedemo.service.ISpanCarService;
import tw.hibernatedemo.util.HibernateUtil;

@MultipartConfig
@WebServlet("/UpdateCarInfoServlet.do")
public class UpdateCarInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			request.setCharacterEncoding("UTF-8");
			ISpanCarService iSpanService = new ISpanCarService();
			
			String carNo = request.getParameter("carNo");
			int carNumber = Integer.parseInt(carNo);
			String dealerBean = request.getParameter("carDealName");
			String accountNumber = request.getParameter("accountNumber");
			String carBrand = request.getParameter("carBrand");
			String carName = request.getParameter("carName");
			String stock = request.getParameter("stock");

			Part filePart = request.getPart("carImage");
			System.out.println(filePart);
			InputStream is = filePart.getInputStream();
			long size = filePart.getSize();
			//file to Blob方法
			Blob blob = iSpanService.filetoBlob(is, size);
			
			String carDescription = request.getParameter("carDescription");
			String announceDate = request.getParameter("announceDate");

			List<CarInfoBean> list = iSpanService.findByCarNoLike(carNumber);
			
			//取原來的值
			CarInfoBean originInfoBean = new CarInfoBean();
			for(CarInfoBean cib : list) {
				originInfoBean.setCarNo(cib.getCarNo());
				originInfoBean.setCarDealerBean(cib.getCarDealerBean());
				originInfoBean.setAccountNumber(cib.getAccountNumber());
				originInfoBean.setCarBrand(cib.getCarBrand());
				originInfoBean.setCarName(cib.getCarName());
				originInfoBean.setStock(cib.getStock());
				originInfoBean.setCarImage(cib.getCarImage());
				originInfoBean.setCarDescription(cib.getCarDescription());
				originInfoBean.setAnnounceDate(cib.getAnnounceDate());
				
			}
			
			//從CarDealBean取原來的值的carDealName
			String carDealName = originInfoBean.getCarDealerBean().getCarDealName();
			
			Integer number = (carNo.equals("")) ? 
					originInfoBean.getCarNo() : carNumber;
			String dealer = (dealerBean.equals("")) ? 
					carDealName : dealerBean;
			String account = (accountNumber.equals("")) ? 
					originInfoBean.getAccountNumber() : accountNumber;
			String brand = (carBrand.equals("")) ? 
					originInfoBean.getCarBrand() : carBrand;
			String carModel = (carName.equals("")) ? 
					originInfoBean.getCarName() : carName;
			Integer amount = (stock.equals("")) ? 
					originInfoBean.getStock() : Integer.parseInt(stock);
			Blob carPhoto = (filePart.getSize()==0) ? 
					originInfoBean.getCarImage() : blob;
			String carMemo = (carDescription.equals("")) ? 
					originInfoBean.getCarDescription() : carDescription;
			String publishDate = (announceDate.equals("")) ? 
					originInfoBean.getAnnounceDate() : announceDate;
			
			List<CarDealerBean> cdBean = iSpanService.findByCarDealerName(dealer);
			CarDealerBean firstSellerBean = cdBean.get(0);
			System.out.println(firstSellerBean);
			CarInfoBean infoBean = new CarInfoBean(number, firstSellerBean, account, brand, carModel, amount, carPhoto, carMemo, publishDate);
			System.out.println(infoBean);
			iSpanService.updateByCarNo(infoBean);
			List<CarInfoBean> newList = iSpanService.findByCarNoLike(carNumber);
			
			request.setAttribute("UpdateCarInfo", newList);
			RequestDispatcher rd = request.getRequestDispatcher("/Car-Infomation/UpdateCarInfo_frame.jsp");
			rd.forward(request, response);
			return;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
