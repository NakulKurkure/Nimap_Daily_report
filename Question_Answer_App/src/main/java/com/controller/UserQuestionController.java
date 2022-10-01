package com.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AuthResponseDto;
import com.dto.ErrorResponseDto;
import com.dto.QuestionDto;
import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.dto.UserQuestionRequestDto;

import com.entity.UserQuestionEntity;

import com.serviceInterface.UserQuestionInterface;

@RestController
@RequestMapping("/userquestion")
public class UserQuestionController {

	@Autowired
	private UserQuestionInterface userQuestionInterface;
	
	@PostMapping
	public ResponseEntity<?> addUserQuestion(@RequestBody UserQuestionRequestDto userQuestionRequestDto)
	{
		try
		{
			userQuestionInterface.addUserQuestion(userQuestionRequestDto);
			return new ResponseEntity<>(new AuthResponseDto("Success", "SuccessFully Added Users to Question.", userQuestionRequestDto),HttpStatus.CREATED);	
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found", "Not Found UserId and Question Id"),HttpStatus.NO_CONTENT);
		}
	
		
	}
	
	@PutMapping
	public ResponseEntity<?> updateUserQuestion(@RequestBody UserQuestionRequestDto userQuestionRequestDto)
	{
		try
		{
			
			this.userQuestionInterface.updateUserQuestion(userQuestionRequestDto);
			return new ResponseEntity<>(new SuccessResponseDto("Successfully Updated..", "Updated..", userQuestionRequestDto),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Not Found UserId and RoleId..",HttpStatus.NOT_FOUND);
		}
		
	}
	
	@DeleteMapping
	public ResponseEntity<?> deleteUserQuestion(@RequestBody UserQuestionRequestDto userQuestionRequestDto)
	{
		try
		{
			this.userQuestionInterface.deleteUserQuestion(userQuestionRequestDto);
			return new ResponseEntity<>(new SuccessDto("Success", "Successfully Deleted.."),HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<>("Not Found UserId and RoleId..",HttpStatus.NOT_FOUND);
		}
		
	
		
	}
	
	
	@GetMapping
	public List<UserQuestionEntity>getAllUserQuestions()
	{
		
		return this.userQuestionInterface.getAllUserQuestions();
		
	}
	
	//Users can edit only his/her post, not someone else’s
//	@PutMapping("/{id}")
//	public ResponseEntity<?> updateQuestionByUserId(@RequestBody QuestionDto questionDto,@PathVariable Long id,HttpServletRequest request)
//	{
//		try
//		{
//			QuestionDto questionDto1=userQuestionInterface.updateQuestionByUserId(questionDto,id,request);
//			return new ResponseEntity<>(new AuthResponseDto("Updated..", "SuccessFully Updated..",questionDto1),HttpStatus.CREATED);
//		}catch(Exception e)
//		{
//		
//			return new ResponseEntity<>(new ErrorResponseDto("Not Found", "Not Found Question Id.."),HttpStatus.NO_CONTENT);
//		}
//		
//		
//		
//	}
	
	
}
