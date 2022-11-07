package com.job.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.OtpEntity;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Long>{

	Optional<OtpEntity> findByEmailContainingIgnoreCase(String email);

	Optional<OtpEntity> findByOtp(Long otp);

}
