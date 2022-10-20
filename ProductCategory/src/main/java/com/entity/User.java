package com.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.print.DocFlavor.STRING;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.UpdateTimestamp;
import org.hibernate.annotations.Where;

@Entity
@Where(clause ="is_active=true")
@SQLDelete(sql = "UPDATE users set is_active=false where user_id=?")
@Table(name="users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private Long userId;
	
	@Column(name="user_name")
	private String userName;
	
	@Column(name="gender")
	@Enumerated(EnumType.STRING)
	private GenderEnum gender;
	
	@Column(name="created_at")
	@CreationTimestamp
	private Date createdAt;
	
	public User(Long userId, String userName, GenderEnum gender, Date createdAt, Date updatedAt, String email,
			String password, boolean isActive) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.email = email;
		this.password = password;
		this.isActive = isActive;
	}

	@Column(name="updated_at")
	@UpdateTimestamp
	private Date updatedAt;
	
	@Column(name="email")
	private String email;

	@Column(name="password")
	private String password;
	
	@Column(name="is_active")
	private boolean isActive=true;
	
	
	@ManyToMany
	private List<Role> role;
	
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}
