package com.serviceInterface;

import java.util.List;

import org.springframework.data.domain.Page;

import com.dto.UserDataDto;
import com.dto.UserDto;

public interface UserServiceInterface {

	void addUser(UserDto userDto);

	void updateUserById(UserDto userDto, Long id);

	List<IUserListDto> getByUserId(Long id);

	void deleteUserById(Long id);

	Page<IUserListDto> getAllUsers(String search, String pageNumber, String pageSize);

}
