package iSpancar.Service;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;




@Controller
@RequestMapping("/backstage")
public class ServiceCrudController {
	

	@Autowired 
	private iSpanCarService sService;

	
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
		
		return "/service/addservicesuccess";
	}
	
	@PostMapping("/serviceSelect.controller") 
	public String findByService(@RequestParam("servicename") String servicename,Model m) {
		 ServiceBean resultBean = sService.findByService(servicename);
		 
		 
		
		if(resultBean!=null) {
			m.addAttribute("Service", resultBean);
			return "/service/selectserviceone" ;
		}
		
        m.addAttribute("Result", "no Result");
        return "/service/selectservice";
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
				return "service/updateservicesuccess";
			}

	//透過Id接值進入修改頁面的controller(原selectIdToUpdate)
	@PostMapping("/JumptoUpdateService")
	public String selectIdToUpdateAction(@RequestParam("servicename") String servicename, Model m) {
		
		 
		 ServiceBean s1= iSpanCarService.findByService(servicename);
		 List<ServiceBean> list = new ArrayList<ServiceBean>();
		 list.add(s1);
		m.addAttribute("toUpdate", list);
		
		return "service/updateservice";
	}
	
	
	
	@PostMapping("/serviceDeleteController") 
	public String serviceDelete(@RequestParam("servicename") String servicename)
			{
		ServiceBean sBean3 = new ServiceBean();
		sBean3.setServicename(servicename);
		sService.deleteService(sBean3);
		return "/service/selectallservice";
		
	}
	
	@Autowired
	private iSpanCarService iSpanCarService1;
	
	@GetMapping("/serviceAllController")
	public String selectAll(Model model) {
		
		try {
			List<ServiceBean> list = iSpanCarService1.findAllService();
			model.addAttribute("serviceSelectall", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "service/selectallservice";
		
	}


	
}
