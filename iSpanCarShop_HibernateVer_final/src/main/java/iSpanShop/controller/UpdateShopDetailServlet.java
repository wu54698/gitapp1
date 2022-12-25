package iSpanShop.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
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

import iSpanShop.model.ShopDetailBean;
import iSpanShop.model.ShopDetailDao;

@MultipartConfig()
@WebServlet("/UpdateShopDetailServlet.do")
public class UpdateShopDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {
			// 設定輸入資料的編碼
			request.setCharacterEncoding("UTF-8");
			String productno = request.getParameter("productno");
			Integer productnoint = Integer.parseInt(productno);
			String productname = request.getParameter("productname");
			// String type = request.getParameter("type");
			// String spec = request.getParameter("spec");
			String price = request.getParameter("price");
			int priceint = Integer.parseInt(price);
			// String uptime = request.getParameter("uptime");
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

			// ShopDetailBean mb = new ShopDetailBean(productname, type, spec, priceint,
			// stockint, uptime, productinfo,
			// imgblob, productimage_name);
//			ShopDetailBean mb = new ShopDetailBean(productnoint, productname, priceint, stockint, productinfo, imgblob,
//					productimage_name);

			// sDao.updateProduct(mb);
			List<ShopDetailBean> list = sDao.findByProductno(productno);

			// 驗證部分 三元運算
			ShopDetailBean ogBean = new ShopDetailBean();
			for (ShopDetailBean sdb : list) {
				ogBean.setProductno(sdb.getProductno());
				ogBean.setProductname(sdb.getProductname());
				ogBean.setPrice(sdb.getPrice());
				ogBean.setStock(sdb.getStock());
				ogBean.setProductinfo(sdb.getProductinfo());
				ogBean.setProductimage(sdb.getProductimage());
				ogBean.setProductimage_name(sdb.getProductimage_name());
			}
			Integer pno = (productno.equals("")) ? ogBean.getProductno() : productnoint;
			String pname = (productname.equals("")) ? ogBean.getProductname() : productname;
			int pprice = (price.equals("")) ? ogBean.getPrice() : priceint;
			int pstock = (stock.equals("")) ? ogBean.getStock() : stockint;
			String pproductinfo = (productinfo.equals("")) ? ogBean.getProductinfo() : productinfo;
			Blob pimg = (imagePart.getSize() == 0) ? ogBean.getProductimage() : imgblob;
			String pproductimage_name = (productimage_name.equals("")) ? ogBean.getProductimage_name()
					: productimage_name;

			ShopDetailBean bean = new ShopDetailBean(pno, pname, pprice, pstock, pproductinfo, pimg,
					pproductimage_name);

			sDao.updateProduct(bean);

			// List<ShopDetailBean> newList = sDao.findByProductno(productno);
			// request.setAttribute("UpdateProduct", newList);
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/SHOP_DETAIL/UpdateProductSucess.jsp");
			// rd.forward(request, response);
			String contextPath = request.getContextPath();
			response.sendRedirect(contextPath + "/SHOP_DETAIL/UpdateProductSucess.jsp");
			return;

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
}