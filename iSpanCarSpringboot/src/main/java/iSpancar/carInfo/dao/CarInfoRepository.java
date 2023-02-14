package iSpancar.carInfo.dao;

import java.sql.Blob;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import iSpancar.carDealer.model.CarDealerBean;
import iSpancar.carInfo.model.CarInfoBean;

public interface CarInfoRepository extends JpaRepository<CarInfoBean, Integer> {
	
	
	//新增的車輛的dao
	@Modifying
	@Query(value = "insert into carinfo values (?1, ?2, ?3, ?4, ?5, ?6, ?7, ?8)", nativeQuery = true)
	public CarInfoBean addCarInfo(String sellerName, String accountNumber, String carBrand, String carName,
			int stock, Blob carImage, String carDescription, String announceDate);
	
	//用品牌查詢的車輛dao
	@Modifying
	@Query(value = "select * from carinfo where carbrand =?1", nativeQuery = true)
	public List<CarInfoBean> findByCarBrandLike(String carBrand);
	
	
	//查詢車商底下所有車輛
	@Modifying
	@Query(value = "select * from carinfo where cardealname =?1", nativeQuery = true)
	public List<CarInfoBean> findByCarDealerNameLike(String cardealname);
	
	// 透過carNo找車輛(圖片用)dao
	@Modifying
	@Query(value = "select * from carinfo where carno =?1", nativeQuery = true)
	public List<CarInfoBean> findByCarNoLike(int carNo);
	
	//分頁選項的Repository
//	public Page<CarInfoBean> findAll(Pageable pageable);
	
}