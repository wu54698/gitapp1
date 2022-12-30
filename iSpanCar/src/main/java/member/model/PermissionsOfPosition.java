package member.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "permissionsOfPosition")
public class PermissionsOfPosition implements Serializable {

	@Id
	@Column(name = "member_position")
	private String positionPk;
	
	@Column( name = "permissions_insert")
	private String permissionsInsert;
	
	@Column( name = "permissions_update")
	private String permissionsUpdate;
	
	@Column( name = "permissions_delete")
	private String permissionsDelete;
	
	@Column( name = "permissions_select")
	private String permissionsSelect;
	
	@OneToOne(mappedBy = "permissionsOfPosition")
	private MemberPosition memberPosition;
	
	public PermissionsOfPosition() {
	}

	public String getPositionPk() {
		return positionPk;
	}

	public void setPositionPk(String positionPk) {
		this.positionPk = positionPk;
	}

	public String getPermissionsInsert() {
		return permissionsInsert;
	}

	public void setPermissionsInsert(String permissionsInsert) {
		this.permissionsInsert = permissionsInsert;
	}

	public String getPermissionsUpdate() {
		return permissionsUpdate;
	}

	public void setPermissionsUpdate(String permissionsUpdate) {
		this.permissionsUpdate = permissionsUpdate;
	}

	public String getPermissionsDelete() {
		return permissionsDelete;
	}

	public void setPermissionsDelete(String permissionsDelete) {
		this.permissionsDelete = permissionsDelete;
	}

	public String getPermissionsSelect() {
		return permissionsSelect;
	}

	public void setPermissionsSelect(String permissionsSelect) {
		this.permissionsSelect = permissionsSelect;
	}

	public MemberPosition getMemberPosition() {
		return memberPosition;
	}

	public void setMemberPosition(MemberPosition memberPosition) {
		this.memberPosition = memberPosition;
	}

}
