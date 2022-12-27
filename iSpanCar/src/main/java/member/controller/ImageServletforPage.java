package member.controller;

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
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import member.dao.MemberDao;
import member.model.MemberBean;
import member.service.MemberService;
import util.HibernateUtil;

/**
 * Servlet implementation class ImageServletforPage
 */
@WebServlet("/ImageServletforPage.do")
public class ImageServletforPage extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession httpSession = request.getSession();
		MemberBean mb = (MemberBean) httpSession .getAttribute("LoginOK");
		MemberService mService = new MemberService();
		
		
		try {
			
			MemberBean mBean = mService.findImgbyaccountnumber(mb.getAccountnumber());

			
				InputStream is = mBean.getFile().getBinaryStream();
				OutputStream os = response.getOutputStream();
				
			

				// 由圖片檔的檔名來得到檔案的MIME型態
				String mimeType = getServletContext().getMimeType(mBean.getFilename());
				response.setContentType(mimeType);
				
				int len = 0;
				byte[] bytes = new byte[8192];
				while ((len = is.read(bytes)) != -1) {
					os.write(bytes, 0, len);
				}
				os.close();
				is.close();
				

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}


}
