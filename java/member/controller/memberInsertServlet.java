package member.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpRequest;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import member.dao.MemberDao;
import member.model.MemberBean;


@MultipartConfig()
@WebServlet("/memberInsertServlet.do")
public class memberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
	try {	
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("accountnumber");
		String password = request.getParameter("memberpassword");
		String name = request.getParameter("membername");
		String phone = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		String address = request.getParameter("memberaddress");
		String platenumber = request.getParameter("platenumber");
		String birthday = request.getParameter("birthday");
		String idnumber = request.getParameter("idnumber");
		
		MemberDao mdao = new MemberDao();
		
		Part filePart = request.getPart("file");
		InputStream is = filePart.getInputStream();
		long size = filePart.getSize();
		
		Blob blob = mdao.fileToBlob(is,size) ;
		String filename = mdao.getFileName(filePart);
	    
		
		MemberBean bean = new MemberBean(account, password, name, phone, email, address, platenumber, birthday, idnumber,blob,filename);
		
		
		
			mdao.insertMemberBean(bean);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath +"/member/Ok.jsp");
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ServletException e) {
			e.printStackTrace();
		}
	}

}
