package com.serviceimpl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dto.UserDataDto;
import com.dto.UserDto;
import com.entity.AnswerEntity;
import com.entity.QuestionEntity;
import com.entity.RoleEntity;
import com.entity.UserEntity;
import com.entity.UserRoleEntity;
import com.exception.ResourceNotFoundException;
import com.repository.AnswerRepository;
import com.repository.QuestionRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.repository.UserRoleRepository;
import com.security.JwtTokenUtil;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.UserServiceInterface;
import com.util.Pagination;

@Service
public class UserServiceImpl implements UserServiceInterface{

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	
	@Override
	public void addUser(UserDto userDto) {
		
		UserEntity userEntity1=new UserEntity();;
		userEntity1.setEmail(userDto.getEmail());
		userEntity1.setGender(userDto.getGender());
		userEntity1.setUsername(userDto.getUsername());
		userEntity1.setPassword(passwordEncoder.encode(userDto.getPassword()));
		
		userRepository.save(userEntity1);
		
	
		
	}

	@Override
	public UserDataDto getUserId(Long id) {
		
		UserEntity userEntity=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found User Id"));
		System.out.println("In 1"+id);
		
		UserDataDto userDataDto=new UserDataDto();
		userDataDto.setUsername(userEntity.getUsername());
		userDataDto.setGender(userEntity.getGender());
		userDataDto.setEmail(userEntity.getEmail());
		
		return userDataDto;
	}

	@Override
	public UserDto updateUser(UserDto userDto, Long id) {
		
		UserEntity userEntity=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found User Id"));
		
		
		userEntity.setEmail(userDto.getEmail());
		userEntity.setGender(userDto.getGender());
		userEntity.setUsername(userDto.getUsername());
		String password=passwordEncoder.encode(userDto.getPassword());
		userEntity.setPassword(password);
		
		userRepository.save(userEntity);
		return userDto;
	}

	@Override
	public void deleteUserId(Long id) {


		UserEntity userEntity=userRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Not Found User Id"));
	
		userRepository.deleteById(id);
	}

	@Override
	public Page<IUserListDto> getAllUsers(String search, String pageNumber, String pageSize) {
		// TODO Auto-generated method stub
		
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return userRepository.findByOrderById(pagable,IUserListDto.class);
		}
		else
		{
			return  userRepository.findByUsername(search,pagable,IUserListDto.class);
		}
		
	}

	@Override
	public UserDataDto adminBasedOnUser(Long id,HttpServletRequest request) {
		
		System.out.println("Id"+id);
		UserEntity userEntity1=userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));
		
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email 
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
//		//check on repo.
		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		
		Long user_id=userEntity.getId();
		System.out.println("userId"+user_id);
		
		UserRoleEntity userRoleEntity= userRoleRepository.findByUserById(user_id);
		System.out.println("userRoleEntity1111");
	
		Long roleEntityId=userRoleEntity.getPk().getRoles().getId();
		System.out.println(""+userRoleEntity.getPk().getRoles().getId());
		
		RoleEntity roleEntity1=roleRepository.findById(roleEntityId).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId.."));

		
		String roleName=roleEntity1.getRoleName();
		
		if(roleName.equals("Admin"))
			{
			
			UserDataDto users=new UserDataDto();
			users.setUsername(userEntity1.getUsername());
			users.setGender(userEntity1.getGender());
			users.setEmail(userEntity1.getEmail());
			
			
			System.out.println("userId"+user_id);
			
			return users;
			}else
			{
				throw new ResourceNotFoundException("Not Found UserId..");
				
			}
		
		
	}

	
	

}
