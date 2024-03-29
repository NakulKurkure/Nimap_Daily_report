package com.springrestapi.entity;

import java.io.Serializable;
import java.sql.Date;

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
//Where clause to add to the element Entity or target entity of a collection.
@Where(clause = "is_active=true")
// @SQLDelete annotation to override the delete command.
@SQLDelete(sql="UPDATE user_role u SET is_active=false WHERE u.role_id=? AND u.user_id=?")
@Table(name="user_role")

//Overridden mapping for used @AssociationOverrides
@AssociationOverrides({@AssociationOverride(name="pk.users",joinColumns = @JoinColumn(name="user_id")),@AssociationOverride(name="pk.roles",joinColumns = @JoinColumn(name="role_id"))})
//@JsonIgnoreProperties

public class UserRoleEntity implements Serializable{
	
	
	private static final long serialVersionUID = 1L;
	
	@CreationTimestamp
	private Date created_At;
	
	@UpdateTimestamp
	private Date Updated_At;

	@Column(name="is_active")
	private boolean isActive=true;
	
	//Composite primary key :-Combination of two or more columns to form of primary key.
	@EmbeddedId
	//@JsonManagedReference
	private UserRoleId pk=new UserRoleId();

	public UserRoleEntity(Date created_At, Date updated_At, boolean isActive, UserRoleId pk) {
		super();
		this.created_At = created_At;
		Updated_At = updated_At;
		this.isActive = isActive;
		this.pk = pk;
	}

	@CreationTimestamp
	public Date getCreated_At() {
		return created_At;
	}


	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	@UpdateTimestamp
	public Date getUpdated_At() {
		return Updated_At;
	}


	public void setUpdated_At(Date updated_At) {
		Updated_At = updated_At;
	}


	public boolean isIsActive() {
		return isActive;
	}


	public void setIs_Active(boolean isActive) {
		this.isActive = isActive;
	}


	public UserRoleId getPk() {
		return pk;
	}



	public void setPk(UserRoleId pk) {
		this.pk = pk;
	}



	public UserRoleEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}

