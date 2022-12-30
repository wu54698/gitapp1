package tw.hibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "company")
public class CompanyBean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "companyId")
	private Integer companyId;

	@Column(name = "companyName")
	private String companyName;

	public CompanyBean() {
		// TODO Auto-generated constructor stub
	}

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

}
