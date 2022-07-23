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
import com.springrestapi.exception.ResourseNotFoundException;
import com.springrestapi.repo.Entity_repo;
import com.springrestapi.service.Entity_service;

@RestController
//@RequestMapping Annotation which is used to map HTTP requests to handler methods of MVC and REST controllers.
@RequestMapping("/entity")
public class Entity_controller {

@Autowired
	private Entity_service es;

@Autowired
private Entity_repo er;

	@PostMapping
	public Entity add(@RequestBody Entity e)
	{

		return this.es.add(e);
		
	}

	@GetMapping
	//ResponseEntity represents the whole HTTP response: status code, headers, and body.
	public ResponseEntity<?> getProducts(@RequestParam(defaultValue = "") String search,
			@RequestParam(defaultValue = "1") String pageNumber,
			@RequestParam(defaultValue = "5") String pageSize)
	{
		//ResponseEntity is meant to represent the entire HTTP response
		Page<?> entity= es.getProducts(search,pageNumber,pageSize);
		if(entity.getTotalElements()!=0)
		{
			return new ResponseEntity<>(entity.getContent(), HttpStatus.OK);
		}
		return new ResponseEntity<>("fail",HttpStatus.BAD_REQUEST);
	}
	//A page is a sublist of a list of objects. It allows gain information about the position of it in the containing entire list.
	@GetMapping("/{id}")
	public Entity getid(@PathVariable Integer id)
	{
		return this.er.findById(id).orElseThrow(() -> new ResourseNotFoundException("NOt found"));
//				.orElseThrow(( )->new ResourseNotFoundException("Not Found related to id"+id));
	}

	@PutMapping("/{id}")
	public Entity update(@PathVariable Integer id,@RequestBody Entity e)
	{
		e.setId(id);
		return this.es.update(e);
	}


	@DeleteMapping("/{id}")
	public void delete(@PathVariable Integer id)
	{
		
		 es.deleteEntity(id);
	}

	


}
