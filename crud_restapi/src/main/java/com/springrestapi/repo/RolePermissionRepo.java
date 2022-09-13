package com.springrestapi.repo;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.RolePermissionEntity;
import com.springrestapi.service.PermissionIdList;

@Repository
public interface RolePermissionRepo extends JpaRepository<RolePermissionEntity, Integer>{
	
	@Transactional
	@Modifying(flushAutomatically = true,clearAutomatically = true)
	@Query(value="UPDATE role_permission p SET permission_id=:permission_id WHERE p.role_id=:role_id",nativeQuery = true)
	void updateRolePermission(@Param ("role_id") Integer  role_id,@Param ("permission_id") Integer permission_id);
//	
	
//	List<PermissionIdList> findPkPermissionByPkRoleIdIn(ArrayList<Integer> roleIds,Class<PermissionIdList> permissionIdList);

	List<PermissionIdList> findPkPermissionByPkRolesIdIn(ArrayList<Integer> roles, Class<PermissionIdList> class1);
	

}
