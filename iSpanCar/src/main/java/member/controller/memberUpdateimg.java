package member.controller;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import member.dao.MemberDao;
import member.model.MemberBean;
import member.service.MemberService;
import util.HibernateUtil;

@MultipartConfig()
@WebServlet("/memberUpdateimg.do")
public class memberUpdateimg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");

		System.out.println("-----------memberUpdateimg------------");
		
		MemberService mService = new MemberService();
		String accountnumber = request.getParameter("accountnumber");
		
		Part part = request.getPart("file");
		InputStream is = part.getInputStream();
		long size = part.getSize();
		if(size==0) {
			
		}else {
			Blob blob =	mService.fileToBlob(is, size);
		
			mService.updateImgByAccount(accountnumber, blob);
			
//			response.setContentType(part.getContentType());
//			OutputStream os = response.getOutputStream();
			
//			os.write(is.readAllBytes());
//			int len = 0;
//			byte[] bytes = new byte[8192];
//			while ((len = is.read(bytes)) != -1) {
//				os.write(bytes, 0, len);
//			}
//			os.close();
//			is.close();
			
		}
		
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
