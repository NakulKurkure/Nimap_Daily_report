package com.job.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.UserJob;
import com.job.serviceInterface.IListUserJobDto;

@Repository
public interface UserJobRepository extends JpaRepository<UserJob, Long> {

	@Query(value = "select job.id from user_job inner join job on user_job.job_id=job.id inner join users on users.user_id=user_job.user_user_id\r\n"
			+ "AND (:userId= '' OR user_job.user_user_id IN (select unnest(cast(string_to_array(:userId,',') as bigint[])))) AND (:jobId= '' OR user_job.job_id IN (select unnest(cast(string_to_array(:jobId,',') as bigint[]))))", nativeQuery = true)
	Page<IListUserJobDto> findList1(Pageable paging, @Param("userId") String userId, @Param("jobId") String jobId,
			Class<IListUserJobDto> class1);

}