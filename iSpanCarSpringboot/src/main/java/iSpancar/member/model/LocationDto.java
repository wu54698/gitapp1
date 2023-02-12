package iSpancar.member.model;

public class LocationDto {
	//會員各地區人數
	private String city;
	private Integer cityNumber;
	
	public LocationDto(String city, Integer cityNumber) {
		this.city = city;
		this.cityNumber = cityNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getCityNumber() {
		return cityNumber;
	}

	public void setCityNumber(Integer cityNumber) {
		this.cityNumber = cityNumber;
	}
	
}
