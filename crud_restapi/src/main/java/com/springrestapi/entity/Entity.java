package com.springrestapi.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@javax.persistence.Entity
public class Entity {

	@Id
	@GeneratedValue
	private long eid;
	private String fname;
	private String lname;
	private String occupation;
	
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public Entity() {
		super();
		// TODO Auto-generated constructor stub
	}
	public long getEid() {
		return eid;
	}
	public void setEid(long eid) {
		this.eid = eid;
	}
	public String getLname() {
		return lname;
	}
	public Entity(long eid, String fname, String lname, String occupation) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.occupation = occupation;
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
