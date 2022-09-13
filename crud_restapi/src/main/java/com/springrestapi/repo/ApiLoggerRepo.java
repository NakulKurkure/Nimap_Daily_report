package com.springrestapi.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springrestapi.entity.ApiLoggerEntity;

@Repository
public interface ApiLoggerRepo extends JpaRepository<ApiLoggerEntity, Integer>{

}
