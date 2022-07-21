package com.springrestapi.service;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.Entity;
import com.springrestapi.page.pagination;
import com.springrestapi.repo.Entity_repo;

@Service
public class Entity_service {

	@Autowired
	private Entity_repo er;
	
	public Entity add(Entity e)
	{
		return er.save(e);
	}

	
//	public List<Entity> get() {
//		
//		return this.er.findAll();
//		
//	}


	public Entity getid(long id) {
		
		return er.findById(id).get();
	}


	public Entity update(Entity e) {
		
		return er.save(e);
	}


	public String deleteEntity(long id) {
		
		//Fetch the record from the db
		Entity entity = er.findByIdAndIsActiveTrue(id);
		
		//Update the is_active attr to false
		entity.setIsActive(false);
		
		//Save the record
		er.save(entity);
		
		return "deleted Successfully...";
	}


	public Page<Entity> getProducts(String search, String pageNumber, String pageSize) {
		// TODO Auto-generated method stub
		
//		Pageable is an interface defined by Spring, which holds a PageRequest.
//		/Abstract interface for pagination information
		Pageable pagable=new pagination().getPagination(pageNumber,pageSize);
	
				if((search=="")|| (search==null)|| (search.length()==0))
				{
					return er.findByOrderByIdAndIsActiveTrue(pagable,Entity.class);
				}
				else
				{
					return er.findByName(search,pagable,Entity.class);
				}
		
		
	}
	
}
