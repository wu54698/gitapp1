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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import iSpancar.carDealer.model.CarDealerBean;
import iSpancar.carDealer.service.ISpanCarService;
import iSpancar.carInfo.model.CarInfoBean;

@Controller
public class CarInfoController {

	@Autowired
	private ISpanCarService iSpanCarService;

	// 新增車輛的controller
	@PostMapping(path = "/addCarInfo.controller")
	public String addCarInfoAction(@RequestParam("carDealName") String carDealName,
			@RequestParam("accountNumber") String accountNumber, @RequestParam("carBrand") String carBrand,
			@RequestParam("carName") String carName, @RequestParam("stock") int stock,
			@RequestParam("carImage") MultipartFile mf, @RequestParam("carDescription") String carDescription,
			@RequestParam("announceDate") String announceDate, Model m)
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
		//從CarDealerBean的list取出cardealname
		CarDealerBean firstSeller = null;
		if (carDealerBean.size() == 0) {
			errorMessage.put("carDealName", "該車商名稱尚未登錄");
		}else {
			firstSeller = carDealerBean.get(0);
		}
		// 透過service做新增
		iSpanCarService.addCarInfo(firstSeller, accountNumber, carBrand, carName, stock, imageblob, carDescription,
				announceDate);

		// 錯誤成立則跳轉至原頁面
		if (!errorMessage.isEmpty()) {
			return "/Car-Infomation/CarInfoForm_frame";
		}

		// 新增成功後，跳轉至找全部車輛的jsp頁面
		List<CarInfoBean> newList = iSpanCarService.findAllCar();
		m.addAttribute("SelectAllCar", newList);

		return "Car-Infomation/SelectAllCar_frame";
	}

	// 刪除車輛的Controller
	@PostMapping("/deleteCarInfo")
	public String deleteCarInfoAction(@RequestParam int carNo) {

		iSpanCarService.deleteCarInfo(carNo);
		return "Car-Infomation/SelectAllCar_frame";
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
		
		//取原來的值
		CarInfoBean originInfoBean = new CarInfoBean();
		for(CarInfoBean cib : list) {
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
		
		//從CarDealBean取原來的值的carDealName
		String sellerName = originInfoBean.getCarDealerBean().getCarDealName();
		
		Integer number = (carNo.equals("")) ? 
				originInfoBean.getCarNo() : carNumber;
		String dealer = (carDealName.equals("")) ? 
				sellerName : carDealName;
		String account = (accountNumber.equals("")) ? 
				originInfoBean.getAccountNumber() : accountNumber;
		String brand = (carBrand.equals("")) ? 
				originInfoBean.getCarBrand() : carBrand;
		String carModel = (carName.equals("")) ? 
				originInfoBean.getCarName() : carName;
		Integer inventory = (stock.equals("")) ? 
				originInfoBean.getStock() : Integer.parseInt(stock);
		Blob carPhoto = (bytes.length==0) ? 
				originInfoBean.getCarImage() : productImage;
		String carMemo = (carDescription.equals("")) ? 
				originInfoBean.getCarDescription() : carDescription;
		String publishDate = (announceDate.equals("")) ? 
				originInfoBean.getAnnounceDate() : announceDate;
		
		
		// 讀取瀏覽器送入的欄位內的資料
		// 透過bean找到車商名稱的參數值
		List<CarDealerBean> carDealerBean = iSpanCarService.findByCarDealerName(carDealName);
		
		CarDealerBean sellerBean = carDealerBean.get(0);
		
		CarInfoBean infoBean = new CarInfoBean(number, sellerBean, account, brand, carModel, inventory,
				carPhoto, carMemo, publishDate);
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
	
	// 透過品牌查詢車輛的controller
	@PostMapping("/SelectCarByBrand.controller")
	public String selectCarAction(@RequestParam("carBrand") String carBrand, Model m) {

		List<CarInfoBean> list = iSpanCarService.findByCarBrandLike(carBrand);
		m.addAttribute("Brand", list);

		return "Car-Infomation/SelectCarByBrand_frame";
	}

	// 查詢全部車輛
	@PostMapping("/SelectAllCar.controller")
	public String selectAllCarAction(Model m) {

		List<CarInfoBean> list = iSpanCarService.findAllCar();
		m.addAttribute("SelectAllCar", list);

		return "Car-Infomation/SelectAllCar_frame";
	}

}
