package orderItem.service;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import orderItem.model.OrderItemBean;
import orderItem.model.OrderItemDao;

public class OrderItemService {
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
