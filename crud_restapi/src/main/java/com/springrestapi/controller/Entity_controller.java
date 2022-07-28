package com.springrestapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.dto.EntityDto;
import com.springrestapi.entity.Entity;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.exception.ResourseNotFoundException;
import com.springrestapi.repo.Entity_repo;
import com.springrestapi.service.Entity_service;

@RestController
//@RequestMapping Annotation which is used to map HTTP requests to handler methods of MVC and REST controllers.
@RequestMapping("/entity")
public class Entity_controller {

@Autowired
	private Entity_service entity_service;

@Autowired
private Entity_repo entity_repository;

	@PostMapping
	public ResponseEntity<?> add(@RequestBody EntityDto entityDto)
	{
		EntityDto entitydto=this.entity_service.add(entityDto);

		return new ResponseEntity<>(new SuccessResponseDto("success", "success", entitydto),HttpStatus.ACCEPTED);
//		return this.entity_service.add(entitydto);
		
	}

	@GetMapping
	//ResponseEntity represents the whole HTTP response: status code, headers, and body.
	public ResponseEntity<?> getProducts(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)
	{
		//ResponseEntity is meant to represent the entire HTTP response
		Page<?> entity= entity_service.getProducts(search,pageNumber,pageSize);
		if(entity.getTotalElements()!=0)
		{
			return new ResponseEntity<>(entity.getContent(), HttpStatus.OK);
		}
		return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
	}
	
	//A page is a sublist of a list of objects. It allows gain information about the position of it in the containing entire list.
//	@GetMapping("/{id}")
//	public EntityDto getid(@PathVariable Integer id)
//	{
//		
//		return this.entity_service.getid(id);
//		//this.entity_repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("NOt found"+id));
//	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getByid(@PathVariable Integer id)
	{
//	 this.entity_service.getid(id);
		return new ResponseEntity<>(new SuccessResponseDto("Success","success",entity_service.getid(id)),HttpStatus.OK);
//		return new ResponseEntity<>(entiy,HttpStatus.CREATED);
		
		
//		return this.entity_repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("NOt found"+id));
	}
	
	
	
//	@PutMapping("/{id}")
//	public EntityDto update(@PathVariable Integer id,@RequestBody EntityDto e)
//	{
//		e.setId(id);
////		EntityDto entity= this.entity_service.update(e,id);
//		
//		return entity;
//				
//	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestBody EntityDto e,@PathVariable Integer id)
	{
		
		EntityDto entitydto=entity_service.update(e, id);
		
		return new ResponseEntity<>(new SuccessResponseDto("S","ok", entitydto),HttpStatus.ACCEPTED);
//		this ResponseEntity<>(new SuccessResponseDto("success","success",entity_service.update(e,id)));
		
//		return entity;
				
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id)
	{
		this.entity_service.deleteEntity(id);
		
	}

	


}
