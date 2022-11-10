package com.job.serviceInterface;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.job.dto.UserDataDto;
import com.job.dto.UserDto;


public interface UserServiceInterface {

	void addUser(UserDto userDto);

	void updateUser(UserDto userDto, Long id);

	UserDataDto getByUserId(Long id);

	void deleteByUserId(Long id,HttpServletRequest request);

	Page<ILIstUserDto> getAllUsers(String search, String pageNumber, String pageSize);

}
