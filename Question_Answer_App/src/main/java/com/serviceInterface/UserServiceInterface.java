package com.serviceInterface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.dto.UserDataDto;
import com.dto.UserDto;

public interface UserServiceInterface {

	void addUser(UserDto userDto);

	UserDataDto getUserId(Long id);

	UserDto updateUser(UserDto userDto, Long id);

	void deleteUserId(Long id);

	Page<IUserListDto> getAllUsers(String search, String pageNumber, String pageSize);

	UserDataDto adminBasedOnUser(Long id,HttpServletRequest request);
	



	

	
}
