package iSpancar.member.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "oauth2member")
@Component
public class Oauth2MemberBean  implements Serializable{
	
	@Id
	@Column(name = "email")
	private String email;
	
	@Column(name = "membername")
	private String membername;
	
	@Column(name = "picture")
	private String picture;
	
	public Oauth2MemberBean() {
	}

	public Oauth2MemberBean(String email, String membername, String picture) {
		this.email = email;
		this.membername = membername;
		this.picture = picture;
	}


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMembername() {
		return membername;
	}

	public void setMembername(String membername) {
		this.membername = membername;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	
	

}
