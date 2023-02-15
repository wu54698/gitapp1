package iSpancar.orderservice;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional

public class OrderServiceService {
	@Autowired
	private OrderServiceRepository oRepo;

	public OrderServiceBean insert(OrderServiceBean oBean) {
		return oRepo.save(oBean);
	}
	public OrderServiceBean update(OrderServiceBean oBean) {
		return oRepo.save(oBean);
	}
	public OrderServiceBean deleteById(OrderServiceBean oBean) {
		 oRepo.delete(oBean);
		return oBean;
	}
	
	public OrderServiceBean findbyId(String ordername) {
		Optional<OrderServiceBean>op =oRepo.findById(ordername);
		OrderServiceBean ob = null;
		
		if(op.isPresent()) {
			ob = op.get();
		}
		return ob;
	}
	public List<OrderServiceBean> findAllOrder() throws SQLException {
		List<OrderServiceBean> list = oRepo.findAll();
		return list;
	}
	public OrderServiceBean updateByordername(OrderServiceBean bean) {
		OrderServiceBean oBean = oRepo.save(bean);
		return oBean;
	}
}