package com.controller;



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

import com.dto.AnswerDto;
import com.dto.ErrorResponseDto;
import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.serviceInterface.AnswerInterface;
import com.serviceInterface.IAnswerListDto;


@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerInterface answerInterface;
	
	@PostMapping
	public ResponseEntity<?> addAnswer(@RequestBody AnswerDto answerDto,HttpServletRequest request)
	{
		
		AnswerDto answerDto1=this.answerInterface.addAnswer(answerDto,request);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Successfully added Answer..", answerDto1),HttpStatus.ACCEPTED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateAnswer(@RequestBody AnswerDto answerDto,@PathVariable Long id,HttpServletRequest request)
	{
		
		try
		{
			AnswerDto answerDto1=this.answerInterface.updatedAnswer(answerDto,id,request);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Successfully added Answer..", answerDto1),HttpStatus.ACCEPTED);	
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found Answer Id", "Not Found"),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getByAnswerId(@PathVariable Long id,HttpServletRequest request)
	{
		try
		{
			AnswerDto answerDto=this.answerInterface.getByAnswerId(id,request);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Successfully added Answer..", answerDto),HttpStatus.ACCEPTED);

			
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found Answer Id", "Not Found"),HttpStatus.NOT_FOUND);

		}
		
	
	}
	
	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteAnswerById( @PathVariable Long id,HttpServletRequest request)
	{
		
		try
		{
			this.answerInterface.deleteAnswerById(id,request);
			return new ResponseEntity<>(new SuccessDto("Success", "Successfully deleted.."),HttpStatus.ACCEPTED);
			
		}catch(Exception e)
		{
			e.printStackTrace();
			return new ResponseEntity<>(new ErrorResponseDto("Not Found Answer Id", "Not Found"),HttpStatus.NOT_FOUND);

		}
		
		
	}
	
	
	@GetMapping
	public ResponseEntity<?> getAllAnswers(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)
	{
		
		Page<IAnswerListDto> page= this.answerInterface.getAllAnswers(search,pageNumber,pageSize);
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorResponseDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);
		
		
		
	}
	
	
	

}
