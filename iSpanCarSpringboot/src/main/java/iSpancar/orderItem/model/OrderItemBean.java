package iSpancar.orderItem.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="orderitem")
@Component
public class OrderItemBean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderno")
	private String orderNo;
	
	@Column(name = "orderid")
	private String orderId;
	
	@Column(name = "productnumber")
	private String productNumber  ;
	
	@Column(name = "productname")
	private String productName ;
	
	@Column(name = "quantity")
	private String quantity ;
	
	
//	@Column(name = "productprice")
//	private String productPrice ;
	
	
	public OrderItemBean(String orderId, String productNumber, String quantity) {
		super();
		this.orderId = orderId;
		this.productNumber = productNumber;
//		this.productName = productName;
		this.quantity = quantity;
//		this.productPrice = productPrice;
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

//	public String getProductPrice() {
//		return productPrice;
//	}
//
//	public void setProductPrice(String productPrice) {
//		this.productPrice = productPrice;
//	}

	public OrderItemBean() {
		// TODO Auto-generated constructor stub
	}

}
