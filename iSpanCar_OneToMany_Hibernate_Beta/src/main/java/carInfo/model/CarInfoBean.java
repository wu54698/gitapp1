package carInfo.model;

import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import carDealer.model.CarDealerBean;



@Entity
@Table(name = "carInfo")
public class CarInfoBean {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "carNo")
	private int carNo;						//車輛編號

	@ManyToOne
	@JoinColumn(name = "carDealName")
	private CarDealerBean carDealerBean;	//車商名稱
	
	@Column(name = "accountNumber")
	private String accountNumber;			//帳號
	
	@Column(name = "carBrand")
	private String carBrand;				//車輛品牌
	
	@Column(name = "carName")
	private String carName;					//車輛名稱
	
	@Column(name = "stock")
	private int stock;						//庫存
	
	@Column(name = "carImage")
	private Blob  carImage;					//車輛照片
	
	@Column(name = "carDescription")
	private String carDescription;			//車輛描述
	
	@Column(name = "announceDate")
	private String announceDate;			//發布日期
	
	public CarInfoBean() {
		
	}
	
	

	public CarInfoBean(int carNo, CarDealerBean carDealerBean, String accountNumber, String carBrand, String carName,
			int stock, Blob carImage, String carDescription, String announceDate) {
		super();
		this.carNo = carNo;
		this.carDealerBean = carDealerBean;
		this.accountNumber = accountNumber;
		this.carBrand = carBrand;
		this.carName = carName;
		this.stock = stock;
		this.carImage = carImage;
		this.carDescription = carDescription;
		this.announceDate = announceDate;
	}



	public CarInfoBean(CarDealerBean carDealerBean, String accountNumber, String carBrand, String carName,
			int stock, Blob carImage, String carDescription, String announceDate) {
		super();
		this.carDealerBean = carDealerBean;
		this.accountNumber = accountNumber;
		this.carBrand = carBrand;
		this.carName = carName;
		this.stock = stock;
		this.carImage = carImage;
		this.carDescription = carDescription;
		this.announceDate = announceDate;
	}



	public int getCarNo() {
		return carNo;
	}

	public void setCarNo(int carNo) {
		this.carNo = carNo;
	}

	

	public CarDealerBean getCarDealerBean() {
		return carDealerBean;
	}

	public void setCarDealerBean(CarDealerBean carDealerBean) {
		this.carDealerBean = carDealerBean;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getCarBrand() {
		return carBrand;
	}

	public void setCarBrand(String carBrand) {
		this.carBrand = carBrand;
	}

	public String getCarName() {
		return carName;
	}

	public void setCarName(String carName) {
		this.carName = carName;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public Blob getCarImage() {
		return carImage;
	}

	public void setCarImage(Blob carImage) {
		this.carImage = carImage;
	}

	public String getCarDescription() {
		return carDescription;
	}

	public void setCarDescription(String carDescription) {
		this.carDescription = carDescription;
	}

	public String getAnnounceDate() {
		return announceDate;
	}

	public void setAnnounceDate(String announceDate) {
		this.announceDate = announceDate;
	}
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CarInfoBean [carNo=");
		builder.append(carNo);
		builder.append(", carDealerBean=");
		builder.append(carDealerBean);
		builder.append(", accountNumber=");
		builder.append(accountNumber);
		builder.append(", carBrand=");
		builder.append(carBrand);
		builder.append(", carName=");
		builder.append(carName);
		builder.append(", stock=");
		builder.append(stock);
		builder.append(", carImage=");
		builder.append(carImage);
		builder.append(", carDescription=");
		builder.append(carDescription);
		builder.append(", announceDate=");
		builder.append(announceDate);
		builder.append("]");
		return builder.toString();
	}
	
}