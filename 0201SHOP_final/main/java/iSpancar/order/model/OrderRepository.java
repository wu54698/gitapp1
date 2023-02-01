package iSpancar.order.model;


import java.sql.Timestamp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


public interface OrderRepository extends JpaRepository<OrderBean,String>{

	@Modifying
	@Query(value="update Orders set orderstatus = ?1 , newdate = ?2 where orderid = ?3", nativeQuery = true)
	public void updateOrderSatusByOrderId (String orderStatus, Timestamp newDate, String orderId);
}
