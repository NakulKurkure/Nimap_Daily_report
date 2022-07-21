package com.springrestapi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@javax.persistence.Entity
public class Entity {

	@Id
	@GeneratedValue
	private long id;
	private String lname;
	private String name;
//	private String lname;
	private String occupation;
	
	private Boolean isActive=true;
	
	public Entity(long id, String lname, String name, String occupation, Boolean isActive) {
		super();
		this.id = id;
		this.lname = lname;
		this.name = name;
		this.occupation = occupation;
		this.isActive = isActive;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
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
