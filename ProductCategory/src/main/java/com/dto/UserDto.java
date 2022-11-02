package com.dto;

import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.springframework.lang.NonNull;

import com.entity.GenderEnum;


public class UserDto {

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@NonNull
	@NotBlank
	@NotEmpty
	private String userName;
	
	public String getUserName() {
		return userName;
	}

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}



	public GenderEnum getGender() {
		return gender;
	}

	public void setGender(GenderEnum gender) {
		this.gender = gender;
	}

	

	public List<Long> getRoleId() {
		return roleId;
	}



	public UserDto(String userName, String email, String password, GenderEnum gender, List<Long> roleId) {
		super();
		this.userName = userName;
		this.email = email;
		this.password = password;
		this.gender = gender;
		this.roleId = roleId;
	}



	public void setRoleId(List<Long> roleId) {
		this.roleId = roleId;
	}

	@NonNull
	@NotBlank
	@NotEmpty
	private String email;
	
	@NonNull
	@NotBlank
	@NotEmpty
	private String password;
	
	@NonNull
	@NotBlank
	@NotEmpty
	private GenderEnum gender;

	@NonNull
	@NotBlank
	@NotEmpty
	private List<Long> roleId;
	
}
