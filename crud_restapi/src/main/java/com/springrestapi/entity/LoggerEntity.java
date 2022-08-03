package com.springrestapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
@Entity
@Table(name="logger")
//@SQLDelete(sql = "UPDATE logger  SET is_active=false WHERE token=?")
public class LoggerEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "token", length = 512)
	private String token;

	private Boolean isActive=true;

	


public LoggerEntity(int id, String token, Boolean isActive, User userId, Date createdAt, Date expireAt) {
		super();
		this.id = id;
		this.token = token;
		this.isActive = isActive;
		this.userId = userId;
		this.CreatedAt = createdAt;
		this.expireAt = expireAt;
	}



public Boolean getIsActive() {
		return isActive;
	}



	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}


public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}

	
	@OneToOne(fetch = FetchType.LAZY)
	private User userId;
	
	@CreationTimestamp
	private Date CreatedAt;
	
	

	private Date expireAt;
	
	public LoggerEntity() {
		super();
			}




	public Date getCreatedAt() {
		return CreatedAt;
	}



	public void setCreatedAt(Date createdAt) {
		CreatedAt = createdAt;
	}



	public Date getExpireAt() {
		return expireAt;
	}



	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}



	



	
}
