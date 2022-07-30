package com.springrestapi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

//import com.springrestapi.dto.EntityDto;
import com.springrestapi.entity.Entity;

@Repository

public interface Entity_repo extends JpaRepository<Entity, Integer> {

//
//	 page is a sublist of a list of objects. It allows gain information about the position of it in the containingentire list.
//	 Type Parameters:<T>
	Page<Entity> findByName(String search, Pageable pagable, Class<Entity> entitydto);
//
//	@Query(value="SELECT * FROM ENTITY e WHERE e.name:=n", nativeQuery = true)
//	Optional<Entity> findByUserName(String username);
//
//	@Query(value="SELECT * FROM ENTITY e WHERE e.name:=n", nativeQuery = true)
//	Optional<Entity> findByUserName(String name);


}
