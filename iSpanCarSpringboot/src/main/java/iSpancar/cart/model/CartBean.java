package iSpancar.cart.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name="cart")
@Component
public class CartBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cartid")
	private String cartId;
	
	@Column(name = "memberid")
	private String memberId;
	
	@Column(name = "productnumber")
	private String productNumber ;
	
	@Column(name = "productname")
	private String productName ;
	
	@Column(name = "productprice")
	private String productPrice ;
	
	@Column(name = "quantity")
	private String quantity;
	
	
	public CartBean() {
		// TODO Auto-generated constructor stub
	}
	
	public CartBean( String memberId, String productNumber,String productName, String productPrice ,String quantity) {
		super();
		this.memberId = memberId;
		this.productNumber = productNumber;
		this.productName=productName;
		this.productPrice=productPrice;
		this.quantity = quantity;
	}

	public CartBean( String cartId,String memberId, String productNumber,String productName,String productPrice,
			String quantity
			) {
		super();
		this.cartId = cartId;
		this.memberId = memberId;
		this.productNumber = productNumber;
		this.productName=productName;
		this.productPrice=productPrice;
		this.quantity = quantity;
	}
	
	public CartBean(  String productNumber,String productName, String productPrice ,String quantity) {
		super();
		this.productNumber = productNumber;
		this.productName=productName;
		this.productPrice=productPrice;
		this.quantity = quantity;
	}
	
	public String getCartId() {
		return cartId;
	}


	public void setCartId(String cartId) {
		this.cartId = cartId;
	}


	public String getMemberId() {
		return memberId;
	}


	public void setMemberId(String memberId) {
		this.memberId = memberId;
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


	public String getProductPrice() {
		return productPrice;
	}


	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
