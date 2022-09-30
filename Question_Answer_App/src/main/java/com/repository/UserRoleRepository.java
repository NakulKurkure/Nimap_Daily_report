package com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.UserRoleEntity;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>{

	@Transactional
	@Modifying(flushAutomatically = true,clearAutomatically  = true)
	@Query(value="UPDATE user_role u SET role_id=:id2 WHERE u.user_id=:id",nativeQuery = true)
	void updateUserRole(Long id, Long id2);


	@Transactional
//	@Query(value = "SELECT t from user_role t WHERE t.user_id=:userId",nativeQuery = true)
	
	@Query(value = "SELECT * from user_role t WHERE t.user_id=:user_id",nativeQuery = true)
	UserRoleEntity findByUserById(@Param("user_id") Long user_id);

}
