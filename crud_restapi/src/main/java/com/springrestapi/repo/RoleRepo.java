package com.springrestapi.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.RoleEntity;

@Repository
public interface RoleRepo extends JpaRepository<RoleEntity, Integer>{

	RoleEntity save(RoleEntity roleEntity);

	Page<?> findByRoleName(String search, Pageable pageable, Class<RoleEntity> class1);

}
