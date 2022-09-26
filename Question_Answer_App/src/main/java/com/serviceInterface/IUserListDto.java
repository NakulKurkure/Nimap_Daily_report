package com.serviceInterface;

import com.entity.GenderEnum;

public interface IUserListDto {

	public Long getId();
	
	public String getEmail();
	
	public String getUsername();
	
	public GenderEnum getGender();
}
