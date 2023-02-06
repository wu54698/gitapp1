package iSpancar.shop.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ShopDetailRepository extends JpaRepository<ShopDetailBean, Integer> {

	@Query(value = "select * from SHOPDETAIL", nativeQuery = true)
	public List<ShopDetailBean> findAll();
	
	@Query(value="select * from SHOPDETAIL where productno= ?1" , nativeQuery = true)
	 public List<ShopDetailBean> findByProductno(Integer productno);
	
	@Query(value = "select * from SHOPDETAIL where productname like %?1%", nativeQuery = true)
	public List<ShopDetailBean> findbyProductname(String productname);
	
	@Query(value = "select * from SHOPDETAIL where type= ?1", nativeQuery = true)
	public List<ShopDetailBean>findbyType(String type);
	
	@Query(value = "select count * from SHOPDETAIL where type = ?1", nativeQuery = true)
	public Long countByColumn(String type);
	
}
