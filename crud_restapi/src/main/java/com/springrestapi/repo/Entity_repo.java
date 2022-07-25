package com.springrestapi.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.springrestapi.dto.EntityDto;
//import com.springrestapi.dto.EntityDto;
import com.springrestapi.entity.Entity;

@Repository

public interface Entity_repo extends JpaRepository<Entity, Integer> {

//
//	 page is a sublist of a list of objects. It allows gain information about the position of it in the containingentire list.
//	 Type Parameters:<T>
	Page<Entity> findByName(String search, Pageable pagable, Class<Entity> entity);

	Entity save(EntityDto entitydto);
	
//	@Query(value="SELECT * FROM ENTITY e WHERE e.is_active=true", nativeQuery = true)
//	Page<Entity> getAll(Pageable pagable, Class<Entity> entity);
	
//	@Query(value="SELECT * FROM ENTITY e WHERE e.is_active=true AND e.id=:id", nativeQuery = true)
//	Entity getById(@Param("id") Integer id);

//	Page<?> getAllOrderById(Pageable pagable, Class<Entity> class1);
//	@Query(value="SELECT * FROM ENTITY e WHERE e.name=:name AND e.lname=:lname AND e.Occupation=:Occupation AND e.id=:id", nativeQuery = true)
//	 Entity dtoToEntity(EntityDto entitydto);
//
//	@Query(value="SELECT * FROM ENTITY e WHERE e.name=:name, e.lname=:lname, e.Occupation=:Occupation AND e.id=:id", nativeQuery = true)
//	 EntityDto entitydto(Entity entity);
}
