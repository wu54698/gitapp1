package iSpancar.carInfo.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "carinfoimage")
@Component
public class CarInfoImageBean {
	
	@Id
	@Column(name = "imageno")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int imageNo;				//次要多圖，圖片編號
	
	@JoinColumn(name="carno")
	@ManyToOne
	@JsonIgnore
	private CarInfoBean carInfoBean;	//carNo車輛編號，與carInfoBean為一對多關聯
	
	@Column(name="carimage")
	@JsonIgnore
	private Blob carImage;				//次要多圖
	
	
	public CarInfoImageBean() {
		
	}


	public CarInfoImageBean(int imageNo, CarInfoBean carInfoBean, Blob carImage) {
		super();
		this.imageNo = imageNo;
		this.carInfoBean = carInfoBean;
		this.carImage = carImage;
	}


	public int getImageNo() {
		return imageNo;
	}


	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}


	public CarInfoBean getCarInfoBean() {
		return carInfoBean;
	}


	public void setCarNo(CarInfoBean carInfoBean) {
		this.carInfoBean = carInfoBean;
	}


	public Blob getCarImage() {
		return carImage;
	}


	public void setCarImage(Blob carImage) {
		this.carImage = carImage;
	}


	
}
