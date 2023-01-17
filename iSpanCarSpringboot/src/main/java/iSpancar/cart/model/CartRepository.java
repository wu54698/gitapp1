package iSpancar.cart.model;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface CartRepository extends JpaRepository<CartBean,String>{

	@Query(value="select * from cart where memberid= ?1" , nativeQuery = true)
	public List<CartBean> findAllById(String memberId);
	
	@Modifying
	@Query(value="delete from cart where memberid= ?1" , nativeQuery = true)
	public void deleteByMemberId(String memberId);
	
	@Modifying
	@Query(value="update cart  set quantity = ?1 where cartid = ?2",nativeQuery = true)
	public void updateQuantityByCartId(String quantity, String cartId);
	
}
