package com.springrestapi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.Entity;
import com.springrestapi.page.pagination;
import com.springrestapi.repo.Entity_repo;

@Service
//@Transactional(readOnly = true)
public class Entity_service {

	@Autowired
	private Entity_repo er;

	

	public Entity add(Entity entity)
	{
		
		return er.save(entity);
	
	}


//	public List<Entity> get() {
//
//		return this.er.findAll();
//
//	}


	public Entity getid(Integer id) {

		return er.findById(id).get();
	}


	public Entity update(Entity e) {

		return er.save(e);
	}


	public void deleteEntity(Integer id) {

				
//			Fetch the record from the db
			Entity entity = er.getById(id);
			
			
			//Update the is_active attr to false
			entity.setIsActive(false);

			//Save the record
			this.er.save(entity);
		
		//only show for user is data deleted but actual data is not deleted form database.
//            this.er.deleteById(id);

	}


	public Page<?> getProducts(String search, String pageNumber, String pageSize) {
		// TODO Auto-generated method stub

//		Pageable is an Integeregererface defined by Spring, which holds a PageRequest.
//		/Abstract Integeregererface for pagination information
		Pageable pagable=new pagination().getPagination(pageNumber,pageSize);

				if((search=="")|| (search==null)|| (search.length()==0))
				{
					return er.getAll(pagable,Entity.class);
				}
				else
				{
					return er.findByName(search,pagable,Entity.class);
				}


	}
	
	
	


}
