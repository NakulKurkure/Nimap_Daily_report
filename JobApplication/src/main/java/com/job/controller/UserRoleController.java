package com.job.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job.dto.AuthSuccessDto;
import com.job.dto.ErrorResponseDto;
import com.job.dto.SuccessResponseDto;
import com.job.dto.UserRoleRequestDto;
import com.job.repository.UserRoleRepository;
import com.job.serviceInterface.ILIstUserDto;
import com.job.serviceInterface.UserRoleServiceInterface;

@RestController
@RequestMapping("/userrole")
public class UserRoleController {

	@Autowired
	private UserRoleServiceInterface userRoleServiceInterface;

	@Autowired
	private UserRoleRepository userRoleRepository;

	// Admin..

	@PreAuthorize("hasRole('UserRoleAdd')")
	@PostMapping
	public ResponseEntity<?> addUserRole(@RequestBody UserRoleRequestDto userRoleRequestDto) {

		userRoleServiceInterface.addUserRole(userRoleRequestDto);

		return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added UserRoles.."),
				HttpStatus.CREATED);
	}

	@PreAuthorize("hasRole('UserRoleDel')")
	@DeleteMapping
	public ResponseEntity<?> deleteUserRole(@RequestBody UserRoleRequestDto userRoleRequestDto) {

		try {

			userRoleServiceInterface.deleteUserRole(userRoleRequestDto);

			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Deleted UserRoles..."),
					HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("Invalid..", "Invalid UserId and Role Id..."),
					HttpStatus.BAD_REQUEST);

		}
	}

	@PreAuthorize("hasRole('UserRoleView')")
	@GetMapping("/getAll")
	public ResponseEntity<?> getAlluserRoles(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber, @RequestParam(defaultValue = "5") String pageSize,
			@RequestParam(defaultValue = "") String userId, @RequestParam(defaultValue = "") String roleId) {

		Page<ILIstUserDto> page = this.userRoleServiceInterface.getAllUserRoles(search, pageNumber, pageSize, userId,
				roleId);
		System.out.println("Page" + page.get());
		return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", page.getContent()), HttpStatus.ACCEPTED);

	}

	@PreAuthorize("hasRole('UserRoleUpdate')")
	@PutMapping
	public ResponseEntity<?> updateUserRole(@RequestBody UserRoleRequestDto userRoleRequestDto) {

		try {

			userRoleServiceInterface.updateUserRole(userRoleRequestDto);

			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Updated UserRoles..."),
					HttpStatus.ACCEPTED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto("Invalid..", "Invalid UserId and Role Id..."),
					HttpStatus.BAD_REQUEST);

		}
	}

}