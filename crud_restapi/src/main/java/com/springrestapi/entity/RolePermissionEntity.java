package com.springrestapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
//import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@javax.persistence.Entity
@Table(name="role_permission")
@AssociationOverrides({@AssociationOverride(name="pk.roles",joinColumns = @JoinColumn(name="role_id")),@AssociationOverride(name="pk.permission",joinColumns = @JoinColumn(name="permission_id"))})
public class RolePermissionEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolePermissionId pk=new RolePermissionId();
	
	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updatedAt;
	
	
	@Column(name="is_active")
	private boolean isActive=true;

	
	public RolePermissionId getPk() {
		return pk;
	}


	public void setPk(RolePermissionId pk) {
		this.pk = pk;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public Date getUpdatedAt() {
		return updatedAt;
	}


	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}


	public RolePermissionEntity() {
		super();
		// TODO Auto-generated constructor stub
	}


	public boolean isActive() {
		return isActive;
	}


	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public RolePermissionEntity(RolePermissionId pk, Date createdAt, Date updatedAt, boolean isActive) {
		super();
		this.pk = pk;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}
	
	
}

