package iSpancar.carDealer.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

import iSpancar.carInfo.model.CarInfoBean;

@Entity
@Table(name = "cardealerinfo")
@Component
public class CarDealerBean {
	

	@Id
	@Column(name = "cardealername")
	private String carDealName; 		//車商名稱
	
	@Column(name = "cardealerphone")
	private String carDealPhone;		//車商電話
	
	@Column(name = "cardealeraddress")
	private String carDealAddress;		//地址
	
	@Column(name = "opentime")
	private String openTime;			//營業時間
	
	@Column(name = "contactperson")
	private String contactPerson;		//聯絡人
	
	@Column(name = "cardealervatnumber")
	private int carDealVATNumber;		//統一編號
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cardealerbean", cascade = CascadeType.ALL)
	@JsonIgnore
	private Set<CarInfoBean> carInfo = new LinkedHashSet<>();
	
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

	public Set<CarInfoBean> getCarInfo() {
		return carInfo;
	}

	public void setCarInfo(Set<CarInfoBean> carInfo) {
		this.carInfo = carInfo;
	}
	
}