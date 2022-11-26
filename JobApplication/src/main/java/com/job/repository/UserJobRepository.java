package com.job.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import org.springframework.stereotype.Repository;

import com.job.entity.UserJob;
import com.job.serviceInterface.IListUserJobDto;

@Repository
public interface UserJobRepository extends JpaRepository<UserJob, Long> {

	@Query(value = "select job.id as Id,job.job_title as JobTitle,job.job_description as JobDescription,users.user_id as UserId,users.email as Email,users.user_name as UserName from user_job\r\n"
			+ "inner join job on user_job.job_id=job.id\r\n"
			+ "inner join users on users.user_id=user_job.user_user_id  AND \r\n"
			+ "(:userId= '' OR user_job.user_user_id IN (select unnest(cast(string_to_array(:userId, ',') as bigint[])))) AND \r\n"
			+ "(:jobId= '' OR user_job.job_id IN (select unnest(cast(string_to_array(:jobId, ',') as bigint[])))) AND user_job.is_active=true", nativeQuery = true)
	Page<IListUserJobDto> findListofUserJob(String userId, String jobId, Pageable pagable,
			Class<IListUserJobDto> class1);

}