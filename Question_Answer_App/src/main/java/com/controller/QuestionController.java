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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dto.AuthResponseDto;
import com.dto.ErrorResponseDto;
import com.dto.QuestionDataDto;
import com.dto.QuestionDto;
import com.dto.SuccessDto;

import com.serviceInterface.IQuestionListDto;
import com.serviceInterface.QuestionServiceInterface;

@RestController
@RequestMapping("/api/question")
public class QuestionController {

	@Autowired
	private QuestionServiceInterface questionServiceInterface;
	
	
	//Users have the functionality to save a post as a draft.
	//Users can create a scheduled post where he/she can add the date when to publish a post. 
	@PostMapping
	public ResponseEntity<?> addQuestions(@RequestBody QuestionDto questionDto,HttpServletRequest request)
	{
		try
		{
			questionServiceInterface.addQuestions(questionDto,request);
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
			QuestionDataDto questionDataDto=this.questionServiceInterface.getQuestion(id);
			return new ResponseEntity<>(new AuthResponseDto("Success", "Success", questionDataDto),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto(" Not Found..", "Question Id is Not Found.."),HttpStatus.NO_CONTENT);
		}
		
		
	}
	
	//Store a flag if the post and comments are edited.
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
	
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllQuestions(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize
			)
	{
		
		Page<IQuestionListDto> page=questionServiceInterface.getAllQuestions(search,pageNumber,pageSize);
		
		if(page.getTotalElements()!=0)
			
		{
			return new ResponseEntity<>(new AuthResponseDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		
		return new ResponseEntity<>(new ErrorResponseDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);
	}
	
	
	//AllDraftTrueData QuestionsFetched..
	@GetMapping("/draft")
	public ResponseEntity<?> getAllDraft()
	{

		List<Object> questionEntities= this.questionServiceInterface.getAllDraftQuestions();

		return new ResponseEntity<>(new AuthResponseDto("Success", "Success", questionEntities),HttpStatus.OK);
		
		
	}
	
	//Only Admin fetch all Users and Questions
	@GetMapping("/admin/{id}")
	public ResponseEntity<?> getAllAnswers(@PathVariable long id,HttpServletRequest request)
	{
		try
		{
			
		
		List<Object> list= questionServiceInterface.getAllQuestionsByUserId(id,request);
		
		return new ResponseEntity<>(new AuthResponseDto("Success", "Success",list),HttpStatus.ACCEPTED);
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Invalid Id", "userId is Not Found"),HttpStatus.NOT_FOUND);
		}
	}

	

}
