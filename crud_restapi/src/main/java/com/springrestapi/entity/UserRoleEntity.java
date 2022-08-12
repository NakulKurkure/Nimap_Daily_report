package com.springrestapi.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import javax.persistence.JoinColumn;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name="user_role")
//overriden mapping for used @AssociationOverrides
@AssociationOverrides({@AssociationOverride(name="pk.users",joinColumns = @JoinColumn(name="user_id")),@AssociationOverride(name="pk.roles",joinColumns = @JoinColumn(name="role_id"))})
//@JsonIgnoreProperties
public class UserRoleEntity implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	
	
	@EmbeddedId
//@JsonManagedReference
	private UserRoleId pk=new UserRoleId();
	
	public UserRoleEntity(UserRoleId pk) {
		super();
		this.pk = pk;
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

