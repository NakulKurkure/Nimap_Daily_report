package com.springrestapi.entity;

//import java.io.Serializable;
//import java.util.Optional;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

//import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;


//import com.fasterxml.jackson.annotation.JsonBackReference;
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Embeddable
//@Embeddable annotation to declare that a class will be embedded by other entities.
//@JsonIgnoreProperties
//@SuppressWarnings("serial")
public class UserRoleId implements java.io.Serializable{


	public User getUsers() {
		return users;
	}

	public UserRoleId(User userId, RoleEntity roleEntityId) {
		super();
		this.users = userId;
		this.roles = roleEntityId;
	}


	public void setUsers(User users) {
		this.users = users;
	}


	public RoleEntity getRoles() {
		return roles;
	}


	public void setRoles(RoleEntity roles) {
		this.roles = roles;
	}

	private static final long serialVersionUID = 1L;

	
	@ManyToOne
	//@JsonIgnore is used at field level to mark a property or list of properties to be ignored.
	//@JsonIgnore
	//@JsonBackReference
	//@JsonManagedReference, @JsonBackReference to allow Jackson to better handle the relation:
	//@JsonIgnore annotation to simply ignore one of the sides of the relationship, thus breaking the chain.
	@JsonManagedReference
	private User users;
	
	public UserRoleId() {
		super();
		// TODO Auto-generated constructor stub
	}

	@ManyToOne
//@JsonIgnore

//	@JsonBackReference
	@JsonManagedReference
	private RoleEntity roles;
	
	
}
