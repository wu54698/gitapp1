package ispan_order;

public class OrderItemBean {
	String orderId;
	String productNumber  ;
	String productName  ;
	String quantity ;
	String productPrice ;
	
	public OrderItemBean(String orderId, String productNumber,String productName, String quantity, String productPrice) {
		super();
		this.orderId = orderId;
		this.productNumber = productNumber;
		this.productName = productName;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}
	

	public String getproductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getorderId() {
		return orderId;
	}
	public void setorderId(String orderId) {
		this.orderId = orderId;
	}
	public String getproductNumber() {
		return productNumber;
	}
	public void setproductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	public String getquantity() {
		return quantity;
	}
	public void setquantity(String quantity) {
		this.quantity = quantity;
	}
	public String getproductPrice() {
		return productPrice;
	}
	public void setproductPrice(String productPrice) {
		this.productPrice = productPrice;
	}
	
	
	
}