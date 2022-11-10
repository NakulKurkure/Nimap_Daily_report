package com.job.serviceImpl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.job.dto.UserDataDto;
import com.job.dto.UserDto;
import com.job.entity.User;
import com.job.exception.ResourceNotFoundException;
import com.job.repository.UserRepository;
import com.job.serviceInterface.ILIstUserDto;
import com.job.serviceInterface.IUserListDto;
import com.job.serviceInterface.UserServiceInterface;


@Service
public class UserServiceImpl implements UserServiceInterface{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void addUser(UserDto userDto) {
		
		User user=new User();
		user.setEmail(userDto.getEmail());
		user.setUserName(userDto.getUserName());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		userRepository.save(user);
		
		}

	@Override
	public void updateUser(UserDto userDto,Long id) {
		
		User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId.."));
		
		user.setEmail(userDto.getEmail());
		user.setPassword(passwordEncoder.encode(userDto.getPassword()));
		user.setUserName(userDto.getUserName());
			
		userRepository.save(user);
		
	}

	@Override
	public UserDataDto getByUserId(Long id) {
	
		UserDataDto userDto=new UserDataDto();
		User user=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId.."));
		userDto.setUserId(user.getUserId());
		userDto.setEmail(user.getEmail());
		userDto.setUserName(user.getUserName());
		
		return userDto;
	}

	@Override
	public void deleteByUserId(Long id,HttpServletRequest request) {
		
		userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));
		
		
		userRepository.deleteById(id);
		
	}

	@Override
	public Page<ILIstUserDto> getAllUsers(String search, String pageNumber, String pageSize) {
		Pageable pagable=new com.job.util.Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return userRepository.findByOrderByUserIdDesc(pagable,ILIstUserDto.class);
		}
		else
		{
			return  userRepository.findByUserName(search,pagable,ILIstUserDto.class);
		}
	
	}

	
	
	
}