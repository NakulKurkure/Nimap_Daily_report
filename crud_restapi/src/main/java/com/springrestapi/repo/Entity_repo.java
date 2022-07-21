package com.springrestapi.repo;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.Entity;

@Repository
public interface Entity_repo extends JpaRepository<Entity, Long> {

//	Page<Entity> findOrderId(Pageable paging,Class<Entity> entity);


//	Page<Entity> findOrderByEid(Pageable pagable, Class<Entity> entity);
	//
//	 page is a sublist of a list of objects. It allows gain information about the position of it in the containingentire list.
//	 Type Parameters:<T> 
	Page<Entity> findByName(String search, Pageable pagable, Class<Entity> entity);
	Page<Entity> findByOrderByIdAndIsActiveTrue(Pageable pagable, Class<Entity> class1);

	Entity findByIdAndIsActiveTrue(Long id);
//	Optional<UserEntity> findByIdAndIsActiveTrue(Long id);
}
