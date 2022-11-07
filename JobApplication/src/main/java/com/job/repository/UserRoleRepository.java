package com.job.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.Role;
import com.job.entity.User;
import com.job.entity.UserRole;

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
//
	@Transactional
	@Query(value="SELECT * from user_role t WHERE t.user_id=:user_id",nativeQuery = true)
	Optional<UserRole> findByUserById(@Param("user_id") Long user_id);

}
