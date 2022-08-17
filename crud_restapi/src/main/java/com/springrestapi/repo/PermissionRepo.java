package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.PermissionEntity;
@Repository
public interface PermissionRepo extends JpaRepository<PermissionEntity, Integer>{

}
