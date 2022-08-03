package com.springrestapi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Where(clause = "is_active=true")
//
@SQLDelete(sql = "UPDATE USERS SET is_active=false WHERE id=?")
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue
	private int id;
	private String email;

	@Column(name = "username")

	private String username;

	private String password;
	private Boolean isActive = true;

	public User(int id, String email, String userName, String password, Boolean isActive) {
		super();
		this.id = id;
		this.email = email;
		this.username = userName;
		this.password = password;
		this.isActive = isActive;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public int getId() {
		return id;
	}

	public User(int id, String email, String userName, String password) {
		super();
		this.id = id;
		this.email = email;
		this.username = userName;
		this.password = password;
	}

	public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User() {
		super();
//		 TODO Auto-generated constructor stub
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
