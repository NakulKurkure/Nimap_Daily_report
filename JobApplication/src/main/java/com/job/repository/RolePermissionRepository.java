package com.job.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.job.entity.RolePermission;
@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermission, Long>{

	@Transactional
	@Modifying
	@Query(value = "update role_permission rp set permission_id=:permission_id where rp.role_id=:role_id",nativeQuery = true)
	void updateRolePermission(Long role_id, Long permission_id);

	
	@Transactional
	@Modifying
	@Query(value = "update role_permission rp set is_active=false where rp.permission_id=:permission_id and rp.role_id=:role_id",nativeQuery = true)
	void deleteRolePermission(Long role_id, Long permission_id);

}