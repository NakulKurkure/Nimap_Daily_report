package com.serviceInterface;

import org.springframework.data.domain.Page;

import com.dto.UserDataDto;
import com.dto.UserDto;

public interface UserServiceInterface {

	void addUser(UserDto userDto);

	void updateUserById(UserDto userDto, Long id);

	UserDataDto getByUserId(Long id);

	void deleteUserById(Long id);

	Page<IUserListDto> getAllUsers(String search, String pageNumber, String pageSize);

}
