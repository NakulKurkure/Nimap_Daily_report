package com.springrestapi.repo;

import java.util.Optional;

//import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

	Page<User> findByUserName(String search, Pageable pagable, Class<User> entitydto);

	User findByUsername(String Username);
	
	


	

}
