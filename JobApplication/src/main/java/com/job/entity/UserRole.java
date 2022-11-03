package com.job.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="user_role")
public class UserRole {

	public UserRole(UserRoleId pk, Date createdAt, Date updatedAt, boolean isActive) {
		super();
		this.pk = pk;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.isActive = isActive;
	}

	@EmbeddedId
	private UserRoleId pk=new UserRoleId();
	
	public UserRoleId getPk() {
		return pk;
	}

	public void setPk(UserRoleId pk) {
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

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Column(name="created_at")
	private Date createdAt;
	
	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="is_active")
	private boolean isActive=true;
	
	
}
