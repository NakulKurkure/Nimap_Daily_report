package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.LoggerEntity;

@Repository
public interface LoggerRepo extends JpaRepository<LoggerEntity, Integer>{

	LoggerEntity findByToken(String token);
	
	void removeByToken(String token);

}
