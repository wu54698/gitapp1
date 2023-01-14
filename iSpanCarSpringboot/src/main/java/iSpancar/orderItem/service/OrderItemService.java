package iSpancar.orderItem.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iSpancar.orderItem.model.OrderItemBean;
import iSpancar.orderItem.model.OrderItemDao;
@Service
@Transactional
public class OrderItemService {
	
	@Autowired
private OrderItemDao oiDao;
	
	public OrderItemService() {
		this.oiDao=new OrderItemDao();
	}

	public OrderItemBean insertOrderItemBean(OrderItemBean bean) throws SQLException, ParseException {
		OrderItemBean oibean = oiDao.insertOrderItemBean(bean);
		return oibean;
	}
	
	public List<OrderItemBean> findAllOrderItem() throws Exception{
		List<OrderItemBean> allOrderItem = oiDao.findAllOrderItem();
		return allOrderItem;
	}
	
}
