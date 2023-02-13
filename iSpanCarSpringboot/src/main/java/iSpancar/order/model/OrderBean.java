package iSpancar.order.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="orders")
@Component
public class OrderBean {
	@Id
	@Column(name = "orderid")
	private String orderId;
	
	@Column(name = "orderdate")
	private Timestamp orderDate;
	
	@Column(name = "newdate")
	private Timestamp newDate;
	
	@Column(name = "orderstatus")
	private String orderStatus;
	
	@Column(name = "paidsate")
	private String paidSate;
	
	@Column(name = "paidmethod")
	private String paidMethod;
	
	@Column(name = "deliveryaddress")
	private String deliveryAddress;
	
	@Column(name = "ordername")
	private String orderName;
	
	@Column(name = "orderphone")
	private String orderPhone;
	
	@Column(name = "totalprice")
	private String totalPrice;
	
	
//	private String memberId;
	
	public OrderBean(String orderId, Timestamp orderDate, Timestamp newDate ,String orderStatus, String paidSate, String paidMethod,
			String deliveryAddress, String orderName, String orderPhone, String totalPrice  ) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.newDate=newDate;
		this.orderStatus = orderStatus;
		this.paidSate = paidSate;
		this.paidMethod = paidMethod;
		this.deliveryAddress = deliveryAddress;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.totalPrice = totalPrice;
	}
	
	
	
	public OrderBean(String orderId, String orderStatus, String paidSate, String paidMethod,
			String deliveryAddress, String orderName, String orderPhone, String totalPrice ,String memberId) {
		super();
		this.orderId = orderId;
		this.orderStatus = orderStatus;
		this.paidSate = paidSate;
		this.paidMethod = paidMethod;
		this.deliveryAddress = deliveryAddress;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.totalPrice = totalPrice;
//		this.memberId=memberId;

	}
	
	public OrderBean( String orderStatus, String paidSate, String paidMethod,
			String deliveryAddress, String orderName, String orderPhone, String totalPrice ,String memberId) {
		super();
		this.orderStatus = orderStatus;
		this.paidSate = paidSate;
		this.paidMethod = paidMethod;
		this.deliveryAddress = deliveryAddress;
		this.orderName = orderName;
		this.orderPhone = orderPhone;
		this.totalPrice = totalPrice;
//		this.memberId=memberId;

	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}



	public Timestamp getOrderDate() {
		return orderDate;
	}



	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}



	public Timestamp getNewDate() {
		return newDate;
	}

	public void setNewDate(Timestamp newDate) {
		this.newDate = newDate;
	}

	public String getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getPaidSate() {
		return paidSate;
	}

	public void setPaidSate(String paidSate) {
		this.paidSate = paidSate;
	}

	public String getPaidMethod() {
		return paidMethod;
	}

	public void setPaidMethod(String paidMethod) {
		this.paidMethod = paidMethod;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderPhone() {
		return orderPhone;
	}

	public void setOrderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

//	public String getMemberId() {
//		return memberId;
//	}
//
//	public void setMemberId(String memberId) {
//		this.memberId = memberId;
//	}

	public OrderBean() {
		
	}



	public OrderBean(String orderId, Timestamp orderDate, String orderStatus, String paidSate, String paidMethod,
			String deliveryAddress, String orderName, String orderPhone, String totalPrice) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.orderStatus = orderStatus;
		this.paidSate = paidSate;
		this.paidMethod = paidMethod;
		this.deliveryAddress = deliveryAddress;
		this.orderName = orderName;
		this.orderPhone=orderPhone;
		this.totalPrice=totalPrice;
		
	}
}
