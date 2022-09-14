package com.springrestapi.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
@Entity
@Table(name="logger_entity")
public class ApiLoggerEntity implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private int id;
	
	@Column(name="token")
	private String token;
	
	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="method")
	private String method;
	
	@Column(name="url")
	private String url;
	
	@Column(name="host")
	private String host;
	
	@Column(name="body")
	private String body;

	public ApiLoggerEntity(int id, String token, Date createdAt, String method, String url, String host, String body,
			String ipAddress) {
		super();
		this.id = id;
		this.token = token;
		this.createdAt = createdAt;
		this.method = method;
		this.url = url;
		this.host = host;
		this.body = body;
		this.ipAddress = ipAddress;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	@Column(name="ip_address")
	private String ipAddress;
	


	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public ApiLoggerEntity() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
