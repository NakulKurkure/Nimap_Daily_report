package com.job.repository;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.job.entity.RolePermission;
import com.job.serviceInterface.IListRoleDto;
import com.job.serviceInterface.PermissionIdList;

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


	@Query(value="select r.role_id as roleId,r.role_name as roleName,r.description as roleDescription,p.permission_id as permissionId,p.action_name as actionName,p.description as Description,p.base_url as baseUrl,p.method as Method from role r\r\n"
			+ " join role_permission rp on rp.role_id=r.role_id \r\n"
			+ " join permission p on rp.permission_id=p.permission_id",nativeQuery = true)
	Page<IListRoleDto> findAll(Pageable pagable, Class<IListRoleDto> class1);




	List<PermissionIdList> findPkPermissionByPkRoleRoleIdIn(ArrayList<Long> roles, Class<PermissionIdList> class1);



}
