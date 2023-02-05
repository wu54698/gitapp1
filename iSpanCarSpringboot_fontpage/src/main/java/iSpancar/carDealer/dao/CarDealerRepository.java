package iSpancar.carDealer.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import iSpancar.carDealer.model.CarDealerBean;

public interface CarDealerRepository extends JpaRepository<CarDealerBean, String> {
	
	//修改刪除須加上此註釋
	@Modifying
	@Query(value = "delete from cardealerinfo where cardealername =?1", nativeQuery = true)
	public void deleteCarDealer(String carDealName);
	
	
	//搜尋carDealerName
	@Query(value = "select * from cardealerinfo where cardealername =?1", nativeQuery = true)
	public List<CarDealerBean> findByCarDealerName(String carDealName);
	
}
