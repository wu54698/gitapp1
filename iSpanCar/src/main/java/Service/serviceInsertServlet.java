package Service;

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


@MultipartConfig()
@WebServlet("/serviceInsertServlet.do")
public class serviceInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response)  {
	try {	
		request.setCharacterEncoding("UTF-8");
		String Service_name =  request.getParameter("servicename");
		String Servicedescription = request.getParameter("Servicedescription");
		String Serviceinfomation = request.getParameter("Serviceinfomation");
		String Contactperson = request.getParameter("Contactperson");
		String Reseller_nonreseller = request.getParameter("Reseller_nonreseller");
		
		iSpanCarService iService = new iSpanCarService();
		
		Part filePart = request.getPart("Carimage");
		InputStream is = filePart.getInputStream();
		long size = filePart.getSize();
		
		Blob blob = iService.filetoBlob(is,size) ;
	    
		
		ServiceBean bean = new ServiceBean(Service_name,blob,Servicedescription,Serviceinfomation,Contactperson,Reseller_nonreseller);
		
	
		
		iService.addService(bean);
		
		String contextPath = request.getContextPath();
		response.sendRedirect(contextPath +"/Service/signin3.jsp");
		
		
		} catch (SQLException e) {
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
