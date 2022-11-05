package com.job.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.job.entity.User;
import com.job.serviceInterface.ILIstUserDto;
import com.job.serviceInterface.IUserListDto;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmailContainingIgnoreCase(String email);
	
	Page<ILIstUserDto> findByUserName(String search, Pageable pagable, Class<ILIstUserDto> class1);

	Page<ILIstUserDto> findByOrderByUserIdDesc(Pageable pagable, Class<ILIstUserDto> class1);


}
