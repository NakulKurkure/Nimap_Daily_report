package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.UserEntity;
import com.serviceInterface.IUserListDto;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long>{

	Page<IUserListDto> findByUsername(String Username, Pageable pagable, Class<IUserListDto> class1);
	
	UserEntity findByEmailContainingIgnoreCase(String email);

	Page<IUserListDto> findByOrderById(Pageable pagable, Class<IUserListDto> class1);

}
