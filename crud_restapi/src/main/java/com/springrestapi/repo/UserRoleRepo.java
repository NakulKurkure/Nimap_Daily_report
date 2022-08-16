package com.springrestapi.repo;


import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.RoleEntity;
import com.springrestapi.entity.User;
import com.springrestapi.entity.UserRoleEntity;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer>{
	
//	List<UserRoleEntity> findAll();
	
	@Transactional
	@Modifying
	
	@Query(value="UPDATE user_role u SET is_active=false WHERE u.role_id = :role_id AND u.user_id = :user_id",nativeQuery =true)
	void deleteUserRole(@Param ("user_id") int user_id,@Param ("role_id ") int  role_id);
	
}
