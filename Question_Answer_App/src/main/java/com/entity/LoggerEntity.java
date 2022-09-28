package com.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class LoggerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="token")
	private String token;
	
	public LoggerEntity(Long id, String token, UserEntity userId, Date created_At, Date expire_At) {
		super();
		this.id = id;
		this.token = token;
		this.userId = userId;
		this.created_At = created_At;
		this.expire_At = expire_At;
	}

	public LoggerEntity() {
		super();
		
	}

	
	@OneToOne(fetch = FetchType.LAZY)
	private UserEntity userId;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UserEntity getUserId() {
		return userId;
	}

	public void setUserId(UserEntity userId) {
		this.userId = userId;
	}

	public Date getCreated_At() {
		return created_At;
	}

	public void setCreated_At(Date created_At) {
		this.created_At = created_At;
	}

	public Date getExpire_At() {
		return expire_At;
	}

	public void setExpire_At(Date expire_At) {
		this.expire_At = expire_At;
	}

	@Column(name= "created_at")
	@CreationTimestamp
	private Date created_At;
	
	@Column(name="expire_at")
	private Date expire_At;


	
}
