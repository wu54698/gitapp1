package Service;

import java.awt.Image;
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

@MultipartConfig()
@WebServlet("/serviceUpdateServlet.do")
public class serviceUpdateServlet extends HttpServlet{
		private static final long serialVersionUID = 1L;

		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// TODO Auto-generated method stub

			try {
				request.setCharacterEncoding("UTF-8");
				iSpanCarService iSpanService = new iSpanCarService();

				String Service_name = request.getParameter("servicename");
				String Servicedescription = request.getParameter("Servicedescription");
				String Serviceinfomation = request.getParameter("Serviceinfomation");
				String Contactperson = request.getParameter("Contactperson");
				String Reseller_nonreseller = request.getParameter("Reseller_nonreseller");

				Part filePart = request.getPart("Carimage");
				InputStream is = filePart.getInputStream();
				long size = filePart.getSize();

				Blob blob = iSpanService.filetoBlob(is, size);

				List<ServiceBean> list = iSpanService.findByService(Service_name);
				ServiceBean originBean = new ServiceBean();
				for(ServiceBean sib : list) {
				originBean.setService_name(sib.getService_name());
				originBean.setCarimage(sib.getCarimage());
				originBean.setServicedescription(sib.getServicedescription());
				originBean.setServiceinfomation(sib.getServiceinfomation());
				originBean.setContactperson(sib.getContactperson());
				originBean.setReseller_nonreseller(sib.getReseller_nonreseller());
				
			String NewService_name = (Service_name.equals("")) ? originBean.getService_name() : Service_name;
			Blob NewCarimage = 	(filePart.getSize()==0) ? originBean.getCarimage(): blob;
			String NewServicedescription = (Servicedescription.equals("")) ? originBean.getServicedescription() : Servicedescription;
			String NewServiceinfomation = (Serviceinfomation.equals("")) ? originBean.getServiceinfomation() : Serviceinfomation;
			String NewContactperson = (Contactperson.equals("")) ? originBean.getContactperson() : Contactperson;
			String NewReseller_nonreseller = (Reseller_nonreseller.equals("")) ? originBean.getReseller_nonreseller() : Reseller_nonreseller;

//			System.out.println(name+" "+mobile+" "+address+" "+time+" "+person+" "+VAT);
				ServiceBean bean = new ServiceBean(NewService_name, NewCarimage, NewServicedescription, NewServiceinfomation,
						NewContactperson, NewReseller_nonreseller);

				iSpanService.updateByCarDealName(bean);
				String contextPath = request.getContextPath();
				response.sendRedirect(contextPath + "/Service/UpdateService4.jsp");
				}
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


