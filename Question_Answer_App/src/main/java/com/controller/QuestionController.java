package com.controller;

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
import com.entity.QuestionEntity;
import com.serviceInterface.QuestionServiceInterface;

@RestController
@RequestMapping("/question")
public class QuestionController {

	@Autowired
	private QuestionServiceInterface questionServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addQuestions(@RequestBody QuestionDto questionDto)
	{
		try
		{
			questionServiceInterface.addQuestions(questionDto);
			return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully Added Question"),HttpStatus.CREATED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Added..", "Not Added.."),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByQuestionId(@PathVariable Long id)
	{
		try
		{
			QuestionDto questionDto=this.questionServiceInterface.getQuestion(id);
			return new ResponseEntity<>(new AuthResponseDto("Success", "Success", questionDto),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(" Not Found..", "Question Id is Not Found.."),HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateQuestionById(@RequestBody QuestionDto questionDto,@PathVariable Long id)
	{
		try
		{
			QuestionDto questionDto1=questionServiceInterface.updateQuestion(questionDto,id);
			return new ResponseEntity<>(new AuthResponseDto("Updated..", "SuccessFully Updated..",questionDto1),HttpStatus.CREATED);
		}catch(Exception e)
		{
		
			return new ResponseEntity<>(new ErrorResponseDto("Not Found", "Not Found Question Id.."),HttpStatus.NO_CONTENT);
		}
		
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteQuestionById(@PathVariable Long id)
	{
		try
		{
			
			questionServiceInterface.deleteQuestionById(id);
			return new ResponseEntity<>(new SuccessDto("Success..", "Successfully Deleted.."),HttpStatus.CREATED);
		}catch(Exception e)
		{
		
			return new ResponseEntity<>(new ErrorResponseDto("Not Found", "Not Found Question Id.."),HttpStatus.NO_CONTENT);
		}
		return null;
		
	}
}
