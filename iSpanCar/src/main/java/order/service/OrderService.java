package order.service;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import order.model.OrderBean;
import order.model.OrderDao;

public class OrderService {


	private OrderDao oDao;
	
	public OrderService() {
		this.oDao=new OrderDao();
	}

	public OrderBean insertOrderBean(OrderBean bean) throws SQLException, ParseException {
		OrderBean obean = oDao.insertOrderBean(bean);
		return obean;
	}
	
	public List<OrderBean> findAllOrder() throws Exception{
		List<OrderBean> allOrder = oDao.findAllOrder();
		return allOrder;
	}
	
	public void updateOrderSatusByOrderId (String Satus,Timestamp newDate,String orderId ) throws SQLException, ParseException {
		oDao.updateOrderSatusByOrderId(Satus,newDate, orderId);
	}
	
}
