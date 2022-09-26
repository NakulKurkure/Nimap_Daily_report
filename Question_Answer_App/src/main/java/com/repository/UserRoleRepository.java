package com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.UserRoleEntity;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRoleEntity, Long>{

	@Transactional
	@Modifying(flushAutomatically = true,clearAutomatically  = true)
	@Query(value="UPDATE user_role u SET role_id=:id2 WHERE u.user_id=:id",nativeQuery = true)
	void updateUserRole(Long id, Long id2);

}
