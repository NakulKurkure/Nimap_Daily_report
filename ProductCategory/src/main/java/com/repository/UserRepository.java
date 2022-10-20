package com.repository;

import java.util.ArrayList;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.Role;
import com.entity.User;
import com.serviceInterface.IUserListDto;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmailContainingIgnoreCase(String user);

	Page<IUserListDto> findByUserName(String search, Pageable pagable, Class<IUserListDto> class1);

	Page<IUserListDto> findByOrderByUserIdDesc(Pageable pagable, Class<IUserListDto> class1);

	void save(ArrayList<Role> roles);

}
