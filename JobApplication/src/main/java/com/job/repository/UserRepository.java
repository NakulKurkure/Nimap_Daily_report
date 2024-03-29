package com.job.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.User;
import com.job.serviceInterface.IListDto;
import com.job.serviceInterface.IListUserDtos;
import com.job.serviceInterface.IListUsersDto;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmailContainingIgnoreCase(String email);
	
	Page<IListUsersDto> findByUserName(String search, Pageable pagable, Class<IListUsersDto> class1);

	Page<IListUsersDto> findByOrderByUserIdDesc(Pageable pagable, Class<IListUsersDto> class1);

	User findByEmail(String email);

	Page<IListUserDtos> findByOrderByUserId(Pageable pagable, Class<IListUserDtos> class1);
	
	@Query(value="select users.email as Email from job inner join users on users.user_id=job.recuriter_id where recuriter_id=:recuriter_id"+ "",nativeQuery = true)
	List<IListDto> findByUsersList(@Param("recuriter_id") Long recruiter_id, Class<IListDto> class1);

}
