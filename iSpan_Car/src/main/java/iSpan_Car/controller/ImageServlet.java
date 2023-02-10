package iSpan_Car.controller;

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

import iSpan_Car.dao.CarInfoDao;
import iSpan_Car.model.CarInfoBean;


@WebServlet("/ImageServlet")
public class ImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String carBrand = request.getParameter("carBrand");
		CarInfoDao infoDao = new CarInfoDao();
		
		try {
			List<CarInfoBean> list = infoDao.findByCarBrandLike(carBrand);
			
			for(CarInfoBean cBean : list) {
				InputStream is = cBean.getCarImage().getBinaryStream();
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
