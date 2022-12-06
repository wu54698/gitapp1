package model;
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

@WebServlet("/AllProductImgServlet")
public class AllProductImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ShopDetailDao sDao = new ShopDetailDao();
		try {
			List<ShopDetailBean> list = sDao.findAllProduct();

			for (ShopDetailBean sBean : list) {
				InputStream is = sBean.getProductimage().getBinaryStream();
				OutputStream os = response.getOutputStream();

				// 由圖片檔的檔名來得到檔案的MIME型態
				String myType = getServletContext().getMimeType(sBean.getProductimage_name());
				response.setContentType(myType);
				
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