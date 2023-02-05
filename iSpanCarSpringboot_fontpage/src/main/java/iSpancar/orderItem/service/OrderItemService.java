package iSpancar.orderItem.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iSpancar.orderItem.model.OrderItemBean;
import iSpancar.orderItem.model.OrderItemDao;
import iSpancar.orderItem.model.OrderItemRepository;
@Service
@Transactional
public class OrderItemService {
	
	@Autowired
	private OrderItemRepository oiRepo;
	
	
	public OrderItemBean insertOrderItemBean(OrderItemBean bean) throws SQLException, ParseException {
		OrderItemBean oibean = oiRepo.save(bean);
		return oibean;
	}
	
	public List<OrderItemBean> findAllOrderItem() throws Exception{
		List<OrderItemBean> allOrderItem = oiRepo.findAll();
		return allOrderItem;
	}
		
}
