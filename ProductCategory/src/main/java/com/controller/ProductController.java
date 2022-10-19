package com.controller;

import java.util.List;

import javax.validation.Valid;

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

import com.dto.ErrorDetailsDto;

import com.dto.SuccessDto;
import com.dto.SuccessResponseDto;
import com.entity.Product;

import com.repository.ProductRepository;
import com.dto.ProductDto;

import com.serviceInterface.IListProductDto;
import com.serviceInterface.ProductServiceInterface;

@RestController
//If you want to specify request URI path on controller
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductServiceInterface productServiceInterface;
	
	@Autowired
	private ProductRepository productRepository;

	@PostMapping
	public ResponseEntity<?> addproduct(@Valid @RequestBody ProductDto productDto)
	{
		String product1=productDto.getProduct();
		
		Product products= productRepository.findByProductContainingIgnoreCase(product1);
		
		if(products==null)
		{

			productServiceInterface.addProduct(productDto);
			
			return new ResponseEntity<>(new SuccessDto("Success..", "Succesfully Added products.."),HttpStatus.CREATED);	
		}else
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Exist..", "Alredy Exists In DataBase.."),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> updateProductById(@RequestBody ProductDto productDto,@PathVariable Long id)
	{
		try
		{
			 productServiceInterface.updateProductById(productDto,id);
			
			return new ResponseEntity<>(new SuccessDto("Success", "SuccessFully Updated.."),HttpStatus.ACCEPTED);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid..", "Invalid productId"),HttpStatus.BAD_REQUEST);
		}
		
		
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id){
		try
		{
			System.out.println("Id"+id);
			List<IListProductDto> list= productServiceInterface.getProductById(id);
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", list),HttpStatus.ACCEPTED);	
		}catch(Exception e)
		{
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid..", "Invalid productId"),HttpStatus.NOT_FOUND);

		}
		
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteByProductId(@PathVariable Long id)
	{
		try
		{
			productServiceInterface.deleteByProductId(id);
			return new ResponseEntity<>(new SuccessDto("Success..", "Succesfully Deleted products.."),HttpStatus.CREATED);

		}catch (Exception e) {
			return new ResponseEntity<>(new ErrorDetailsDto("Invalid..", "Invalid productId"),HttpStatus.NOT_FOUND);

		}
		
		
		
	}
	
	@GetMapping
	public ResponseEntity<?> getAllCategory(
			@RequestParam(defaultValue = "") String search,@RequestParam (defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize
			)
	{
		
		Page<IListProductDto> page= productServiceInterface.getAllProduct(search,pageNumber,pageSize);
		if(page.getTotalElements()!=0)
		{
			return new ResponseEntity<>(new SuccessResponseDto("Success", "Success", page.getContent()),HttpStatus.OK);
		}
		return new ResponseEntity<>(new ErrorDetailsDto(" No Records Avaliable..", "Not Avaliable.."),HttpStatus.BAD_REQUEST);

		
	}
	
	
}
