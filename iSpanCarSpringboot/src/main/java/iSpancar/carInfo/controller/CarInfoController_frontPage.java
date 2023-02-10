package iSpancar.carInfo.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import iSpancar.carDealer.model.CarDealerBean;
import iSpancar.carDealer.service.ISpanCarService;
import iSpancar.carInfo.model.CarInfoBean;

@Controller
public class CarInfoController_frontPage {

	@Autowired
	private ISpanCarService iSpanCarService;

	//車輛前端車輛首頁
	@GetMapping("/ShowAllCarFrontPage.controller")
	public String showAllCarFrontPageAction(Model m) {

		List<CarInfoBean> list = iSpanCarService.findAllCar();

		//需要在前端做新上架商品，透過日期先後排序上架上品
		Collections.sort(list, new Comparator<CarInfoBean>() {

			@Override
			public int compare(CarInfoBean o1, CarInfoBean o2) {
				// TODO Auto-generated method stub

				try {
					SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

					Date date1 = dateFormat.parse(o1.getAnnounceDate());

					Date date2 = dateFormat.parse(o2.getAnnounceDate());

					return date2.compareTo(date1);

				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;

			}
		});

		int count = 0;
		List<CarInfoBean> latestCars = new ArrayList<>();
		for (CarInfoBean carBean : list) {
			latestCars.add(carBean);
			count++;
			if (count == 4) {
				break;
			}
		}

		// 內容不重複的Set，所以在顯示selection的標籤可以排除重複品牌
		Set<String> carBrand = new HashSet<String>();
		for (CarInfoBean infoBean : list) {
			carBrand.add(infoBean.getCarBrand());
		}

		m.addAttribute("SelectAllCar", list);
		m.addAttribute("carBrand", carBrand);
		m.addAttribute("comparedCar", latestCars);
		return "Car-Infomation/AllCar_frontpage";
	}

	// 透過carNo找車輛的controller(frontpage)，跳轉至carInfo_frontPage的jsp
	@GetMapping("/SelectCarByCarNo.controller/{carNo}")
	public String findCarByCarNoAction(@PathVariable("carNo") int carNo, Model m) {

		List<CarInfoBean> list = iSpanCarService.findByCarNoLike(carNo);
		String sellerName = list.get(0).getCarDealerBean().getCarDealName();
		List<CarDealerBean> sellerList = iSpanCarService.findByCarDealerName(sellerName);
		List<CarInfoBean> randomList = iSpanCarService.findAllCar();
		Random random = new Random();

		List<CarInfoBean> newList = new ArrayList<CarInfoBean>();

		for (int i = 0; i < 4; i++) {
			int number = random.nextInt(randomList.size());
			CarInfoBean randomData = randomList.get(number);

			if (!newList.contains(randomData)) {
				newList.add(randomData);
			} else {
				i--;
			}
		}

		m.addAttribute("SelectRandomCar", newList);
		m.addAttribute("SelectCarByCarNo", list);
		m.addAttribute("SelectCarDealName", sellerList);
		return "Car-Infomation/CarInfo_frontpage";
	}

	// 透過車輛品牌找車子的controller(frontpage)
	@PostMapping("/SelectCarBrand.controller")
	@ResponseBody
	public List<CarInfoBean> selectCarBrandAction(@RequestParam("carBrand") String carBrand, Model m) {

		List<CarInfoBean> list = iSpanCarService.findByCarBrandLike(carBrand);

		return list;
	}
}
