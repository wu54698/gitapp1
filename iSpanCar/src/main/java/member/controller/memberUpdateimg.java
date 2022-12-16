package member.controller;

import java.io.IOException;
import java.io.InputStream;
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

import member.dao.MemberDao;
import member.model.MemberBean;

@MultipartConfig
@WebServlet("/memberUpdateimg.do")
public class memberUpdateimg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		MemberDao mDao = new MemberDao();
		String accountnumber = request.getParameter("accountnumber");
		
		Part part = request.getPart("file");
//		System.out.println(part);
		InputStream is = part.getInputStream();
		long size = part.getSize();
		if(size==0) {
			
		}else {
			Blob blob =	mDao.fileToBlob(is, size);
		
			mDao.updateImgByAccount(accountnumber, blob);
		}
		
		
		
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

}
