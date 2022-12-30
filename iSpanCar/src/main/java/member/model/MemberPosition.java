package member.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "memberPosition")
public class MemberPosition implements Serializable {
	
	@Id
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "accountnumber_position")
	private MemberBean memberBean;
	
	@OneToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name = "position_fk")
	private PermissionsOfPosition permissionsOfPosition;
	
	public MemberPosition() {
	}

	public MemberPosition(PermissionsOfPosition permissionsOfPosition) {
		super();
		this.permissionsOfPosition = permissionsOfPosition;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public PermissionsOfPosition getPermissionsOfPosition() {
		return permissionsOfPosition;
	}

	public void setPermissionsOfPosition(PermissionsOfPosition permissionsOfPosition) {
		this.permissionsOfPosition = permissionsOfPosition;
	}

}
