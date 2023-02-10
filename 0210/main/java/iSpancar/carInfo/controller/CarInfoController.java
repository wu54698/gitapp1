package iSpancar.carInfo.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import iSpancar.carDealer.model.CarDealerBean;
import iSpancar.carDealer.service.ISpanCarService;
import iSpancar.carInfo.model.CarInfoBean;

@Controller
@RequestMapping("/backstage")
public class CarInfoController {

	@Autowired
	private ISpanCarService iSpanCarService;

	// 新增車輛的controller
	@PostMapping(path = "/addCarInfo.controller")
	@ResponseBody
	public String addCarInfoAction(@RequestParam("carDealName") String carDealName,
			@RequestParam("accountNumber") String accountNumber, @RequestParam("carBrand") String carBrand,
			@RequestParam("carName") String carName, @RequestParam("stock") int stock,
			@RequestParam("carImage") MultipartFile mf, @RequestParam("carDescription") String carDescription,
			@RequestParam("announceDate") String announceDate, Model m, RedirectAttributes attr)
			throws IOException, SerialException, SQLException {

		// 定義存放錯誤訊息的 Collection物件
		Map<String, String> errorMessage = new HashMap<>();
		m.addAttribute("ErrorMsg", errorMessage);

		// 先搞圖片
		String imageName = mf.getOriginalFilename();
		byte[] bytes = mf.getBytes();

		Blob imageblob = null;
		if (bytes.length == 0) {

		} else {
			imageblob = new SerialBlob(bytes);
		}

		// 讀取瀏覽器送入的欄位內的資料
		// 透過bean找到車商名稱的參數值
		List<CarDealerBean> carDealerBean = iSpanCarService.findByCarDealerName(carDealName);

		// 確認車商是否有登錄
		// 從CarDealerBean的list取出cardealname
		CarDealerBean sellerBean = null;
		String firstSeller = null;
		if (carDealerBean.size() == 0) {
			errorMessage.put("carDealName", "該車商名稱尚未登錄");
		} else {
			sellerBean = carDealerBean.get(0);
			firstSeller = sellerBean.getCarDealName();
		}

		// new一個bean，透過bean set車輛資訊進去
		CarInfoBean carInfoBean = new CarInfoBean();
		carInfoBean.setCarDealerBean(sellerBean);
		carInfoBean.setAccountNumber(accountNumber);
		carInfoBean.setCarBrand(carBrand);
		carInfoBean.setCarName(carName);
		carInfoBean.setStock(stock);
		carInfoBean.setCarImage(imageblob);
		carInfoBean.setCarDescription(carDescription);
		carInfoBean.setAnnounceDate(announceDate);

		// 錯誤成立則跳轉至原頁面
		if (!errorMessage.isEmpty()) {
			return "/Car-Infomation/CarInfoForm_frame";
		} else {

			// 透過service新增車輛資訊進資料庫
			iSpanCarService.addCarInfo(carInfoBean);

			// 新增成功後，跳轉至找全部車輛的jsp頁面
			List<CarInfoBean> newList = iSpanCarService.findAllCar();
			attr.addFlashAttribute("SelectAllCar", newList);
//			rm.addAttribute("SelectAllCar", newList);
			//跳轉至
			return "OK";
//			return "Car-Infomation/SelectAllCar_frame";
		}

	}

	// 刪除車輛的Controller
	@PostMapping("/deleteCarInfo")
	@ResponseBody
	public String deleteCarInfoAction(@RequestParam("carNo") int carNo) {

		iSpanCarService.deleteCarInfo(carNo);
		return "OK:OK";
	}

