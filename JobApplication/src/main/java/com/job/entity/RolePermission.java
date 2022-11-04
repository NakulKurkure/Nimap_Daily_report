package com.job.entity;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Table(name="role_permission")
@Where(clause = "is_active=true")
@SQLDelete(sql="UPDATE role_permission p SET is_active=false WHERE p.permissions_id=? AND p.role_id=?")
@AssociationOverrides({@AssociationOverride(name="pk.role",joinColumns = @JoinColumn(name="role_id")),@AssociationOverride(name="pk.permission",joinColumns = @JoinColumn(name="permission_id"))})

public class RolePermission {


	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RolePermissionId pk=new RolePermissionId();

	public RolePermission() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RolePermission(RolePermissionId pk, Date created_At, Date updated_At, boolean is_Active) {
		super();
		this.pk = pk;
		this.created_At = created_At;
		this.updated_At = updated_At;
		this.is_Active = is_Active;
	}

	public RolePermissionId getPk() {
		return pk;
	}

	public void setPk(RolePermissionId pk) {
		this.pk = pk;
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

	public boolean isIs_Active() {
		return is_Active;
	}

	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
	}

	@CreationTimestamp
	@Column(name="created_at")
	private Date created_At;


	@UpdateTimestamp
	@Column(name="updated_at")
	private Date updated_At;

	@Column(name="is_active")
	private boolean is_Active=true;
}
