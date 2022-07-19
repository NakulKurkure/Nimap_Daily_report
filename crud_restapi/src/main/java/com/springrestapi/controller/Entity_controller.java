package com.springrestapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springrestapi.entity.Entity;
import com.springrestapi.service.Entity_service;

@RestController
@RequestMapping("/api")
public class Entity_controller {

	@Autowired
	private Entity_service es;
	
	@PostMapping("/add")
	public Entity add(@RequestBody Entity e)
	{
		
		return this.es.add(e);
	}
	
	@GetMapping("/get")
	public List<Entity> get()
	{
		return this.es.get();
	}
	
	@GetMapping("/get/{id}")
	public Entity getid(@PathVariable long id)
	{
		return this.es.getid(id);
	}
	
	@PutMapping("/put/{id}")
	public Entity update(@PathVariable long id,@RequestBody Entity e)
	{
		e.setEid(id);
		return this.es.update(e);
	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable long id)
	{
		return es.delete(id);
	}
	

	
}
