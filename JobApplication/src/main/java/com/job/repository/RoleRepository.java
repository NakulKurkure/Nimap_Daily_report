package com.job.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.Role;
import com.job.serviceInterface.IRoleListDto;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	Page<IRoleListDto> findByRoleName(String search, Pageable pagable, Class<IRoleListDto> class1);

//	@Query(value = "select r.rolename,r.description,r,role_id from role r where r.role_id=?")
//	Page<IRoleListDto> findByroleIdDesc(@Param ("role_id")Long role_id,Pageable pagable, Class<IRoleListDto> class1);

	Page<IRoleListDto> findByOrderByRoleIdDesc(Pageable pagable, Class<IRoleListDto> class1);

}
