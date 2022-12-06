package carInfo.model;

import java.sql.Blob;

public class CarInfoBean {
	private int carNo;						//車輛編號
	private String carDealName;				//車商名稱
	private String accountNumber;				//帳號
	private String carBrand;				//車輛品牌
	private String carName;					//車輛名稱
	private int stock;						//庫存
	private Blob  carImage;					//車輛照片
	private String carDescription;			//車輛描述
	private String announceDate;			//發布日期
	
	public CarInfoBean() {
		
	}
	
	public CarInfoBean(int carNo, String carDealName, String accountNumber, String carBrand, String carName,
			int stock, Blob carImage, String carDescription, String announceDate) {
		super();
		this.carNo = carNo;
		this.carDealName = carDealName;
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

	public String getCarDealName() {
		return carDealName;
	}

	public void setCarDealName(String carDealName) {
		this.carDealName = carDealName;
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
	
	
	
	
}