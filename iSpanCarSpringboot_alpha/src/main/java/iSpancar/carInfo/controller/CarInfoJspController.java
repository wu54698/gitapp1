package iSpancar.carInfo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CarInfoJspController {

	@GetMapping("/CarInfoForm")
	public String processViewCarController() {
		return "Car-Infomation/CarInfoForm_frame";
	}
	
	@GetMapping("/JumptoUpdateCarInfoSheet")
	public String processUpdateSheetController() {
		return "Car-Infomation/JumptoUpdateCarInfoSheet_frame";
	}

	@GetMapping("/UpdateCarInfo")
	public String processUpdateCarController() {
		return "Car-Infomation/UpdateCarInfo_frame";
	}
	
	@GetMapping("/SelectAllCar")
	public String processSelectAllCarController() {
		return "Car-Infomation/SelectAllCar_frame";
	}
	
//	@GetMapping("/SelectCarByBrand")
//	public String processFindBrandController() {
//		return "Car-Infomation/SelectCarByBrand_frame";
//	}
	

}
