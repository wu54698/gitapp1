package iSpancar.member.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "memberlogindate")
@Component
public class MemberLoginDate {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountnumber")
	@JsonIgnore
	private MemberBean memberloginbean;
	
	@Column(name = "logindate")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//時間需這樣設定
	private Date logindate;// 創建帳號日期

	public MemberLoginDate() {
	}

	public MemberLoginDate(Integer id, MemberBean memberloginbean, Date logindate) {
		this.id = id;
		this.memberloginbean = memberloginbean;
		this.logindate = logindate;
	}
	
	public MemberLoginDate( MemberBean memberloginbean, Date logindate) {
		this.memberloginbean = memberloginbean;
		this.logindate = logindate;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public MemberBean getMemberloginbean() {
		return memberloginbean;
	}

	public void setMemberloginbean(MemberBean memberloginbean) {
		this.memberloginbean = memberloginbean;
	}

	public Date getLogindate() {
		return logindate;
	}

	public void setLogindate(Date logindate) {
		this.logindate = logindate;
	}
	
	
	

	

}
