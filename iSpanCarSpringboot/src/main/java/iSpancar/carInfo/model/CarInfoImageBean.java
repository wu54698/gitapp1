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
	private int imageNo;
	
	@JoinColumn(name="carno")
	@ManyToOne
	private CarInfoBean carNo;
	
	@Column(name="carimage")
	@JsonIgnore
	private Blob carImage;
	
	
	public CarInfoImageBean() {
		
	}


	public CarInfoImageBean(int imageNo, CarInfoBean carNo, Blob carImage) {
		super();
		this.imageNo = imageNo;
		this.carNo = carNo;
		this.carImage = carImage;
	}


	public int getImageNo() {
		return imageNo;
	}


	public void setImageNo(int imageNo) {
		this.imageNo = imageNo;
	}


	public CarInfoBean getCarNo() {
		return carNo;
	}


	public void setCarNo(CarInfoBean carNo) {
		this.carNo = carNo;
	}


	public Blob getCarImage() {
		return carImage;
	}


	public void setCarImage(Blob carImage) {
		this.carImage = carImage;
	}


	
}
