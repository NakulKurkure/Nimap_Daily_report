package com.job.serviceInterface;

import org.springframework.data.domain.Page;

import com.job.dto.UserDataDto;
import com.job.dto.UserDto;


public interface UserServiceInterface {

	void addUser(UserDto userDto);

	void updateUser(UserDto userDto, Long id);

	UserDataDto getByUserId(Long id);

	void deleteByUserId(Long id);

	Page<IListUsersDto> getAllUsers(String search, String pageNumber, String pageSize);
}
