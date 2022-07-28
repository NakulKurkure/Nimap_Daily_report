package com.springrestapi.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

//common use case here is for soft-deletes.
@javax.persistence.Entity
@Where(clause ="is_active=true")
@SQLDelete(sql="UPDATE ENTITY SET is_active=false WHERE id=?" )
public class Entity  {

	@Id
	@GeneratedValue
	private Integer id;
	
	public Entity(Integer id, String lname, String name, String occupation, Boolean isActive) {
		super();
		this.id = id;
		this.lname = lname;
		this.name = name;
		this.occupation = occupation;
		this.isActive = isActive;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	private String lname;
	private String name;
//	private String lname;
//	private String password;
	private String occupation;

//	@Column(username = "is_active")
	private Boolean isActive=true;

	

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	
	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setId(int id) {
		this.id = id;
	}
	public Integer getId() {
		return id;
	}


	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	


	



}
