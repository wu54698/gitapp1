package iSpan_Car;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
			String carDealVATNumber = request.getParameter("carDealVATNumber");
			int VATNumber = Integer.parseInt(carDealVATNumber);
			String carDealName = request.getParameter("carDealName");
			String accountNumber = request.getParameter("accountNumber");
			int account = Integer.parseInt(accountNumber);
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
					(VATNumber, carDealName, account, carBrand, carName, amount, blob, carDescription, announceDate);
			infoDao.addCarInfo(infoBean);
			
			String contextPath = request.getContextPath();
			response.sendRedirect(
					contextPath + "/iSpan_Car/CarInfoSuccess.jsp"
					);
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
