package iSpancar.member.model;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "member")
@Component
public class MemberBean implements Serializable{
	
	@Id
	@Column(name = "accountnumber")
	private String accountnumber;//${login.accountnumber}
	
	@Column(name = "memberpassword")
	private String memberpassword;// 密碼
	
	@Column(name = "membername")
	private String memberName;// 姓名
	
	@Column(name = "phonenumber")
	private String phonenumber;// 電話
	
	@Column(name = "email")
	private String email;// e-mail
	
	@Column(name = "memberaddress")
	private String memberaddress;// 地址
	
	@Column(name = "platenumber")
	private String platenumber;// 車牌
	
	@Column(name = "birthday")
	@JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")//時間需這樣設定
	private Date birthday;// 生日
	
	
	@Column(name = "idnumber")
	private String idnumber;// 身分證號碼
	
	@Column(name = "cardnumber")
	private String cardnumber;//信用卡
	
	@Column(name = "personalimg")
	private Blob file;//圖
	
	@Column(name = "imgfilename")
	private String filename;
	
	@OneToOne(mappedBy = "memberbean")
	@JsonIgnore
	private MemberPosition memberPosition;
	
	@Override
	public String toString() {
		return "MemberBean [accountnumber=" + accountnumber + ", memberpassword=" + memberpassword + ", memberName="
				+ memberName + ", phonenumber=" + phonenumber + ", email=" + email + ", memberaddress=" + memberaddress
				+ ", platenumber=" + platenumber + ", birthday=" + birthday + ", idnumber=" + idnumber + ", cardnumber="
				+ cardnumber + ", file=" + file + ", filename=" + filename + "]";
	}



	public MemberBean(String accountnumber, String memberpassword, String memberName, String phonenumber, String email,
			String memberaddress, String platenumber, Date birthday, String idnumber, String cardnumber, Blob file,
			String filename, MemberPosition memberPosition) {
		super();
		this.accountnumber = accountnumber;
		this.memberpassword = memberpassword;
		this.memberName = memberName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.memberaddress = memberaddress;
		this.platenumber = platenumber;
		this.birthday = birthday;
		this.idnumber = idnumber;
		this.cardnumber = cardnumber;
		this.file = file;
		this.filename = filename;
		this.memberPosition = memberPosition;
	}

	public MemberBean(String accountnumber, String memberpassword, String memberName, String phonenumber, String email,
			String memberaddress, String platenumber, Date birthday, String idnumber, String cardnumber, Blob file,
			String filename) {
		super();
		this.accountnumber = accountnumber;
		this.memberpassword = memberpassword;
		this.memberName = memberName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.memberaddress = memberaddress;
		this.platenumber = platenumber;
		this.birthday = birthday;
		this.idnumber = idnumber;
		this.cardnumber = cardnumber;
		this.file = file;
		this.filename = filename;
	}


	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}
//	private java.sql.Timestamp registerDate; // 會員登錄日期
	
	public String getAccountnumber() {
		return accountnumber;
	}

	

	public void setFilename(String filename) {
		this.filename = filename;
	}



	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public MemberBean() {
	}


	public String getFilename() {
		return filename;
	}


	//無圖
	public MemberBean(String accountnumber, String memberpassword, String memberName, String phonenumber, String email,
			String memberaddress, String platenumber, Date birthday, String idnumber,String cardnumber) {
		super();
		this.accountnumber = accountnumber;
		this.memberpassword = memberpassword;
		this.memberName = memberName;
		this.phonenumber = phonenumber;
		this.email = email;
		this.memberaddress = memberaddress;
		this.platenumber = platenumber;
		this.birthday = birthday;
		this.idnumber = idnumber;
		this.cardnumber = cardnumber;
	}



	public Blob getFile() {
		return file;
	}



	public void setFile(Blob file) {
		this.file = file;
	}



	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	public String getPhonenumber() {
		return phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public String getMemberpassword() {
		return memberpassword;
	}

	public void setMemberpassword(String memberpassword) {
		this.memberpassword = memberpassword;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMemberaddress() {
		return memberaddress;
	}

	public void setMemberaddress(String memberaddress) {
		this.memberaddress = memberaddress;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	public void setPlatenumber(String platenumber) {
		this.platenumber = platenumber;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}



	public MemberPosition getMemberPosition() {
		return memberPosition;
	}


	public void setMemberPosition(MemberPosition memberPosition) {
		this.memberPosition = memberPosition;
	}


}
