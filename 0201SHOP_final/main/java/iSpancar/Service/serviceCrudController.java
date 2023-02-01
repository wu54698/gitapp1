package iSpancar.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;



@Controller
public class serviceCrudController {
	
	private static final String Servicename = null;

	@Autowired 
	private iSpanCarService sService;
	
//	@PostMapping("/iSpanCarService")
//	@ResponseBody
//	public iSpanCarService iSpanCarInsertService(@RequestBody ServiceBean sBean) {
//		return sBean.insert(sBean);
//	}
//	
	
	@Autowired
	private iSpanCarService iSpanCarService;
	
	@GetMapping("/serviceimage.controller")
	@ResponseBody
	public byte[] serviceimage(@RequestParam("servicename") String servicename){
		try {
			ServiceBean sBean = iSpanCarService.findCarimage(servicename);
			InputStream is = sBean.getCarimage().getBinaryStream();
			return IOUtils.toByteArray(is);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}



	@PostMapping("/serviceInsert.controller")
	public String serviceInsert(@RequestParam("servicename") String servicename, 
								@RequestParam("Carimage") MultipartFile mf, 
			                    @RequestParam("Servicedescription") String Servicedescription,
			                    @RequestParam("Serviceinfomation") String Serviceinfomation,
			                    @RequestParam("Contactperson") String Contactperson,
			                    @RequestParam("Resellernonreseller") String Resellernonreseller)
	{
		try {
		ServiceBean sBean = new ServiceBean();
		byte[] bytes;
			bytes = mf.getBytes();
		Blob blob = new SerialBlob(bytes);
		sBean.setServicename(servicename);
		sBean.setCarimage(blob);
		sBean.setServicedescription(Servicedescription);
		sBean.setServiceinfomation(Serviceinfomation);
		sBean.setContactperson(Contactperson);
		sBean.setResellernonreseller(Resellernonreseller);
		
		sService.insert(sBean);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SerialException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/service/signin3";
	}
	
	@PostMapping("/serviceSelect.controller") 
	public String findByService(@RequestParam("servicename") String servicename,Model m) {
		 ServiceBean resultBean = sService.findByService(servicename);
		 
		 
		
		if(resultBean!=null) {
			m.addAttribute("Service", resultBean);
			return "/service/SelectService4" ;
		}
		
        m.addAttribute("Result", "no Result");
        return "/service/SelectService3";
	}
	

	
	@PostMapping("/serviceUpdateController")
	protected String serviceUpdate(@RequestParam("servicename") String servicename, 
			@RequestParam("Carimage") MultipartFile Carimage, 
          @RequestParam("Servicedescription") String Servicedescription,
          @RequestParam("Serviceinfomation") String Serviceinfomation,
          @RequestParam("Contactperson") String Contactperson,
          @RequestParam("Resellernonreseller") String Resellernonreseller) {

				try {

					byte[] bytes;
					bytes = Carimage.getBytes();
					Blob blob = new SerialBlob(bytes);

					ServiceBean sBean = iSpanCarService.findByService(servicename);
					List<ServiceBean> list = new ArrayList<>();
					list.add(sBean);
					ServiceBean originBean = new ServiceBean();
					for(ServiceBean sib : list) {
					originBean.setServicename(sib.getServicename());
					originBean.setCarimage(sib.getCarimage());
					originBean.setServicedescription(sib.getServicedescription());
					originBean.setServiceinfomation(sib.getServiceinfomation());
					originBean.setContactperson(sib.getContactperson());
					originBean.setResellernonreseller(sib.getResellernonreseller());
					
				String NewServicename = (servicename.equals("")) ? originBean.getServicename() : servicename;
				Blob NewCarimage = 	(bytes.length==0) ? originBean.getCarimage(): blob;
				String NewServicedescription = (Servicedescription.equals("")) ? originBean.getServicedescription() : Servicedescription;
				String NewServiceinfomation = (Serviceinfomation.equals("")) ? originBean.getServiceinfomation() : Serviceinfomation;
				String NewContactperson = (Contactperson.equals("")) ? originBean.getContactperson() : Contactperson;
				String NewResellernonreseller = (Resellernonreseller.equals("")) ? originBean.getResellernonreseller() : Resellernonreseller;

//				System.out.println(name+" "+mobile+" "+address+" "+time+" "+person+" "+VAT);
					ServiceBean bean = new ServiceBean(NewServicename, NewCarimage, NewServicedescription, NewServiceinfomation,
							NewContactperson, NewResellernonreseller);

					iSpanCarService.updateByCarDealName(bean);
					
					
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();

				}
				return "service/UpdateService4";
			}

	
	
	
	@PostMapping("/serviceDeleteController") 
	public String serviceDelete(@RequestParam("Servicename") String servicename)
//			@RequestParam("Carimage") Blob Carimage, 
//            @RequestParam("Servicedescription") String Servicedescription,
//            @RequestParam("Serviceinfomation") String Serviceinfomation,
//            @RequestParam("Contactperson") String Contactperson,
//            @RequestParam("Reseller_nonreseller") String Reseller_nonreseller) 
			{
		ServiceBean sBean3 = new ServiceBean();
		sBean3.setServicename(servicename);
		sService.deleteService(sBean3);
		return "/service/DeleteService4";
	}
	
	@Autowired
	private iSpanCarService iSpanCarService1;;
	
	@GetMapping("/serviceAllController")
	@RequestMapping(path="/serviceAllController" , method= RequestMethod.GET)
	public String selectAll(Model model) {
		
		try {
			List<ServiceBean> list = iSpanCarService1.findAllService();
			model.addAttribute("serviceSelectall", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "service/SelectallService";
		
	}
}
