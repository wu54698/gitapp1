package model;

import java.sql.Blob;

public class ShopDetailBean {
	private Integer productno;
	private String productname;
	private String type;
	private String spec;
	private Integer price;
	private Integer stock;
	private String uptime;
	private String productinfo;
	private Blob productimage;
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
