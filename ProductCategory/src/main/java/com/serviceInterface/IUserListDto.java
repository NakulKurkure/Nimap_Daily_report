package com.serviceInterface;

import com.entity.GenderEnum;

public interface IUserListDto {

	public Long getUserId();
	
	public String getEmail();
	
	public String getUserName() ;
	
	public GenderEnum getGender();
	
}
