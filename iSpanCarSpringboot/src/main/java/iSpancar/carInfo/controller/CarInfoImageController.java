package iSpancar.carInfo.controller;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import iSpancar.carDealer.service.ISpanCarService;
import iSpancar.carInfo.model.CarInfoBean;
import iSpancar.carInfo.model.CarInfoImageBean;

//處理圖片之controller，上為單張主圖，下為多張次要圖
@Controller
public class CarInfoImageController {

	@Autowired
	private ISpanCarService iSpanCarService;

	@GetMapping("/carInfoImage.controller/{carNo}")
	@ResponseBody
	public byte[] processProductImageAction(@PathVariable("carNo") String carNo) {
		
		int carNumber = Integer.parseInt(carNo);
		List<CarInfoBean> list = iSpanCarService.findByCarNoLike(carNumber);

		for (CarInfoBean infoBean : list) {
			
			try {
				InputStream is;
				is = infoBean.getCarImage().getBinaryStream();
				return IOUtils.toByteArray(is);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}
	
	@GetMapping("/multiCarImages.controller/{imageNo}")
	@ResponseBody
	public byte[] showMultiCarImageAction(@PathVariable("imageNo") String imageNo) {
		
		//imageNo為圖片主鍵，所以透過主鍵找出對應之carNo下的多圖，一張一張顯示出來
		int imageNumber = Integer.parseInt(imageNo);
		CarInfoImageBean singleImageBean = iSpanCarService.findsingleImageByImageNo(imageNumber);

			System.out.println(singleImageBean.getImageNo());
			try {
				InputStream is;
				is = singleImageBean.getCarImage().getBinaryStream();
				return IOUtils.toByteArray(is);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		return null;
	}
	
}
