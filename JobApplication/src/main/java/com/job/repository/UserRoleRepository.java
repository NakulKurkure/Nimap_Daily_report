package com.job.repository;

import java.util.ArrayList;
import java.util.List;

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
import com.job.serviceInterface.ILIstUserDto;
import com.job.serviceInterface.RoleIdList;

@Repository
public interface UserRoleRepository extends JpaRepository<UserRole, Long> {

	@Transactional
	@Modifying
	@Query(value = "update user_role ur set is_active=false where ur.role_id=:role_id and ur.user_id=:user_id", nativeQuery = true)
	void deleteUserRole(User user_id, Role role_id);

	@Query(value = "SELECT r.role_id,r.role_name,r.description,u.user_id,u.user_name,u.email from user_role ur join users u on ur.user_id=u.user_id join role r on ur.role_id=r.role_id AND (:user_id='' OR ur.user_id IN (select unnest(cast(string_to_array(:user_id,',') as bigint[])))) AND (:role_id='' OR ur.role_id IN (select unnest(cast(string_to_array(:role_id,',') as bigint[])))) AND ur.is_active=true", nativeQuery = true)
	Page<ILIstUserDto> findAllListUserRole(@Param("user_id") String userId, @Param("role_id") String roleId,
			Pageable pagable, Class<ILIstUserDto> class1);

	ArrayList<RoleIdList> findByPkUserUserId(Long userId, Class<RoleIdList> class1);

	// fetched from database
	@Query(value = "SELECT * from user_role t WHERE t.user_id=:user_id", nativeQuery = true)
	UserRole findByUserById(@Param("user_id") Long user_id);

	// fetched from database
	@Query(value = "SELECT * from user_role t WHERE t.user_id=:user_id", nativeQuery = true)
	List<UserRole> findByUserId(@Param("user_id") Long user_id);

	// fetched from database
	@Query(value = "SELECT * from user_role t WHERE t.role_id=:role_id", nativeQuery = true)
	List<UserRole> findRoleId(@Param("role_id") Long role_id);

	@Transactional
	@Modifying
	@Query(value = "update user_role ur set role_id=:role_id where ur.user_id=:user_id", nativeQuery = true)
	void updateUserRole(User user_id, Role role_id);

}
