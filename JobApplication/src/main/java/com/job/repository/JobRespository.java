package com.job.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.Job;
import com.job.serviceInterface.IListAllJobsDto;
import com.job.serviceInterface.IListJobDto;
import com.job.serviceInterface.IListJobDtos;

@Repository
public interface JobRespository extends JpaRepository<Job, Long>{

	List<IListJobDto> findById(Long id, Class<IListJobDto> class1);

//	List<IListJobDto> findByOrderByIdDesc(Pageable pagable, Class<IListJobDto> class1);

	Page<IListJobDto> findByJobTitle(String search, Pageable pagable, Class<IListJobDto> class1);
	
	
//	@Transactional
//	@Query(value = "select j.id,j.job_title,j.job_description from job j where recuriter_id=:recruiter_id",nativeQuery = true)
//	List<IListAllJobsDto> findJobByRecruiterId(Long recuriter_id, Class<IListAllJobsDto> class1);
	
	
//	@Transactional
//	@Query(value = "select j.id,j.job_title,j.job_description from job j where recuriter_id=:recruiter_id",nativeQuery = true)
//	List<IListAllJobsDto> findJobByRecruiterId(Long recuriter_id, Class<IListAllJobsDto> class1);

	
//	@Transactional
//	@Query(value = "select j.id,j.job_title,j.job_description from job j where recuriter_id=:recruiter_id",nativeQuery = true)
//	List<IListAllJobsDto> findJobByRecruiterId(@Param("recruiter_id") Long recuriter_id, Class<IListAllJobsDto> class1);

	Job findByRecruiterId(Long recuriterId);
//
//	List<IListAllJobsDto> findJobByRecruiterId(Long recuriter_id, Class<IListAllJobsDto> class1);

//	@Transactional
//	@Query(value = "select j.id,j.job_title,j.job_description from job j where recuriter_id=:recruiter_id",nativeQuery = true)
	
	@Transactional
	@Query(value = "select job.job_title,job.id,job.job_description,users.user_id,users.user_name,users.email from job inner join user_job on job.id=user_job.job_id inner join users on users.user_id=user_job.user_user_id where job.recuriter_id=:recuriter_id",nativeQuery = true)
	List<IListAllJobsDto> findByJobAndPkUserByRecruiterId(@Param("recuriter_id") Long recruiter_id);

	@Transactional
	@Query(value = "SELECT * from job t WHERE t.recuriter_id=:recuriter_id",nativeQuery = true)
	List<Job> findByRecuriterId(@Param("recuriter_id") Long recruiter_id);

	@Transactional
	@Query(value="select job.id,job.job_title,job.job_description,job.date_of_joining from users inner join user_job on users.user_id=user_job.user_user_id inner join job on job.id=user_job.job_id where user_name=:user_name",nativeQuery =true)
	List<IListJobDtos> findByJobTitleByUser(@Param("user_name") String search, Pageable pagable, Class<IListJobDtos> class1);

	Page<IListJobDtos> findByOrderById(Pageable pagable, Class<IListJobDtos> class1);

	Page<IListJobDto> findByOrderByIdDesc(Pageable pagable, Class<IListJobDto> class1);

//	List<IListJobDtos> findByJobTitleByUser(String search, Pageable pagable, Class<IListJobDtos> class1);

//	Job findByRecruiterId(Long recuriter_id);

//	List<IListAllJobsDto> findJobByRecuriterId(Long recuriter_id, Class<IListAllJobsDto> class1);

//	List<IListAllJobsDto> findJobByRecuriterId(Long recuriter_id, Class<IListAllJobsDto> class1);


}
