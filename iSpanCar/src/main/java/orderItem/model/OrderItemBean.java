package orderItem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name="orderItem")
public class OrderItemBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderNo")
	private String orderNo;
	
	@Column(name = "orderId")
	private String orderId;
	
	@Column(name = "productNumber")
	private String productNumber  ;
	
	@Column(name = "productName")
	private String productName ;
	
	@Column(name = "quantity")
	private String quantity ;
	
	@Column(name = "productPrice")
	private String productPrice ;
	
	
	public OrderItemBean(String orderId, String productNumber,String productName, String quantity, String productPrice) {
		super();
		this.orderId = orderId;
		this.productNumber = productNumber;
		this.productName = productName;
		this.quantity = quantity;
		this.productPrice = productPrice;
	}
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	public String getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public OrderItemBean() {
		// TODO Auto-generated constructor stub
	}

}
