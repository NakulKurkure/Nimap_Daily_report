package com.springrestapi.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.UserRoleEntity;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer>{
	
//	List<UserRoleEntity> findAll();
}
