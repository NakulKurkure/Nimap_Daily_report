package com.job.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.job.Interceptor.AuthLogger;
import com.job.dto.AuthSuccessDto;
import com.job.dto.ErrorResponseDto;
import com.job.dto.SuccessResponseDto;
import com.job.dto.UserJobRequestDto;
import com.job.repository.UserJobRepository;
import com.job.serviceInterface.IListUserJobDto;
import com.job.serviceInterface.UserJobServiceInterface;

@RestController
@RequestMapping("/userjob")
public class UserJobController {
	@Autowired
	private UserJobServiceInterface userJobServiceInterface;

	@Autowired
	private UserJobRepository userJobRepository;

	@PreAuthorize("hasRole('userJobAdd')")
	@PostMapping
	public ResponseEntity<?> addUserJob(@Valid @RequestBody UserJobRequestDto userJobRequestDto,
			@RequestAttribute(AuthLogger.UserId) Long userId) {
		try {

			userJobServiceInterface.addUserJob(userJobRequestDto, userId);

			return new ResponseEntity<>(new SuccessResponseDto("Success..", "SuccessFully Added UserJobs.."),
					HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), e.getLocalizedMessage()),
					HttpStatus.BAD_REQUEST);

		}
	}

	// Admin
	@PreAuthorize("hasRole('getAlljobView')")
	@GetMapping("/getAll")
	public ResponseEntity<?> getAllUserJobs(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber, @RequestParam(defaultValue = "5") String pageSize,
			HttpServletRequest request, @RequestParam(defaultValue = "") String userId,
			@RequestParam(defaultValue = "") String jobId) {
		try {

			if (search.isBlank() && pageNumber.isBlank() && pageSize.isBlank() || (!jobId.isBlank())
					|| (!userId.isBlank())) {
				Page<IListUserJobDto> page = userJobServiceInterface.getAllUserJob(search, pageNumber, pageSize,
						request, userId, jobId);
				return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", page.getContent()),
						HttpStatus.ACCEPTED);

			} else {
				List<IListUserJobDto> userDto = userJobRepository.findAllList(IListUserJobDto.class);
				return new ResponseEntity<>(new AuthSuccessDto("Success", "Success", userDto), HttpStatus.ACCEPTED);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), e.getLocalizedMessage()),
					HttpStatus.NOT_FOUND);
		}

	}

}
