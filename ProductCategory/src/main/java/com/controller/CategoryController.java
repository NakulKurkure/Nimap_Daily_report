package com.controller;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.dto.CategoryDto;
import com.dto.ErrorDetailsDto;

import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.serviceInterface.CategoryServiceInterface;
import com.serviceInterface.ICategoryListDto;

@RestController
//Annotation for mapping web requests 
@RequestMapping("/api/category")
public class CategoryController {

	@Autowired
	private CategoryServiceInterface categoryServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addCategory(@Valid @RequestBody CategoryDto categoryDto)
	{
		
		String category= categoryDto.getCategory();
		
		if(category==null)
		{
			categoryServiceInterface.addCategory(categoryDto);
			
			return new ResponseEntity<>(new SuccessDto("Success", "Successfully Added Category"),HttpStatus.CREATED);
			
		}else
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Exist ..", "Category Alredy Exists."),HttpStatus.BAD_REQUEST);	

		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateCategory(@PathVariable long id, @RequestBody CategoryDto categoryDto)
	{
		try
		{
			CategoryDto categoryDto2= categoryServiceInterface.updateCategory(id,categoryDto);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success Updated Category..", categoryDto2),HttpStatus.ACCEPTED);
				
		}catch(Exception e)
		{
			
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid ..", "invalid CategoryId"),HttpStatus.BAD_REQUEST);	
		}
		
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getCategoryById(@PathVariable Long id)
	{
		try
		{
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", this.categoryServiceInterface.getCategoryById(id)),HttpStatus.ACCEPTED);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid", "Invalid CategoryId"),HttpStatus.NOT_FOUND);	
		}
		
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategoryById(@PathVariable Long id)
	{
		try
		{
			System.out.println("Id is "+id);
			categoryServiceInterface.deleteCategoryById(id);
			
			return new ResponseEntity<>(new SuccessDto("Success", "Successfully Deleted Category.."),HttpStatus.ACCEPTED);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid. ", "Invalid CategoryId.."),HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCategory(
			@RequestParam(defaultValue = "") String search
			,@RequestParam (defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize
			)
	{
		
		Page<ICategoryListDto> page= categoryServiceInterface.getAllCategory(search,pageNumber,pageSize);
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorDetailsDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);

		
	}
	
	
}
