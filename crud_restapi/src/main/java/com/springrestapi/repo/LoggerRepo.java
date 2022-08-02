package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springrestapi.entity.LoggerEntity;

public interface LoggerRepo extends JpaRepository<LoggerEntity, Integer>{

	
}
