package iSpancar.carDealer.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iSpancar.carDealer.model.CarDealerBean;
import iSpancar.carDealer.service.ISpanCarService;

@Controller
public class CarDealerController {

	@Autowired
	private ISpanCarService iSpanCarService;

	// 新增車商的controller
	@PostMapping(path = "/addCarDealer")
	public String addDealerAction(@RequestParam("carDealName") String carDealName,
			@RequestParam("carDealPhone") String carDealPhone, @RequestParam("carDealAddress") String carDealAddress,
			@RequestParam("openTime") String openTime, @RequestParam("contactPerson") String contactPerson,
			@RequestParam("carDealVATNumber") int carDealVATNumber, Model m) {

		CarDealerBean dealerBean = new CarDealerBean();

		// 定義存放錯誤訊息的 Collection物件
		Map<String, String> errorMessage = new HashMap<>();
		m.addAttribute("ErrorMsg", errorMessage);

		List<CarDealerBean> newlist = iSpanCarService.findAllDealer();

		List<CarDealerBean> list = newlist;

		// 讀取瀏覽器送入的欄位內的資料
		dealerBean.setCarDealName(carDealName);

		// 檢查使用者所輸入的資料是否重複
		for (CarDealerBean carDealerBean : list) {
			if (carDealerBean.getCarDealName().equals(carDealName)) {
				errorMessage.put("carDealName", "該車商名稱已登錄");
			}
		}
		dealerBean.setCarDealPhone(carDealPhone);
		dealerBean.setCarDealAddress(carDealAddress);
		dealerBean.setOpenTime(openTime);
		dealerBean.setContactPerson(contactPerson);
		dealerBean.setCarDealVATNumber(carDealVATNumber);

		// 有錯誤則跳回車商主頁
		if (!errorMessage.isEmpty()) {
			return "Car-Dealer/CarDealerForm_frame";
		}

		iSpanCarService.addDealer(dealerBean);

		// 跳轉jsp頁面
		List<CarDealerBean> newList = iSpanCarService.findAllDealer();
		m.addAttribute("SelectAllDealer", newList);

		return "Car-Dealer/SelectAllDealer_frame";
	}

	// 刪除車商的controller
	@PostMapping("/deleteCarDealer")
	public String deleteDealerAction(@RequestParam String carDealName) {
		iSpanCarService.deleteCarDealer(carDealName);
		return "Car-Dealer/SelectAllDealer_frame";
	}

	// 修改的車商controller
	@PostMapping("/updateCarDealer")
	public String updateDealerAction(@RequestParam("carDealName") String carDealName,
			@RequestParam("carDealPhone") String carDealPhone, @RequestParam("carDealAddress") String carDealAddress,
			@RequestParam("openTime") String openTime, @RequestParam("contactPerson") String contactPerson,
			@RequestParam("carDealVATNumber") String carDealVATNumber, Model m) {

		CarDealerBean dealerBean = new CarDealerBean();

		// 定義存放錯誤訊息的 Collection物件
		Map<String, String> errorMessage = new HashMap<>();
		m.addAttribute("NotFoundMsg", errorMessage);

		List<CarDealerBean> verifyList = iSpanCarService.findAllDealer();

		// 讀取瀏覽器送入的欄位內的資料
		dealerBean.setCarDealName(carDealName);

		// 檢查使用者所輸入的資料是否錯誤
		boolean duplicateCheck = false;
		for (CarDealerBean cdb : verifyList) {
			if (cdb.getCarDealName().equals(carDealName)) {
				duplicateCheck = true;
			}
		}
		if (!duplicateCheck) {
			errorMessage.put("carDealName", "找無此車商");
		}
		dealerBean.setCarDealPhone(carDealPhone);
		dealerBean.setCarDealAddress(carDealAddress);
		dealerBean.setOpenTime(openTime);
		dealerBean.setContactPerson(contactPerson);

		int VATNumber = 0;
		if (carDealVATNumber != "") {
			VATNumber = Integer.parseInt(carDealVATNumber);
			dealerBean.setCarDealVATNumber(VATNumber);
		}

		// 取原來舊的值
		List<CarDealerBean> list = iSpanCarService.findByCarDealerName(carDealName);
		CarDealerBean originBean = new CarDealerBean();
		for (CarDealerBean cdb : list) {
			originBean.setCarDealName(cdb.getCarDealName());
			originBean.setCarDealPhone(cdb.getCarDealPhone());
			originBean.setCarDealAddress(cdb.getCarDealAddress());
			originBean.setOpenTime(cdb.getOpenTime());
			originBean.setContactPerson(cdb.getContactPerson());
			originBean.setCarDealVATNumber(cdb.getCarDealVATNumber());
		}

		String name = (carDealName.equals("")) ? originBean.getCarDealName() : carDealName;
		String mobile = (carDealPhone.equals("")) ? originBean.getCarDealPhone() : carDealPhone;
		String address = (carDealAddress.equals("")) ? originBean.getCarDealAddress() : carDealAddress;
		String time = (openTime.equals("")) ? originBean.getOpenTime() : openTime;
		String person = (contactPerson.equals("")) ? originBean.getContactPerson() : contactPerson;
		int VAT = (carDealVATNumber.equals("")) ? originBean.getCarDealVATNumber() : VATNumber;

		if (!errorMessage.isEmpty()) {
			return "/CarDealerForm_frame";
		}

		CarDealerBean updateCarDealerBean = new CarDealerBean(name, mobile, address, time, person, VAT);

		iSpanCarService.updateByCarDealName(updateCarDealerBean);

		// 跳轉jsp頁面
		List<CarDealerBean> newList = iSpanCarService.findByCarDealerName(carDealName);
		m.addAttribute("UpdateDealer", newList);

		return "Car-Dealer/UpdateDealer_frame";
	}

	// 查詢車商的controller
	@PostMapping("/findDealer.controller")
	public String showDealerAction(@RequestParam("carDealName") String carDealName, Model m) {

		List<CarDealerBean> list = iSpanCarService.findByCarDealerName(carDealName);
		m.addAttribute("selectcarDealName", list);

		return "Car-Dealer/SelectDealer_frame";
	}

	// 查詢全部的車商的Controller
	@PostMapping("/findAllDealer.controller")
	public String showAllDealerAction(Model m) {

		List<CarDealerBean> list = iSpanCarService.findAllDealer();
		m.addAttribute("SelectAllDealer", list);

		return "Car-Dealer/SelectAllDealer_frame";
	}
}
