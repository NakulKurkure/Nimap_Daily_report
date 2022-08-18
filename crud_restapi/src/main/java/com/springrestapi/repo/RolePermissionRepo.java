package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.RolePermissionEntity;

@Repository
public interface RolePermissionRepo extends JpaRepository<RolePermissionEntity, Integer>{

}
