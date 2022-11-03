package com.job.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name="logger")
public class Logger {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="logger_id")
	private long id;

	public Logger() {
		super();
	}

	@Column(name="token")
	private String token;
	
	public Logger(long id, String token, User userId, Date createdAt, Date expireAt) {
		super();
		this.id = id;
		this.token = token;
		this.userId = userId;
		this.createdAt = createdAt;
		this.expireAt = expireAt;
	}

//	@Column(name="user_id")
	@OneToOne(fetch = FetchType.LAZY)
	private User userId;

	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="expire_at")
	
	private Date expireAt;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getExpireAt() {
		return expireAt;
	}

	public void setExpireAt(Date expireAt) {
		this.expireAt = expireAt;
	}
	

}
