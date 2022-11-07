package com.job.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.ForgotPasswordConfirm;

@Repository
public interface ForgotPassConfRepository extends JpaRepository<ForgotPasswordConfirm, Long>{

}
