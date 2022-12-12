package ispan_order;

public class OrderBean {

	String orderId;
	String orderDate;
	String orderStatus;
	String newDate;
	String paidSate;
	String paidMethod;
	String deliveryAddress;
	String orderName;
	String orderPhone;
	String totalPrice;
	String memberId;



	public String getNewDate() {
		return newDate;
	}

	public void setNewDate(String newDate) {
		this.newDate = newDate;
	}
	public String getmemberId() {
		return memberId;
	}

	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}

	public OrderBean(String orderId, String orderDate, String newDate ,String orderStatus, String paidSate, String paidMethod,
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
		this.memberId=memberId;

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
		this.memberId=memberId;

	}

	public String getorderId() {
		return orderId;
	}

	public void setorderId(String orderId) {
		this.orderId = orderId;
	}

	public String getorderDate() {
		return orderDate;
	}

	public void setorderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getorderStatus() {
		return orderStatus;
	}

	public void setorderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}

	public String getpaidSate() {
		return paidSate;
	}

	public void setpaidSate(String paidSate) {
		this.paidSate = paidSate;
	}

	public String getpaidMethod() {
		return paidMethod;
	}

	public void setpaidMethod(String paidMethod) {
		this.paidMethod = paidMethod;
	}

	public String getdeliveryAddress() {
		return deliveryAddress;
	}

	public void setdeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getorderName() {
		return orderName;
	}

	public void setorderName(String orderName) {
		this.orderName = orderName;
	}

	public String getorderPhone() {
		return orderPhone;
	}

	public void setorderPhone(String orderPhone) {
		this.orderPhone = orderPhone;
	}

	public String gettotalPrice() {
		return totalPrice;
	}

	public void settotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}

	public OrderBean() {

	}

}
