package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ErrorDetailsDto;

import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.dto.UserDataDto;
import com.dto.UserDto;
import com.entity.User;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.UserServiceInterface;
import com.util.PasswordValidation;

@RestController
@RequestMapping("/api/user")
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@PostMapping
	public ResponseEntity<?> addUser(@RequestBody UserDto userDto)
	{
		String user=userDto.getEmail();
		
		User user1=userRepository.findByEmailContainingIgnoreCase(user);
		
		if(PasswordValidation.isValidforEmail(userDto.getEmail()) && PasswordValidation.isValid(userDto.getPassword()))
		{
			if(user1==null)
			{
			
			
			userServiceInterface.addUser(userDto);
			return new ResponseEntity<>(new SuccessDto("Success..", "SuccessFully Added User.."),HttpStatus.CREATED);
			}else
			{
				return new ResponseEntity<>(new ErrorDetailsDto(" Alredy Exists..", "Email and Password A"),HttpStatus.BAD_REQUEST);
			}
		}else
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid Format ..please Enter Valid Format..", "Email and Password Should be Minimum 8 to Maximum 30 Characters..."),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserById(@RequestBody UserDto userDto,@PathVariable Long id)
	{
		try
		{
			this.userServiceInterface.updateUserById(userDto,id);
			return new ResponseEntity<>(new SuccessDto("Success.", "SuccessFully Updated.."),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid..", "Invalid UserId.."),HttpStatus.BAD_REQUEST);

		}
		
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByUserId(@PathVariable Long id)
	{
		try
		{
			
			UserDataDto userDto=this.userServiceInterface.getByUserId(id);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", userDto),HttpStatus.ACCEPTED);	

		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid..", "Invalid UserId.."),HttpStatus.BAD_REQUEST);

		}
		
	}
	
	@DeleteMapping("/{id}")
	
	public ResponseEntity<?> deleteUserById(@PathVariable Long id)
	{
		try
		{
			
		this.userServiceInterface.deleteUserById(id);
			return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully Deleted User.."),HttpStatus.ACCEPTED);	

		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid..", "Invalid UserId.."),HttpStatus.BAD_REQUEST);

		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllUsers(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)

	{

		Page<IUserListDto> page=userServiceInterface.getAllUsers(search,pageNumber,pageSize);
			
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorDetailsDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);

	}

	
//	@PostMapping("/role")
//	public ResponseEntity<?> addUserRole(@RequestBody UserRoleDto userRoleDto)
//	{
//		
//		try
//		{
//			System.out.println("User"+userRoleDto.getUserId());
//			System.out.println("Role"+userRoleDto.getRoleId());
//		
//		User user=userRepository.findById(userRoleDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));
//		
//		Role role=roleRepository.findById(userRoleDto.getRoleId()).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId"));
//		
//		System.out.println("User"+user.getUserId());
//		System.out.println("Role"+role.getRoleId());
//		Long userId=userRoleDto.getUserId();
//		user.setUserId(userId);
//		
//		Long roleId=userRoleDto.getRoleId();
//		user.setUserId(roleId);
////
////		ArrayList<Long> list=new ArrayList<Long>();  
////		list.add(userId);
////		System.out.println("List"+list);
////		list.add(roleId);
////		System.out.println("List"+list);
//		
//		ArrayList<Long> list=new ArrayList<Long>();  
//		for(int i=0;i<list.size();i++)
//		{
//		
//			list.add(userId);
//			System.out.println("List"+list);
//			list.add(roleId);
//			System.out.println("List"+list);
//			
//		}
//		userRepository.save(list);
//		
//		return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully Deleted User.."),HttpStatus.ACCEPTED);	
//		}catch(Exception e)
//		{
//			return new ResponseEntity<>(new ErrorDetailsDto("Invalid Id", "Id is Invalid...."),HttpStatus.BAD_REQUEST);	
//
//		}
//		
//	}
	
	
}
