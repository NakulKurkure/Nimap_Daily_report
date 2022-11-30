package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job.dto.AuthSuccessDto;
import com.job.dto.ErrorResponseDto;
import com.job.dto.SuccessResponseDto;
import com.job.dto.UserDataDto;
import com.job.dto.UserDto;
import com.job.serviceInterface.UserServiceInterface;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserServiceInterface userServiceInterface;

	//Admin
	@PreAuthorize("hasRole('UserUpdate')")
	@PutMapping("/{id}")
	public ResponseEntity<?> updateUserByUserId(@RequestBody UserDto userDto, @PathVariable Long id) {
		try {
			userServiceInterface.updateUser(userDto, id);
			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Updated User.."),
					HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("Enter Valid UserId..", "Please Enter Valid UserId"),
					HttpStatus.BAD_REQUEST);
		}
		
	}

	@PreAuthorize("hasRole('UserByIdView')")
	@GetMapping("/{id}")
	public ResponseEntity<?> getByUserId(@PathVariable Long id) {

		try {
			UserDataDto user = userServiceInterface.getByUserId(id);
			return new ResponseEntity<>(new AuthSuccessDto("Success..", "SuccessFully Updated User..", user),
					HttpStatus.ACCEPTED);

		} catch (Exception e) {

			return new ResponseEntity<>(new ErrorResponseDto("Invalid UserId", "Please Enter Valid UserId"),
					HttpStatus.NOT_FOUND);
		}

	}

	@PreAuthorize("hasRole('UserDel')")
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByUserId(@PathVariable Long id) {
		try {
			userServiceInterface.deleteByUserId(id);

			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SucessFully Deleted User..."),
					HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("Invalid UserId..", "Please Enter Valid UserId..."),
					HttpStatus.NOT_FOUND);
		}

	}

	@PreAuthorize("hasRole('UserView')")
	@GetMapping
	public ResponseEntity<?> getAllUsers(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber, @RequestParam(defaultValue = "5") String pageSize) {

		Page<com.job.serviceInterface.IListUsersDto> page = userServiceInterface.getAllUsers(search, pageNumber,
				pageSize);

		if (page.getTotalElements() != 0) {
			return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", page.getContent()), HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorResponseDto(" No Records Avaliable..", "Not Avaliable.."),
				HttpStatus.BAD_REQUEST);

	}

}
