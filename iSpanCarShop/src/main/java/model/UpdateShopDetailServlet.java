package model;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
@MultipartConfig()
@WebServlet("/UpdateShopDetailServlet.do")
public class UpdateShopDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			// 設定輸入資料的編碼
			request.setCharacterEncoding("UTF-8");
			String productnno = request.getParameter("productno");
			int productnnoint = Integer.parseInt(productnno);
			String productname = request.getParameter("productname");
//			String type = request.getParameter("type");
//			String spec = request.getParameter("spec");
			String price = request.getParameter("price");
			int priceint = Integer.parseInt(price);
//			String uptime = request.getParameter("uptime");
			String stock = request.getParameter("stock");
			int stockint = Integer.parseInt(stock);
			String productinfo = request.getParameter("productinfo");

			ShopDetailDao sDao = new ShopDetailDao();

			Part imagePart = request.getPart("productimage");
			InputStream is = imagePart.getInputStream();
			long size = imagePart.getSize();
//
			Blob imgblob = sDao.fileToBlob(is, size);
			String productimage_name = sDao.getFileName(imagePart);

//			ShopDetailBean mb = new ShopDetailBean(productname, type, spec, priceint, stockint, uptime, productinfo,
//					imgblob, productimage_name);
			ShopDetailBean mb = new ShopDetailBean(productnnoint,productname,priceint,stockint,productinfo,imgblob,productimage_name);

			sDao.updateProduct(mb);

			RequestDispatcher rd = request.getRequestDispatcher("/SHOP_DETAIL/UpdateProductSucess.jsp");
			rd.forward(request, response);
			return;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
