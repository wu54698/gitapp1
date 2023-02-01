package iSpancar.shop.model;

import java.sql.Blob;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ShopDetailRepository extends JpaRepository<ShopDetailBean, Integer> {

	@Query(value = "select * from SHOPDETAIL", nativeQuery = true)
	public List<ShopDetailBean> findAll();
	
	
	@Query(value="select * from SHOPDETAIL where productno= ?1" , nativeQuery = true)
	 public List<ShopDetailBean> findByProductno(Integer productno);
	
	@Query(value = "select * from SHOPDETAIL where productname like %?1%",nativeQuery = true)
	public List<ShopDetailBean> findbyProductname(String productname);
	
	
//	@Modifying
//	@Query(value="delete from ShopDetailBean where productno = ?1" , nativeQuery = true)
//	 public void delete (Integer productno);
	
//	@Modifying
//	 @Query(value="update ShopDetailBean s set s.productname= ?1 and s.price= ?2 and s.stock= ?3 and s.productinfo = ?4 and s.productimage =?5 and s.Productimage_name =?6 where s.productno = ?7", nativeQuery = true)
//	 public void updateProduct(String productname, Integer price,Integer stock,Integer productinfo,Blob productimage,String Productimage_name);
	
}
