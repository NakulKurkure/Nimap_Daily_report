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

@Entity
@Table(name="logger")
public class LoggerEntity implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "token", length = 512)
	private String token;

	
	
public LoggerEntity(int id, String token, User userId, Date createdAt, Date expireAt) {
		super();
		this.id = id;
		this.token = token;
		this.userId = userId;
		CreatedAt = createdAt;
		this.expireAt = expireAt;
	}



public String getToken() {
		return token;
	}



	public void setToken(String token) {
		this.token = token;
	}

	//	@JoinColumn(name="user_id")
	@OneToOne(fetch = FetchType.LAZY)
	private User userId;
	
	private Date CreatedAt;
	
	private Date expireAt;
	
	public LoggerEntity() {
		super();
			}

	

	public LoggerEntity(int id, User userId, Date createdAt, Date expireAt) {
		super();
		this.id = id;
		this.userId = userId;
		CreatedAt = createdAt;
		this.expireAt = expireAt;
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
