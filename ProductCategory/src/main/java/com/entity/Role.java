package com.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;


@Entity
@Where(clause ="is_active=true")
@SQLDelete(sql = "UPDATE role set is_active=false where role_id=?")
@Table(name="role")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long roleId;

	@Column(name="role_name")
	private String roleName;

	public boolean isActive() {
		return isActive;
	}

	public Role(Long roleId, String roleName, String description, Date created_At, Date updated_At, boolean isActive) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.description = description;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.isActive = isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}


	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Column(name="description")
	private String description;

	@Column(name="created_at")
	@CreationTimestamp
	private Date created_At;


	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updated_At;
	

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getUpdated_At() {
		return updated_At;
	}

	public void setUpdated_At(Date updated_At) {
		this.updated_At = updated_At;
	}


	@Column(name="is_active")
	private boolean isActive=true;


}
