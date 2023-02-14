package iSpancar.carInfo.dao;

import java.sql.Blob;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import iSpancar.carInfo.model.CarInfoImageBean;

public interface CarInfoImageRepository extends JpaRepository<CarInfoImageBean, Integer> {
	
	//新增多圖的Repository
	@Modifying
	@Query(value = "insert into carInfoImage values (?1, ?2, ?3)", nativeQuery = true)
	public CarInfoImageBean addMultiImage(int imageNo ,int carNo, Blob carImage);
	
	//查詢車輛底下的多圖的Repository
	@Modifying
	@Query(value = "select * from carInfoImage where carNo =?1", nativeQuery = true)
	public List<CarInfoImageBean> findMultiImageByCarNo(int carNo);
	
	//透過車輛編號刪除多圖Repository
	@Modifying
	@Query(value = "delete from carInfoImage where carNo =?1", nativeQuery = true)
	public void deleteByCarNo(int carNo);
	
}
