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
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;



@Entity
@Where(clause = "is_active=true")
@Table(name="user_role")

//Overridden mapping for used @AssociationOverrides
@AssociationOverrides({@AssociationOverride(name="pk.users",joinColumns = @JoinColumn(name="user_id")),@AssociationOverride(name="pk.roles",joinColumns = @JoinColumn(name="role_id"))})
//@JsonIgnoreProperties

public class UserRoleEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@CreationTimestamp
	private Date created_At;
	
	@UpdateTimestamp
	private Date Updated_At;

	@Column(name="is_active")
	private boolean is_Active=true;
	
	//Composite primary key :-Combination of two or more columns to form of primary key.
	@EmbeddedId
	//@JsonManagedReference
	private UserRoleId pk=new UserRoleId();

	public UserRoleEntity(Date created_At, Date updated_At, boolean is_Active, UserRoleId pk) {
		super();
		this.created_At = created_At;
		Updated_At = updated_At;
		this.is_Active = is_Active;
		this.pk = pk;
	}


	public Date getCreated_At() {
		return created_At;
	}


	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}


	public Date getUpdated_At() {
		return Updated_At;
	}


	public void setUpdated_At(Date updated_At) {
		Updated_At = updated_At;
	}


	public boolean isIs_Active() {
		return is_Active;
	}


	public void setIs_Active(boolean is_Active) {
		this.is_Active = is_Active;
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

