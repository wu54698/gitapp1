package iSpancar.orderservice;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="orderservice")
@Component
public class OrderServiceBean implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "ordername")
	private String Ordername;
	
	@Column(name = "servicename")
	private String Servicename;
	
	@Column(name = "orderemail")
	private String Orderemail;

	@Column(name = "orderphonenumber")
	private String Orderphonenumber;
	
	@Column(name = "orderdate")
	private String Orderdate;

	@Column(name = "ordertime")
	private String Ordertime;
	
	@Column(name = "orderproduct")
	private String Orderproduct;
	
	@Column(name = "orderremarks")
	private String Orderremarks;
	
	public String getOrdername() {
		return Ordername;
	}

	public void setOrdername(String ordername) {
		Ordername = ordername;
	}
	public String getServicename() {
		return Servicename;
	}
	
	public void setServicename(String servicename) {
		Servicename = servicename;
	}

	public String getOrderemail() {
		return Orderemail;
	}

	public void setOrderemail(String orderemail) {
		Orderemail = orderemail;
	}

	public String getOrderphonenumber() {
		return Orderphonenumber;
	}

	public void setOrderphonenumber(String orderphonenumber) {
		Orderphonenumber = orderphonenumber;
	}

	public String getOrderdate() {
		return Orderdate;
	}

	public void setOrderdate(String orderdate) {
		Orderdate = orderdate;
	}

	public String getOrdertime() {
		return Ordertime;
	}

	public void setOrdertime(String ordertime) {
		Ordertime = ordertime;
	}

	public String getOrderproduct() {
		return Orderproduct;
	}

	public void setOrderproduct(String orderproduct) {
		Orderproduct = orderproduct;
	}

	public String getOrderremarks() {
		return Orderremarks;
	}

	public void setOrderremarks(String orderremarks) {
		Orderremarks = orderremarks;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	public OrderServiceBean(String ordername, String orderemail, String orderphonenumber, String orderdate,
			String ordertime, String orderproduct, String orderremarks , String servicename) {
		super();
		Ordername = ordername;
		Orderemail = orderemail;
		Orderphonenumber = orderphonenumber;
		Orderdate = orderdate;
		Ordertime = ordertime;
		Orderproduct = orderproduct;
		Orderremarks = orderremarks;
		Servicename = servicename;
	}
	public OrderServiceBean() {
	}

}
