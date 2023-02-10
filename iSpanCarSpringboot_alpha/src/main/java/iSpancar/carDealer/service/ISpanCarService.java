package iSpancar.carDealer.service;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.List;
import java.util.Set;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iSpancar.carDealer.dao.CarDealerDao;
import iSpancar.carDealer.dao.CarDealerRepository;
import iSpancar.carDealer.model.CarDealerBean;
import iSpancar.carInfo.dao.CarInfoDao;
import iSpancar.carInfo.dao.CarInfoRepository;
import iSpancar.carInfo.model.CarInfoBean;

@Service
@Transactional
public class ISpanCarService {

//	@Autowired
//	private CarDealerDao dealerDao;
	@Autowired
	private CarDealerRepository dealerRepository;
	
	@Autowired
	private CarInfoRepository carInfoRepository;

//	@Autowired
//	private CarInfoDao infoDao;

	public Blob filetoBlob(InputStream is, long size) throws IOException, SerialException, SQLException {
		byte[] b = new byte[(int) size];
		SerialBlob sb = null;
		is.read(b);
		sb = new SerialBlob(b);
		return sb;

	}

	// 車商的Service
	// 新增車商
	public CarDealerBean addDealer(CarDealerBean dealBean) {

		dealerRepository.save(dealBean);
		System.out.println("車商Service" + dealBean);
		return dealBean;
	}

	// 搜尋全車商
	public List<CarDealerBean> findAllDealer() {

		List<CarDealerBean> dealerBeans = dealerRepository.findAll();
		return dealerBeans;
	}

	// 透過車商名稱刪除車商
	public void deleteCarDealer(String carDealName) {

		dealerRepository.deleteCarDealer(carDealName);
	}

	// 透過車商名稱改其他資訊
	public CarDealerBean updateByCarDealName(CarDealerBean dealBean) {

		CarDealerBean dealerBean = dealerRepository.save(dealBean);
		return dealerBean;
	}

	// 透過車商來搜尋車商資訊
	public List<CarDealerBean> findByCarDealerName(String carDealName) {

		List<CarDealerBean> dealerBeans = dealerRepository.findByCarDealerName(carDealName);
		return dealerBeans;
	}

	// 車輛的Service
	// 新增車輛商品	
	public CarInfoBean addCarInfo(CarInfoBean carBean) {
		
		carInfoRepository.save(carBean);
		return carBean;
	}
	

	// 搜尋全車輛
	public List<CarInfoBean> findAllCar() {

			List<CarInfoBean> carInfoBean = carInfoRepository.findAll();
			return carInfoBean;
		}

	// 透過車輛編號刪除車輛
	public void deleteCarInfo(int carNo) {

		carInfoRepository.deleteCarInfo(carNo);
	}

	// 透過車輛編號修改車輛資訊
	public CarInfoBean updateByCarNo(CarInfoBean infoBean) {

			CarInfoBean carInfoBean = carInfoRepository.save(infoBean);
			return carInfoBean;
	}

	// 透過品牌找車輛
	public List<CarInfoBean> findByCarBrandLike(String carBrand) {

			List<CarInfoBean> carInfoBean = carInfoRepository.findByCarBrandLike(carBrand);
			return carInfoBean;
	}

	// 透過carNo找車輛(圖片用)
	public List<CarInfoBean> findByCarNoLike(int carNo) {

			List<CarInfoBean> carInfoBean = carInfoRepository.findByCarNoLike(carNo);
			return carInfoBean;
	}

}
