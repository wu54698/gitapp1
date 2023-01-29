package iSpancar.member.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "memberposition")
@Component
public class MemberPosition implements Serializable {
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountnumberposition")
	private MemberBean memberbean;
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "positionfk")
	private PermissionsOfPosition permissionsofposition;
	
	public MemberPosition() {
	}

	public MemberPosition(PermissionsOfPosition permissionsOfPosition) {
		super();
		this.permissionsofposition = permissionsOfPosition;
	}

	public MemberBean getMemberBean() {
		return memberbean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberbean = memberBean;
	}

	public MemberBean getMemberbean() {
		return memberbean;
	}

	public void setMemberbean(MemberBean memberbean) {
		this.memberbean = memberbean;
	}

	public PermissionsOfPosition getPermissionsofposition() {
		return permissionsofposition;
	}

	public void setPermissionsofposition(PermissionsOfPosition permissionsofposition) {
		this.permissionsofposition = permissionsofposition;
	}

	
}
