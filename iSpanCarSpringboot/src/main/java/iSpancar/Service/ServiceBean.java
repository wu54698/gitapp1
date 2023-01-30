package iSpancar.Service;  

import java.io.Serializable;
import java.sql.Blob;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;
@Entity
@Table(name="Service")
@Component

public class ServiceBean implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "servicename")
	private String Servicename;		// 保養廠名稱	
	
	@Column(name = "carimage")
	private Blob Carimage;    		// 保養廠照片
	
	@Column(name = "servicedescription")
	private String Servicedescription;  // 保養廠描述
	
	@Column(name = "serviceinfomation")
	private String Serviceinfomation;  	// 保養廠資訊電話
	
	@Column(name = "contactperson")
	private String Contactperson;   	// 保養廠聯繫
	
	@Column(name = "resllernonreseller")
	private String Resellernonreseller;// 原廠副廠
	
	public String getServiceinfomation() {
		return Serviceinfomation;
	}

	public String getServicename() {
		return Servicename;
	}

	public void setServicename(String servicename) {
		Servicename = servicename;
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

	public String getResellernonreseller() {
		return Resellernonreseller;
	}

	public void setResellernonreseller(String resellernonreseller) {
		Resellernonreseller = resellernonreseller;
	}

	public void setServiceinfomation(String serviceinfomation) {
		Serviceinfomation = serviceinfomation;
	}

	public ServiceBean(String servicename, Blob carimage, String servicedescription, String serviceinfomation,
			String contactperson, String resellernonreseller) {
		super();
		Servicename = servicename;
		Carimage = carimage;
		Servicedescription = servicedescription;
		Serviceinfomation = serviceinfomation;
		Contactperson = contactperson;
		Resellernonreseller = resellernonreseller;
	}

	public ServiceBean() {
}


	
	
}
