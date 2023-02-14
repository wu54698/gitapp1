package iSpancar.shop.model;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface ShopDetailRepository extends JpaRepository<ShopDetailBean, Integer> {

	public List<ShopDetailBean> findAll();

    public Page<ShopDetailBean> findAll(Pageable pageable);

	@Query(value = "select * from SHOPDETAIL ORDER BY price ASC", nativeQuery = true)
	public List<ShopDetailBean> findAllOrderByLowPrice();
	
	@Query(value = "select * from SHOPDETAIL ORDER BY price DESC", nativeQuery = true)
	public List<ShopDetailBean> findAllOrderByHightPrice();
	
	@Query(value = "select * from SHOPDETAIL", nativeQuery = true)
	public List<ShopDetailBean> findAllnoImg();
	
	@Query(value="select * from SHOPDETAIL where productno= ?1" , nativeQuery = true)
	 public List<ShopDetailBean> findByProductno(Integer productno);
	
	@Query(value = "select * from SHOPDETAIL where productname like %?1%", nativeQuery = true)
	public List<ShopDetailBean> findbyProductname(String productname);
	
	@Query(value = "select * from SHOPDETAIL where type= ?1", nativeQuery = true)
	public List<ShopDetailBean>findbyType(String type);
	
	@Query(value = "select count * from SHOPDETAIL where type = ?1", nativeQuery = true)
	public Long countByColumn(String type);
	
	@Modifying
	@Query(value="update SHOPDETAIL  set stock = ?1 where productno = ?2",nativeQuery = true)
	public void updatestockByproductno(Integer stock, String productno);
	
}
