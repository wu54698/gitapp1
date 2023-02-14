package iSpancar.orderItem.model;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import iSpancar.order.model.OrderBean;



public interface OrderItemRepository extends JpaRepository<OrderItemBean,String>{
	

	@Query(value="select * from orderitem where orderId= ?1  " , nativeQuery = true)
	public List<OrderItemBean> findOrderItemByOrderId(String orderId);
}
