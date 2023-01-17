package iSpancar.order.service;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import iSpancar.order.model.OrderBean;
import iSpancar.order.model.OrderDao;
import iSpancar.order.model.OrderRepository;
@Service
@Transactional
public class OrderService {

	@Autowired
	private OrderRepository oRepo;
	
	

	public void insertOrderBean(OrderBean bean) {
		oRepo.save(bean);

	}
	
	public List<OrderBean> findAllOrder() throws Exception{
		List<OrderBean> allOrder = oRepo.findAll();
		return allOrder;
	}
	
	public void updateOrderSatusByOrderId (String Satus,Timestamp newDate,String orderId )  {
		oRepo.updateOrderSatusByOrderId(Satus,newDate,orderId);
	}
	
}
