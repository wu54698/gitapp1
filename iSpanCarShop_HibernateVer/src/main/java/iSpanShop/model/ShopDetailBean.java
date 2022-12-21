package iSpanShop.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SHOP_DETAIL")
public class ShopDetailBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "productno")
	private Integer productno;
	
	@Column(name = "productname")
	private String productname;
	
	@Column(name = "type")
	private String type;
	
	@Column(name = "spec")
	private String spec;
	
	@Column(name = "price")
	private Integer price;
	
	@Column(name = "stock")
	private Integer stock;
	
	@Column(name = "uptime")
	private String uptime;
	
	@Column(name = "productinfo")
	private String productinfo;
	
	@Column(name = "productimage")
	private Blob productimage;
	
	@Column(name = "productimage_name")
	private String productimage_name;

	
	public ShopDetailBean(String productname, String type, String spec, Integer price, Integer stock, String uptime,
			String productinfo, Blob productimage, String productimage_name) {
		super();
		this.productname = productname;
		this.type = type;
		this.spec = spec;
		this.price = price;
		this.stock = stock;
		this.uptime = uptime;
		this.productinfo = productinfo;
		this.productimage = productimage;
		this.productimage_name = productimage_name;
	}




	public ShopDetailBean() {
		super();
	}




	public ShopDetailBean(Integer productno, String productname, Integer price, Integer stock,String productinfo, Blob productimage,String productimage_name) {
		super();
		this.productno = productno;
		this.productname = productname;
		this.price = price;
		this.stock = stock;
		this.productinfo = productinfo;
		this.productimage = productimage;
		this.productimage_name = productimage_name;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ShopDetailBean [productno=");
		builder.append(productno);
		builder.append(", productname=");
		builder.append(productname);
		builder.append(", type=");
		builder.append(type);
		builder.append(", spec=");
		builder.append(spec);
		builder.append(", price=");
		builder.append(price);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", uptime=");
		builder.append(uptime);
		builder.append(", productinfo=");
		builder.append(productinfo);
		builder.append(", productimage=");
		builder.append(productimage);
		builder.append(", productimage_name=");
		builder.append(productimage_name);
		builder.append("]");
		return builder.toString();
	}

	public Integer getProductno() {
		return productno;
	}

	public void setProductno(Integer productno) {
		this.productno = productno;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getSpec() {
		return spec;
	}

	public void setSpec(String spec) {
		this.spec = spec;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getUptime() {
		return uptime;
	}

	public void setUptime(String uptime) {
		this.uptime = uptime;
	}

	public String getProductinfo() {
		return productinfo;
	}

	public void setProductinfo(String productinfo) {
		this.productinfo = productinfo;
	}

	public Blob getProductimage() {
		return productimage;
	}

	public void setProductimage(Blob productimage) {
		this.productimage = productimage;
	}

	public String getProductimage_name() {
		return productimage_name;
	}

	public void setProductimage_name(String productimage_name) {
		this.productimage_name = productimage_name;
	}

}
