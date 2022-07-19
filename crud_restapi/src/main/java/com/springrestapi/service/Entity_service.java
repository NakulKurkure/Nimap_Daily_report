package com.springrestapi.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.Entity;
import com.springrestapi.repo.Entity_repo;

@Service
public class Entity_service {

	@Autowired
	private Entity_repo er;
	
	public Entity add(Entity e)
	{
		return er.save(e);
	}

	
	public List<Entity> get() {
		
		return this.er.findAll();
		
	}


	public Entity getid(long id) {
		
		return er.findById(id).get();
	}


	public Entity update(Entity e) {
		
		return er.save(e);
	}


	public String delete(long id) {
		
		er.deleteById(id);
		return "deleted Successfully...";
	}
	
}
