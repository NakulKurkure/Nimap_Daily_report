package com.springrestapi.dto;
//package com.springrestapi.dto;

public class UserDto {

//	private final long serialVersionUID=1;

	private Integer id;
	private String email;
	private String userName;
	private String password;

	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(Integer id, String email, String userName, String password) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.password = password;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}




}

