package iSpancar.Service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ServiceClientController {
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
	
	
	@GetMapping("/clientserviceAllController")
	public String clientselectAll(Model model) {
		
		try {
			List<ServiceBean> list = iSpanCarService.findAllService();
			model.addAttribute("clientselectAll", list);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return "service/clientselectall";
	}
	
	
	@GetMapping("/clientserviceOnecontroller/{servicename}") 
	public String findByService1(@PathVariable("servicename") String servicename,Model m) {
		System.out.println(servicename);
		 ServiceBean resultBean = sService.findByService(servicename);
			System.out.println(resultBean);
			if(resultBean!=null) {
				m.addAttribute("Service", resultBean);
			}
			return "service/clientselectone" ;
	}
	
}

