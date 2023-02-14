package iSpancar.order.model;


import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import iSpancar.cart.model.CartBean;


public interface OrderRepository extends JpaRepository<OrderBean,String>{

	@Modifying
	@Query(value="update Orders set orderstatus = ?1 , newdate = ?2 where orderid = ?3", nativeQuery = true)
	public void updateOrderSatusByOrderId (String orderStatus, Timestamp newDate, String orderId);

	@Modifying
	@Query(value="update Orders set paidSate = ?1  where orderid = ?2", nativeQuery = true)
	public void updateOrderpaidSateByOrderId (String paidSate, String orderId);
	
	@Query(value="select * from orders where accountnumber= ?1 order by orderDate desc" , nativeQuery = true)
	public List<OrderBean> findByMemberId(String memberId);
	
	@Query(value="select * from orders where orderId= ?1 " , nativeQuery = true)
	public List<OrderBean> findOrderByOrderId(String orderId);
	
	@Query(value="select * from orders " , nativeQuery = true)
	public List<OrderBean> findAllorder();
	
	

	@Query(value="select * from orders where CONVERT(date, orderDate) like ?1% order by orderDate desc" , nativeQuery = true)
	public List<OrderBean> findByOrderDate(String Dates);
}
