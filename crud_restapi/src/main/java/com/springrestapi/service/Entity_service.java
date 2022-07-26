package com.springrestapi.service;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.springrestapi.dto.EntityDto;
import com.springrestapi.entity.Entity;
import com.springrestapi.errordto.SuccessResponseDto;
import com.springrestapi.exception.ResourseNotFoundException;
import com.springrestapi.page.pagination;
import com.springrestapi.repo.Entity_repo;

@Service
//@Transactional(readOnly = true)
public class Entity_service {

	@Autowired
	private Entity_repo entity_repository;

	@Autowired
	private ModelMapper modelmapper;

	public EntityDto add(EntityDto entityDto)
	{
		//convert dto to entity 
		Entity entity=this.dtoToEntity(entityDto);
		//save to database
		Entity entity1=this.entity_repository.save(entity);
		
		return this.entitydto(entity1);
	
	}


//	public List<Entity> get() {
//
//		return this.entity_repository.findAll();
//
//	}


//	public EntityDto getid(Integer id) {
//
//		Entity entity= this.entity_repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("NOt found"+id));
//		
//		return this.entitydto(entity);
//		
//	}
//	
	
	public EntityDto getid(Integer id) {

		Entity entity= this.entity_repository.findById(id).orElseThrow(() -> new ResourseNotFoundException("NOt found"+id));
		
		return this.entitydto(entity);
		
	}
	
	
//	public EntityDto update(EntityDto entitydto,Integer id) {
//
//		
//		//save to database
////		Entity entity= entity_repository.save(entity);
//		Entity entity= entity_repository.findById(id).orElseThrow(()->new ResourseNotFoundException("Not Found"+id));
//		//conversion of entity to dto
//		Entity updateEntity=this.entity_repository.save(entity);
//		EntityDto entitydto1=entitydto(updateEntity);
//		return entitydto1;
//	}
	
public EntityDto update(EntityDto entitydto,Integer id) {

		
		//save to database
//		Entity entity= entity_repository.save(entity);
		Entity entity= entity_repository.findById(id).orElseThrow(()->new ResourseNotFoundException("Not Found"+id));
		//conversion of entity to dto
		
		Entity updateEntity=this.entity_repository.save(entity);
		EntityDto entitydto1=entitydto(updateEntity);
		return entitydto1;
	}


	public void deleteEntity(Integer id) {

				
//			Fetch the record from the db
//			Entity entity = entity_repository.getById(id);
//			
//			
//			//Update the is_active attr to false
//			entity.setIsActive(false);
//
//			//Save the record
//			this.entity_repository.save(entity);
		
		//only show for user is data deleted but actual data is not deleted form database.
//      this.entity_repository.findById(id).orElseThrow(()->new ResourseNotFoundException("Not found"));
		this.entity_repository.deleteById(id);

	}


	public Page<?> getProducts(String search, String pageNumber, String pageSize) {
		// TODO Auto-generated method stub

//		Pageable is an Integeregererface defined by Spring, which holds a PageRequest.
//		/Abstract Integeregererface for pagination information
		Pageable pagable=new pagination().getPagination(pageNumber,pageSize);

				if((search=="")|| (search==null)|| (search.length()==0))
				{
					return entity_repository.findAll(pagable);
				}
				else
				{
					return entity_repository.findByName(search,pagable,EntityDto.class);
				}


	}
	
	//only this data shown for user
	public Entity dtoToEntity(EntityDto entitydto)
	{
		Entity entity=this.modelmapper.map(entitydto, Entity.class);
		return entity;
	}

	

	public EntityDto entitydto(Entity entity)
	{
		//entity to represent to EntityDto (3 fis returns)
		EntityDto entitydto=this.modelmapper.map(entity, EntityDto.class);
		return entitydto; 
	}

}
