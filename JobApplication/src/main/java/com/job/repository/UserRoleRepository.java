package com.job.repository;

import java.util.ArrayList;
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
import com.job.serviceInterface.ILIstUserDto;
import com.job.serviceInterface.IListUserRoleDto;
import com.job.serviceInterface.IUserListDto;
import com.job.serviceInterface.RoleIdList;


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

	@Transactional
	@Query(value="select u.user_id as userId,u.user_name as userName,u.email as email,r.role_id as roleId,r.role_name as roleName,r.description as Description from role r\r\n"
			+ " join user_role ur on ur.role_id=r.role_id \r\n"
			+ " join users u on ur.user_id=u.user_id",nativeQuery = true)
	Page<ILIstUserDto> findAll(Pageable pagable, Class<ILIstUserDto> class1);

//	ArrayList<RoleIdList> findByPkuserId(int id, Class<RoleIdList> class1);

//	ArrayList<RoleIdList> findByPkUserId(int id, Class<RoleIdList> class1);

//	ArrayList<RoleIdList> findByPkUserId(Long id, Class<RoleIdList> class1);

	ArrayList<RoleIdList> findByPkUserUserId(Long userId, Class<RoleIdList> class1);

//IListUserRoleDto


}
