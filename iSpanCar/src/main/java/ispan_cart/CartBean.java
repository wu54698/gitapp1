package ispan_cart;

// 本類別存放訂單資料
public class CartBean {
	//1201
	String	cartId;
	String 	memberId;
	String	productNumber; 
	String	productName;
	String  productPrice ;
	String	quantity;
	
	public CartBean() {
		
	}


	public CartBean( String memberId, String productNumber,String productName, String productPrice ,String quantity) {
		super();
//		this.cartId = cartId;
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
//		this.cartId = cartId;
//		this.memberId = memberId;
		this.productNumber = productNumber;
		this.productName=productName;
		this.productPrice=productPrice;
		this.quantity = quantity;
	}
	public String getcartId() {
		return cartId;
	}

	public void setcartId(String cartId) {
		this.cartId = cartId;
	}
	public String getProductPrice() {
		return productPrice;
	}
	
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	public String getmemberId() {
		return memberId;
	}

	public void setmemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getproductNumber() {
		return productNumber;
	}

	public void setproductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getproductName() {
		return productName;
	}

	public void setproductName(String productName) {
		this.productName = productName;
	}

	public String getquantity() {
		return quantity;
	}

	public void setquantity(String quantity) {
		this.quantity = quantity;
	}

}