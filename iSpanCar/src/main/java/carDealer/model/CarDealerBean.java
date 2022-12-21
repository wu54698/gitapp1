package carDealer.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carDealerInfo")
public class CarDealerBean implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "carDealerName")
	private String carDealName; 	//車商名稱
	
	@Column(name = "carDealerPhone")
	private String carDealPhone;		//車商電話
	
	@Column(name = "carDealerAddress")
	private String carDealAddress;	//地址
	
	@Column(name = "openTime")
	private String openTime;		//營業時間
	
	@Column(name = "contactPerson")
	private String contactPerson;	//聯絡人
	
	@Column(name = "carDealerVATNumber")
	private int carDealVATNumber;	//統一編號
	
	public CarDealerBean() {
		
	}
	
	public CarDealerBean(String carDealName, String carDealPhone, String carDealAddress, String openTime,
			String contactPerson, int carDealVATNumber) {
		super();
		this.carDealName = carDealName;
		this.carDealPhone = carDealPhone;
		this.carDealAddress = carDealAddress;
		this.openTime = openTime;
		this.contactPerson = contactPerson;
		this.carDealVATNumber = carDealVATNumber;
	}


	public String getCarDealName() {
		return carDealName;
	}


	public void setCarDealName(String carDealName) {
		this.carDealName = carDealName;
	}


	public String getCarDealPhone() {
		return carDealPhone;
	}


	public void setCarDealPhone(String carDealPhone) {
		this.carDealPhone = carDealPhone;
	}


	public String getCarDealAddress() {
		return carDealAddress;
	}


	public void setCarDealAddress(String carDealAddress) {
		this.carDealAddress = carDealAddress;
	}


	public String getOpenTime() {
		return openTime;
	}


	public void setOpenTime(String openTime) {
		this.openTime = openTime;
	}


	public String getContactPerson() {
		return contactPerson;
	}


	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}


	public int getCarDealVATNumber() {
		return carDealVATNumber;
	}


	public void setCarDealVATNumber(int carDealVATNumber) {
		this.carDealVATNumber = carDealVATNumber;
	}
	
}