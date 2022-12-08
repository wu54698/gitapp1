﻿package iSpanCar;  

import java.io.FileInputStream;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ServiceBean implements Serializable {
	private String Service_name;		// 保養廠名稱	
	private Blob	Carimage;    		// 保養廠照片
	private String Servicedescription;  // 保養廠描述
	private String Serviceinfomation;  	// 保養廠資訊電話
	private String Contactperson;   	// 保養廠聯繫
	private String Reseller_nonreseller;// 原廠副廠
	
	public String getServiceinfomation() {
		return Serviceinfomation;
	}

	public String getService_name() {
		return Service_name;
	}

	public void setService_name(String service_name) {
		Service_name = service_name;
	}

	public Blob getCarimage() {
		return Carimage;
	}

	public void setCarimage(Blob carimage) {
		Carimage = carimage;
	}

	public String getServicedescription() {
		return Servicedescription;
	}

	public void setServicedescription(String servicedescription) {
		Servicedescription = servicedescription;
	}

	public String getContactperson() {
		return Contactperson;
	}

	public void setContactperson(String contactperson) {
		Contactperson = contactperson;
	}

	public String getReseller_nonreseller() {
		return Reseller_nonreseller;
	}

	public void setReseller_nonreseller(String reseller_nonreseller) {
		Reseller_nonreseller = reseller_nonreseller;
	}

	public void setServiceinfomation(String serviceinfomation) {
		Serviceinfomation = serviceinfomation;
	}

	public ServiceBean(String service_name, Blob carimage, String servicedescription, String serviceinfomation,
			String contactperson, String reseller_nonreseller) {
		super();
		Service_name = service_name;
		Carimage = carimage;
		Servicedescription = servicedescription;
		Serviceinfomation = serviceinfomation;
		Contactperson = contactperson;
		Reseller_nonreseller = reseller_nonreseller;
	}

	public ServiceBean() {
}
}
