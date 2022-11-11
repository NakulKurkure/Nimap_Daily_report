package com.job.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.OtpEntity;

@Repository
public interface OtpRepository extends JpaRepository<OtpEntity, Long>{

	
//	@Query(value = "select * from  ",nativeQuery = true)
	List<OtpEntity> findByEmailContainingIgnoreCase(String email);
	
	Optional<OtpEntity> findByOtp(Long otp);

//	OtpEntity findByOtp(String email);

//	@Transactional
//	@Query(value = "select * from otp_entity o where o.email=:email",nativeQuery = true)
//	OtpEntity findByEmailContainingIgnoreCase1(@Param("email") String email);

}
