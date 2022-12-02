package iSpan_Car;

import java.sql.Blob;

public class CarInfoBean {
	private int carDealVATNumber;			//車商統編
	private String carDealName;				//車商名稱
	private int accountNumber;				//帳號
	private String carBrand;				//車輛品牌
	private String carName;					//車輛名稱
	private int stock;						//庫存
	private Blob  carImage;					//車輛照片
	private String carDescription;			//車輛描述
	private String announceDate;			//發布日期
	
	public CarInfoBean() {
		
	}
	
	public CarInfoBean(int carDealVATNumber, String carDealName, int accountNumber, String carBrand, String carName,
			int stock, Blob carImage, String carDescription, String announceDate) {
		super();
		this.carDealVATNumber = carDealVATNumber;
		this.carDealName = carDealName;
		this.accountNumber = accountNumber;
		this.carBrand = carBrand;
		this.carName = carName;
		this.stock = stock;
		this.carImage = carImage;
		this.carDescription = carDescription;
		this.announceDate = announceDate;
	}

	public int getCarDealVATNumber() {
		return carDealVATNumber;
	}

	public void setCarDealVATNumber(int carDealVATNumber) {
		this.carDealVATNumber = carDealVATNumber;
	}

	public String getCarDealName() {
		return carDealName;
	}

	public void setCarDealName(String carDealName) {
		this.carDealName = carDealName;
	}

	public int getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(int accountNumber) {
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
