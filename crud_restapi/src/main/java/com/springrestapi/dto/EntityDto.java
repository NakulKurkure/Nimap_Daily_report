package com.springrestapi.dto;

import java.io.Serializable;

public class EntityDto implements Serializable{

	private final long serialVersionUID=1;

	private Integer id;
	private String lname;
	private String name;

	private String occupation;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public EntityDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public EntityDto(Integer id, String lname, String name, String occupation) {
		super();
		this.id = id;
		this.lname = lname;
		this.name = name;
		this.occupation = occupation;

	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}


}