	// 修改車輛的controller
	@PostMapping("/updateCarInfo.controller")
	public String updateCarInfoAction(@RequestParam("carNo") String carNo,
			@RequestParam("carDealName") String carDealName, @RequestParam("accountNumber") String accountNumber,
			@RequestParam("carBrand") String carBrand, @RequestParam("carName") String carName,
			@RequestParam("stock") String stock, @RequestParam("carImage") MultipartFile mf,
			@RequestParam("carDescription") String carDescription, @RequestParam("announceDate") String announceDate,
			Model m) throws IOException, SerialException, SQLException {

		int carNumber = Integer.parseInt(carNo);

		int amount = Integer.parseInt(stock);

		String image = mf.getOriginalFilename();
		byte[] bytes = mf.getBytes();
		Blob productImage = new SerialBlob(bytes);

		List<CarInfoBean> list = iSpanCarService.findByCarNoLike(carNumber);

		// 取原來的值
		CarInfoBean originInfoBean = new CarInfoBean();
		for (CarInfoBean cib : list) {
			originInfoBean.setCarNo(cib.getCarNo());
			originInfoBean.setCarDealerBean(cib.getCarDealerBean());
			originInfoBean.setAccountNumber(cib.getAccountNumber());
			originInfoBean.setCarBrand(cib.getCarBrand());
			originInfoBean.setCarName(cib.getCarName());
			originInfoBean.setStock(cib.getStock());
			originInfoBean.setCarImage(cib.getCarImage());
			originInfoBean.setCarDescription(cib.getCarDescription());
			originInfoBean.setAnnounceDate(cib.getAnnounceDate());
		}

		// 從CarDealBean取原來的值的carDealName
		String sellerName = originInfoBean.getCarDealerBean().getCarDealName();

		Integer number = (carNo.equals("")) ? originInfoBean.getCarNo() : carNumber;
		String dealer = (carDealName.equals("")) ? sellerName : carDealName;
		String account = (accountNumber.equals("")) ? originInfoBean.getAccountNumber() : accountNumber;
		String brand = (carBrand.equals("")) ? originInfoBean.getCarBrand() : carBrand;
		String carModel = (carName.equals("")) ? originInfoBean.getCarName() : carName;
		Integer inventory = (stock.equals("")) ? originInfoBean.getStock() : Integer.parseInt(stock);
		Blob carPhoto = (bytes.length == 0) ? originInfoBean.getCarImage() : productImage;
		String carMemo = (carDescription.equals("")) ? originInfoBean.getCarDescription() : carDescription;
		String publishDate = (announceDate.equals("")) ? originInfoBean.getAnnounceDate() : announceDate;

		// 讀取瀏覽器送入的欄位內的資料
		// 透過bean找到車商名稱的參數值
		List<CarDealerBean> carDealerBean = iSpanCarService.findByCarDealerName(carDealName);
		
		CarDealerBean sellerBean = carDealerBean.get(0);
		
		//將三元判斷的結果與取出的車商名稱放進bean中
		CarInfoBean infoBean = new CarInfoBean(number, sellerBean, account, brand, carModel, inventory, carPhoto,
				carMemo, publishDate);
		
		//透過service寫進資料庫
		iSpanCarService.updateByCarNo(infoBean);
		ArrayList<CarInfoBean> updateList = new ArrayList<CarInfoBean>();
		updateList.add(infoBean);
		m.addAttribute("UpdateCarInfo", updateList);

		return "Car-Infomation/UpdateCarInfo_frame";
	}

	//透過Id接值進入修改頁面的controller(原selectIdToUpdate)
	@PostMapping("/JumptoUpdateCarInfoSheet")
	public String selectIdToUpdateAction(@RequestParam("carNo") String carNo, Model m) {

		int carNumber = Integer.parseInt(carNo);
		List<CarInfoBean> list = iSpanCarService.findByCarNoLike(carNumber);
		m.addAttribute("toUpdate", list);

		return "Car-Infomation/JumpToUpdateCarInfoSheet_frame";
	}

	//透過品牌查詢車輛的controller
	@PostMapping("/SelectCarByBrand.controller")
	public String selectCarAction(@RequestParam("carBrand") String carBrand, Model m) {

		List<CarInfoBean> list = iSpanCarService.findByCarBrandLike(carBrand);
		m.addAttribute("Brand", list);

		return "Car-Infomation/SelectCarByBrand_frame";
	}
	
	//查詢車商底下全部車輛
	@GetMapping("/SelectCarInOneSeller.controller/{carDealerName}")
	public String selectCarDealerNameAction(@PathVariable("carDealerName") String carDealerName, Model m) {
		
		List<CarDealerBean> sellerList = iSpanCarService.findByCarDealerName(carDealerName);
		
		List<CarInfoBean> list = iSpanCarService.findByCarDealerNameLike(carDealerName);
		
		m.addAttribute("SelectCarDealName", sellerList);
		m.addAttribute("SelectAllCar", list);
		
		return "Car-Dealer/SelectCarInOneSeller_frame";
		
	}
	

	//查詢全部車輛
	@GetMapping("/SelectAllCar.controller")
	public String selectAllCarAction(Model m) {

		List<CarInfoBean> list = iSpanCarService.findAllCar();
		m.addAttribute("SelectAllCar", list);

		return "Car-Infomation/SelectAllCar_frame";
	}
	
	//透過車商名稱新增車輛，車輛表格含已代入「車商名稱」
	@GetMapping("/SelectDealerNameToAdd.controller")
	public String selectCarDealerToAddCarAction(@RequestParam("carDealName") String carDealName, Model m) {
		
		List<CarDealerBean> list = iSpanCarService.findByCarDealerName(carDealName);
		m.addAttribute("addCar", list);
		return "Car-Infomation/CarInfoForm_frame";
	}

}
