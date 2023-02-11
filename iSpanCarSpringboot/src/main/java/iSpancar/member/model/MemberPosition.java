package iSpancar.member.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Entity
@Table(name = "memberposition")
@Component 
public class MemberPosition implements Serializable {
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountnumberposition")
	private MemberBean memberbean;
	
	@ManyToOne//(cascade = CascadeType.ALL)
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
