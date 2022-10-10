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

import com.dto.AnswerDto;
import com.dto.AuthResponseDto;
import com.dto.ErrorResponseDto;
//import com.dto.QuestionDto;
import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
//import com.entity.AnswerEntity;
import com.serviceInterface.AnswerInterface;
import com.serviceInterface.IAnswerListDto;
import com.serviceInterface.IQuestionListDto;


@RestController
@RequestMapping("/api/answer")
public class AnswerController {

	@Autowired
	private AnswerInterface answerInterface;
	
	@PostMapping
	public ResponseEntity<?> addAnswer(@RequestBody AnswerDto answerDto,HttpServletRequest request)
	{
		
		AnswerDto answerDto1=this.answerInterface.addAnswer(answerDto,request);
		return new ResponseEntity<>(new SuccessResponseDto("Success", "Successfully added Answer..", answerDto1),HttpStatus.ACCEPTED);
		
	}
	
	
	//Store a flag if the post and comments are edited.
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
	
	//Only Dto data will be displayed..
	@GetMapping("/{id}")
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
	
	
	

	//All Data is Displayed getById
	@GetMapping("/get/{id}")
	public ResponseEntity<?> getByAnswerIdGetAll(@PathVariable Long id,HttpServletRequest request)
	{
		try
		{
//			this.answerInterface.getByAnswerIdGetAll(id,request);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Successfully added Answer..", this.answerInterface.getByAnswerIdGetAll(id,request)),HttpStatus.ACCEPTED);

			
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found Answer Id", "Not Found"),HttpStatus.NOT_FOUND);

		}
		
	
	
	}
	
	//Only Admin and users who have commented have the permission to delete the comment.
	//	Eg. Suresh cannot delete Rohit’s comment. But Raj(Admin) can delete anyone’s comment.
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
	
	@GetMapping("/get")
	public ResponseEntity<?> GetAll()
	{
		try
		{

			return new ResponseEntity<>(new SuccessResponseDto("Success", "Successfully added Answer..", this.answerInterface.GetAll()),HttpStatus.ACCEPTED);

			
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorResponseDto("Not Found Answer Id", "Not Found"),HttpStatus.NOT_FOUND);
			
		}
		
	
	
	}
	

	//Users can edit only his/her post, not someone else’s
		@PutMapping("/edit/{id}")
		public ResponseEntity<?> updateQuestionByUserId(@RequestBody AnswerDto questionDto,@PathVariable Long id,HttpServletRequest request)
		{
			try
			{
				AnswerDto questionDto1=answerInterface.updateQuestionByUserId(questionDto,id,request);
				return new ResponseEntity<>(new AuthResponseDto("Updated..", "SuccessFully Updated..",questionDto1),HttpStatus.CREATED);
			}catch(Exception e)
			{
			
				return new ResponseEntity<>(new ErrorResponseDto(e.getMessage(), "Not Found Question Id.."),HttpStatus.NOT_FOUND);
			}
			
		}
		

		//List of AnswersByQuestionId
		@GetMapping("/getanswer/{id}")
		public ResponseEntity<?> getQuestionAndAnswerById(@PathVariable Long id,HttpServletRequest request)
		{
			try
			{
				
			List<IAnswerListDto> question=answerInterface.getQuestionAndAnswerById(id,request);
			return new ResponseEntity<>(new AuthResponseDto("Success", "Success", question),HttpStatus.OK);
			}catch(Exception e)
			{
				return new ResponseEntity<>(new ErrorResponseDto("not Found", "Not Found Question Id"),HttpStatus.BAD_REQUEST);
			}
			
			
		}

}
