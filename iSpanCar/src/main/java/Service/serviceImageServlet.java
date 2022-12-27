package Service;

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

@WebServlet("/serviceImageServlet")
public class serviceImageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String Service_name = request.getParameter("Service_name");
		
		iSpanCarService iService = new iSpanCarService();		
		try {
			List<ServiceBean> list = iService.findByService(Service_name);
				for(ServiceBean sBean : list) {
					// 由圖片檔的檔名來得到檔案的MIME型態
				InputStream is =sBean.getCarimage().getBinaryStream();
				OutputStream os=response.getOutputStream();
				int len = 0;
				byte[] bytes = new byte[8192];
				while ((len = is.read(bytes)) != -1) {
					os.write(bytes, 0, len);
				}
				}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
