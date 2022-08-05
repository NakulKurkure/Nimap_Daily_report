package com.springrestapi.entity;



import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
@AssociationOverrides({@AssociationOverride(name="pk.users",joinColumns = @JoinColumn(name="user_id")),@AssociationOverride(name="pk.roles",joinColumns = @JoinColumn(name="role_id"))})
public class UserRoleEntity {

	@EmbeddedId
	UserRoleId pk=new UserRoleId();
	
	public UserRoleEntity(UserRoleId pk, boolean isActive) {
		super();
		this.pk = pk;
		this.isActive = isActive;
	}
	
	public UserRoleId getPk() {
		return pk;
	}

	public void setPk(UserRoleId pk) {
		this.pk = pk;
	}

	public UserRoleEntity(boolean isActive) {
		super();
		this.isActive = isActive;
	}

	@Column(name="is_active")
	private boolean isActive=true;

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public UserRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

