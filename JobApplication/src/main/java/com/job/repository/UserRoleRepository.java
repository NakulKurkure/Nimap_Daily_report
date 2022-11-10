package com.job.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.Role;
import com.job.entity.User;
import com.job.entity.UserRole;
import com.job.serviceInterface.IUserListDto;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

	@Transactional
	@Modifying
	@Query(value = "update user_role ur set role_id=:role_id where ur.user_id=:user_id",nativeQuery = true)
	void updateUserRole(User user_id, Role role_id);
	
	@Transactional
	@Modifying
	@Query(value = "update user_role ur set is_active=false where ur.role_id=:role_id and ur.user_id=:user_id",nativeQuery = true)
	void deleteUserRole(User user_id, Role role_id);

	@Transactional
	//fetched from database
	@Query(value = "SELECT * from user_role t WHERE t.user_id=:user_id",nativeQuery = true)
	List<UserRole> findByUserId(@Param("user_id") Long user_id);

	
	@Transactional
	//fetched from database
	@Query(value = "SELECT * from user_role t WHERE t.role_id=:role_id",nativeQuery = true)
	List<UserRole> findRoleId(@Param("role_id") Long role_id);

	@Transactional
	//fetched from database
	@Query(value = "SELECT * from user_role t WHERE t.user_id=:user_id",nativeQuery = true)
	UserRole findByUserById(@Param("user_id") Long user_id);

//	Page<IUserListDto> findByOrderById(Pageable pagable, Class<IUserListDto> class1);

//	Page<IUserListDto> findByOrderById(Pageable pagable, Class<IUserListDto> class1);
//
//	Page<IUserListDto> findById(Pageable pagable, Class<IUserListDto> class1);

//	Page<IUserListDto> findByOrderByIdDesc(Pageable pagable, Class<IUserListDto> class1);


}
