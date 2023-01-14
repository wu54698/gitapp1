package iSpancar.order.service;


import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.util.List;

import javax.transaction.TransactionScoped;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import iSpancar.order.model.OrderBean;
import iSpancar.order.model.OrderDao;
@Service
@TransactionScoped
public class OrderService {

	@Autowired
	private OrderDao oDao;
	
	public OrderService() {
		this.oDao=new OrderDao();
	}

	public void insertOrderBean(OrderBean bean) {
		 oDao.insertOrderBean(bean);

	}
	
	public List<OrderBean> findAllOrder() throws Exception{
		List<OrderBean> allOrder = oDao.findAllOrder();
		return allOrder;
	}
	
	public void updateOrderSatusByOrderId (String Satus,Timestamp newDate,String orderId ) throws SQLException, ParseException {
		oDao.updateOrderSatusByOrderId(Satus,newDate, orderId);
	}
	
}
