package com.springrestapi.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

//common use case here is for soft-deletes.
@javax.persistence.Entity
@Where(clause ="is_active=true")
@SQLDelete(sql="UPDATE ENTITY SET is_active=false WHERE id=?" )
public class Entity  {

	@Id
	@GeneratedValue
	private Integer id;
	private String lname;
	private String name;
//	private String lname;
	private String occupation;

//	@Column(name = "is_active")
	private Boolean isActive=true;

	public Entity(int id, String lname, String name, String occupation, Boolean isActive) {
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
