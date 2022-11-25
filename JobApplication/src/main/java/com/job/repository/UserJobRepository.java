package com.job.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.UserJob;
import com.job.serviceInterface.IListUserJobDto;
import com.job.serviceInterface.IListUserListDto;

@Repository
public interface UserJobRepository extends JpaRepository<UserJob, Long>{

	@Transactional
	@Query(value="select users.user_id as UserId,users.email as Email,users.user_name as UserName,job.id as id,job.job_title as JobTitle,job.job_description as JobDescription from job inner join user_job on user_job.job_id=job.id inner join users on users.user_id=user_job.user_user_id where user_name=:user_name"
			,nativeQuery = true)
	Page<IListUserListDto> findByUserName(@Param("user_name") String search,Pageable pagable, Class<IListUserListDto> class1);

	Page<IListUserListDto> findByOrderById(Pageable pagable, Class<IListUserListDto> class1);

	
	@Query(value="select job.id as Id,job.job_title as JobTitle,job.job_description as JobDescription,users.user_id as UserId,users.email as Email,users.user_name as UserName from user_job\r\n"
			+ "inner join job on user_job.job_id=job.id\r\n"
			+ "inner join users on users.user_id=user_job.user_user_id  AND \r\n"
			+ "(:userId= '' OR user_job.user_user_id IN (select unnest(cast(string_to_array(:userId, ',') as bigint[])))) AND \r\n"
			+ "(:jobId= '' OR user_job.job_id IN (select unnest(cast(string_to_array(:jobId, ',') as bigint[]))))",nativeQuery = true)
	Page<IListUserJobDto> findListofUserJob(String userId, String jobId, Pageable pagable, Class<IListUserJobDto> class1);


}