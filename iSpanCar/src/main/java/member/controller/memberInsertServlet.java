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
import javax.sound.midi.Soundbank;

import member.dao.MemberDao;
import member.model.MemberBean;
import member.model.MemberPosition;
import member.model.PermissionsOfPosition;
import member.service.MemberService;


@MultipartConfig()
@WebServlet("/memberInsertServlet.do")
public class memberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)  {
		doPost(request, response);
	}
	
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
	try {	
		request.setCharacterEncoding("UTF-8");
		String account = request.getParameter("accountnumber");
		String password = request.getParameter("memberpassword");
		String name = request.getParameter("membername");
		String phone = request.getParameter("phonenumber");
		String email = request.getParameter("email");
		
		String city = request.getParameter("city");
		String town = request.getParameter("town");
		String address = request.getParameter("memberaddress");
		
		String platenumber = request.getParameter("platenumber");
		
		String birthdayyear = request.getParameter("year");
		String birthdaymonth = request.getParameter("month");
		String birthdaydate = request.getParameter("date");
		int borthdaylength = birthdaymonth.length();
		birthdaymonth = birthdaymonth.substring(0,borthdaylength-5);
		String birthday = birthdayyear.substring(0,4) +"-"+ birthdaymonth +"-"+ birthdaydate;
		
		String idnumber = request.getParameter("idnumber");
		String card1 = request.getParameter("card1");
		String card2 = request.getParameter("card2");
		String card3 = request.getParameter("card3");
		String card4 = request.getParameter("card4");
		String cardnumber = card1 + "-" + card2 + "-" + card3 + "-" + card4;
		
		MemberService mService = new MemberService();
		
		Part filePart = request.getPart("file");
	
		InputStream is = filePart.getInputStream();
		long size = filePart.getSize();
		
		Blob blob = mService.fileToBlob(is,size) ;
		String filename = mService.getFileName(filePart);
		
		
		
		MemberBean bean = new MemberBean(account, password, name, phone, email,city + town+ address, platenumber, birthday, idnumber,cardnumber,blob,filename);
		
		mService.insertMemberBean(bean);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath +"/");
		
		
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
