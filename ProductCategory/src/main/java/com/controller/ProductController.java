package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dto.ErrorDetailsDto;
import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.dto.ProductDto;
import com.serviceInterface.ProductServiceInterface;

@RestController
//If you want to specify request URI path on controller
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductServiceInterface productServiceInterface;
	
	@PostMapping
	public ResponseEntity<?> addproduct(@RequestBody ProductDto productDto)
	{
		productServiceInterface.addProduct(productDto);
		
		return new ResponseEntity<>(new SuccessDto("Success..", "Succesfully Added products.."),HttpStatus.CREATED);
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProductById(@RequestBody ProductDto productDto,@PathVariable Long id)
	{
		try
		{
			ProductDto productDto1= productServiceInterface.updateProductById(productDto,id);
			
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", productDto1),HttpStatus.ACCEPTED);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid..", "Invalid productId"),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id){
		
		productServiceInterface.getProductById(id);
		return null;
		
	}
	
	
}
