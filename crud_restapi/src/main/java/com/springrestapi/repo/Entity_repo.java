package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.Entity;

@Repository
public interface Entity_repo extends JpaRepository<Entity, Long> {

	
}
