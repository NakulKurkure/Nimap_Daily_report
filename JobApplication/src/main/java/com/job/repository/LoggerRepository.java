package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.Logger;

@Repository
public interface LoggerRepository extends JpaRepository<Logger, Long>{

}
