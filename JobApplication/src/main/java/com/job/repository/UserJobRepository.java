package com.job.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.UserJob;
import com.job.serviceInterface.IListUserListDto;
import com.job.serviceInterface.IUserJobListDto;


@Repository
public interface UserJobRepository extends JpaRepository<UserJob, Long>{

//	Page<IUserJobListDto> findByOrderByIdIn(Pageable pagable, Class<IUserJobListDto> class1);


	Page<IListUserListDto> findByOrderById(Pageable pagable, Class<IListUserListDto> class1);

}
