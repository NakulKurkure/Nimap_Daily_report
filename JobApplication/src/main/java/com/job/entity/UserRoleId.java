package com.job.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Embeddable
public class UserRoleId implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@ManyToOne
	@JsonManagedReference
	private User user;
	
	public UserRoleId(User user, Role role) {
		super();
		this.user = user;
		this.role = role;
	}

	public UserRoleId() {
		super();
		
	}

	@ManyToOne
	@JsonManagedReference
	private Role role;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
}
