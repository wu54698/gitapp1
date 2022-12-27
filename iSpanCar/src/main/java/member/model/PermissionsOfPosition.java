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
	@Column(name = "position")
	private String position;
	
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

}
