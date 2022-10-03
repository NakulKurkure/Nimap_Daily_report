package com.controller;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AuthResponseDto;
import com.dto.ErrorResponseDto;
import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.dto.UserDataDto;
import com.dto.UserDto;
import com.entity.UserEntity;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.UserServiceInterface;

//For connecting any hibernate application with the database - dialect

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;
	
	@GetMapping("/user/{id}")
	public ResponseEntity<?> getByUserId(@PathVariable Long id)
	{
		try
		{

			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", this.userServiceInterface.getUserId(id)),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Please Enter Valid Email Id..", "Wrong Email Id.."),HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateDataByUserId(@RequestBody UserDto userDto,@PathVariable Long id)
	{
		try
		{
			
		
		UserDto userDto1=this.userServiceInterface.updateUser(userDto,id);
		return new ResponseEntity<>(new SuccessDto("Data Updated Successfully", "Successfully Updated"),HttpStatus.OK);
	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Please Enter Valid UserId..", "Not Updated Data.."),HttpStatus.NOT_FOUND);
		}
			
	}
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteUserById(@PathVariable Long id)
	{
		try
		{
			
		
		this.userServiceInterface.deleteUserId(id);
			return new ResponseEntity<>(new SuccessDto("Data Deleted SuccessFully", "Successfully"),HttpStatus.ACCEPTED); 
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Please Enter Valid UserId...", "Not Found UserId."),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	//@RequestParam is a Spring annotation used to bind a web request parameter to a method parameter.
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
		return new ResponseEntity<>(new ErrorResponseDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);
		
	}

	//AdminToken can access only User..
	@GetMapping("/get/{id}")
	public ResponseEntity<?> adminBasedOnUser(@PathVariable Long id,HttpServletRequest request)
	{
		try
		{
			
			System.out.println("Id"+id);
		UserDataDto userDataDto= this.userServiceInterface.adminBasedOnUser(id,request);	
		return new ResponseEntity<>(new AuthResponseDto("Success", "Success", userDataDto),HttpStatus.OK);
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "Please Enter Valid UserId.."),HttpStatus.NOT_FOUND);
		}
		
		
	}

}


