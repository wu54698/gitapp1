package tw.hibernatedemo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "member")
public class Member {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "member_name")
	private String memberName;
	
	@Column(name = "member_pwd")
	private String memberPwd;
	
	
	public Member() {
		// TODO Auto-generated constructor stub
	}


	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getMemberName() {
		return memberName;
	}



	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}



	public String getMemberPwd() {
		return memberPwd;
	}



	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	
}
