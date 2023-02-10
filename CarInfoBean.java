package iSpan_Car;

import java.io.FileInputStream;

public class CarInfoBean {
	private int carDealerVATNumber;			//車商統編
	private String carDealName;				//車商名稱
	private int accountNumber;				//帳號
	private String carBrand;				//車輛品牌
	private String carName;					//車輛名稱
	private int Stock;						//庫存
	private FileInputStream carImage;		//車輛照片
	private String carDescription;			//車輛描述
	private String announceDate;			//發布日期
	
	public CarInfoBean() {
		
	}
	
	public CarInfoBean(int carDealerVATNumber, String carDealName, int accountNumber, String carBrand, String carName,
			int stock, FileInputStream carImage, String carDescription, String announceDate) {
		super();
		this.carDealerVATNumber = carDealerVATNumber;
		this.carDealName = carDealName;
		this.accountNumber = accountNumber;
		this.carBrand = carBrand;
		this.carName = carName;
		this.Stock = stock;
		this.carImage = carImage;
		this.carDescription = carDescription;
		this.announceDate = announceDate;
	}

	public int getCarDealerVATNumber() {
		return carDealerVATNumber;
	}

	public void setCarDealerVATNumber(int carDealerVATNumber) {
		this.carDealerVATNumber = carDealerVATNumber;
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
		return Stock;
	}

	public void setStock(int stock) {
		this.Stock = stock;
	}

	public FileInputStream getCarImage() {
		return carImage;
	}

	public void setCarImage(FileInputStream carImage) {
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
