package iSpancar.carInfo.controller;

import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
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
import iSpancar.carInfo.model.CarInfoBean;
import iSpancar.tw.hibernatedemo.service.ISpanCarService;

@Controller
public class CarInfoController {

	@Autowired
	private ISpanCarService iSpanCarService;

	// 新增車輛的controller
	@PostMapping(path = "/addCarInfo")
	public String addCarInfoAction(@RequestParam("carDealName") CarDealerBean carDealBean,
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
		CarInfoBean infoBean = new CarInfoBean();

		String sellerName = infoBean.getCarDealerBean().getCarDealName();

		List<CarDealerBean> carDealerBean = iSpanCarService.findByCarDealerName(sellerName);

//		CarInfoBean carInfoBean = new CarInfoBean(carDealBean, accountNumber, carBrand, carName, stock, imageblob, carDescription, announceDate);
		// 透過service做新增
		iSpanCarService.addCarInfo(carDealBean, accountNumber, carBrand, carName, stock, imageblob, carDescription,
				announceDate);

		// 確認車商是否有登錄
//		CarDealerBean firstSeller = null;
		if (carDealerBean.size() == 0) {
			errorMessage.put("carDealName", "該車商名稱尚未登錄");
		}
//		else {
//			firstSeller = carDealerBean.get(0);
//		}

		// 錯誤成立則跳轉至原頁面
		if (!errorMessage.isEmpty()) {
			return "/Car-Infomation/CarInfoForm_frame";
		}

		// 新增成功後，跳轉至找全部車輛的jsp頁面
		List<CarInfoBean> newList = iSpanCarService.findAllCar();
		m.addAttribute("SelectAllCar", newList);

		return "Car-Infomation/SelectAllCar_frame";

//		CarInfoBean infoBean = new CarInfoBean();

//		infoBean.setCarDealerBean(firstSeller);

//		infoBean.setCarDealerBean(carDealName);
//		String sellerName = carDealerBean.getCarDealName();
//		infoBean.setAccountNumber(accountNumber);
//		infoBean.setCarBrand(carBrand);
//		infoBean.setCarName(carName);
//		infoBean.setStock(stock);
//		infoBean.setCarImage(carImage);
//		infoBean.setCarDescription(carDescription);
//		infoBean.setAnnounceDate(announceDate);

//		iSpanCarService.addCarInfo(firstSeller, accountNumber, carBrand, carName, stock, carImage, carDescription,
//				announceDate);

//		return "Car-Infomation/SelectAllCar_frame";
	}

	// 刪除車輛的Controller
	@PostMapping("/deleteCarInfo")
	public String deleteCarInfoAction(@RequestParam int carNo) {

		iSpanCarService.deleteCarInfo(carNo);
		return "Car-Infomation/SelectAllCar_frame";
	}

	// 修改車輛的controller
	@PostMapping("/updateCarInfo")
	public String updateCarInfoAction(@RequestParam("carNo") String carNo,
			@RequestParam("carDealName") CarDealerBean carDealBean, @RequestParam("accountNumber") String accountNumber,
			@RequestParam("carBrand") String carBrand, @RequestParam("carName") String carName,
			@RequestParam("stock") String stock, @RequestParam("carImage") MultipartFile mf,
			@RequestParam("carDescription") String carDescription, @RequestParam("announceDate") String announceDate,
			Model m) throws IOException, SerialException, SQLException {

		int carNumber = Integer.parseInt(carNo);

		int amount = Integer.parseInt(stock);

		String image = mf.getOriginalFilename();
		byte[] bytes = mf.getBytes();
		SerialBlob productImage = new SerialBlob(bytes);

		CarInfoBean infoBean = new CarInfoBean(carNumber, carDealBean, accountNumber, carBrand, carName, amount,
				productImage, carDescription, announceDate);
		iSpanCarService.updateByCarNo(infoBean);

		return "Car-Infomation/UpdateCarInfo_frame";
	}

	// 透過品牌查詢車輛的controller
	@PostMapping("/SelectCarByBrand")
	public String selectCarAction(@RequestParam("carBrand") String carBrand, Model m) {

		List<CarInfoBean> list = iSpanCarService.findByCarBrandLike(carBrand);
		m.addAttribute("Brand", list);

		return "Car-Infomation/SelectCarByBrand_frame";
	}

	// 查詢全部車輛
	@PostMapping("/SelectAllCar")
	public String selectAllCarAction(Model m) {

		List<CarInfoBean> list = iSpanCarService.findAllCar();
		m.addAttribute("SelectAllCar", list);

		return "Car-Infomation/SelectAllCar_frame";
	}

}
