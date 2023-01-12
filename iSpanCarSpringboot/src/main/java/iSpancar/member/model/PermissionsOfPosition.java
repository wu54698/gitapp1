package iSpancar.member.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Table(name = "permissionsofposition")
@Component
public class PermissionsOfPosition implements Serializable {

	@Id
	@Column(name = "memberposition")
	private String positionPk;
	
	@Column( name = "permissionsinsert")
	private String permissionsInsert;
	
	@Column( name = "permissionsupdate")
	private String permissionsUpdate;
	
	@Column( name = "permissionsdelete")
	private String permissionsDelete;
	
	@Column( name = "permissionsselect")
	private String permissionsSelect;
	
	@OneToOne(mappedBy = "permissionsofposition")
	private MemberPosition memberposition;
	
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
		return memberposition;
	}

	public void setMemberPosition(MemberPosition memberPosition) {
		this.memberposition = memberPosition;
	}

}
