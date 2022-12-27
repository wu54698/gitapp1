package carInfo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import carDealer.model.ISpanCarService;
import carInfo.dao.CarInfoDao;
import carInfo.model.CarInfoBean;


@WebServlet("/AllImageServlet.do")
public class AllImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String carNo = request.getParameter("carNo");
		int carNumber = Integer.parseInt(carNo);
//		CarInfoDao infoDao = new CarInfoDao();
		ISpanCarService iSpanService = new ISpanCarService();
		
		try {
			List<CarInfoBean> list = iSpanService.findByCarNoLike(carNumber);
			
			for(CarInfoBean infoBean : list) {
				InputStream is = infoBean.getCarImage().getBinaryStream();
				OutputStream os = response.getOutputStream();
				int len = 0;
				byte[] bytes = new byte[8192];
				while((len = is.read(bytes)) != -1) {
					os.write(bytes, 0, len);
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
		
	}
