package com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.RolePermissionEntity;

@Repository
public interface RolePermissionRepository extends JpaRepository<RolePermissionEntity, Long> {

	

	
	@Transactional
	@Modifying(flushAutomatically = true,clearAutomatically = true)
	@Query(value="UPDATE role_permission p SET permissions_id=:id2 WHERE p.role_id=:id",nativeQuery = true)
	void updateRolePermission(Long id, Long id2);

}
