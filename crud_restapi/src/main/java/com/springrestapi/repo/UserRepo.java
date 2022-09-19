package com.springrestapi.repo;

import java.util.Optional;

import org.springframework.boot.autoconfigure.quartz.QuartzTransactionManager;

//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.User;

import io.lettuce.core.dynamic.annotation.Param;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	Page<User> findByUserName(String search, Pageable pagable, Class<User> entity);

	User findByUsername(String Username);

	//JPQL Query
//	/Annotation to bind method parameters using their name
//	@Query("select u From users u WHERE u.id=:id",native)
//	Optional<User> findById(@Param("id") Integer id);
//	
	


	

}
