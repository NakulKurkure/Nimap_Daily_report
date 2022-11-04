package com.job.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.Permission;
import com.job.serviceInterface.IPermissionListDto;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long>{

	Page<IPermissionListDto> findByOrderByPermissionId(Pageable pagable, Class<IPermissionListDto> class1);

	Page<IPermissionListDto> findByActionName(String search, Pageable pagable, Class<IPermissionListDto> class1);

}
