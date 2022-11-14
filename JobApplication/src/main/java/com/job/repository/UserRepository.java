package com.job.repository;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.User;
import com.job.serviceInterface.ILIstUserDto;
import com.job.serviceInterface.IListUserDtos;
import com.job.serviceInterface.IListUsersDto;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmailContainingIgnoreCase(String email);
	
	Page<IListUsersDto> findByUserName(String search, Pageable pagable, Class<IListUsersDto> class1);

	Page<IListUsersDto> findByOrderByUserIdDesc(Pageable pagable, Class<IListUsersDto> class1);

	User findByEmail(String email);

	@Transactional
	@Query(value = "select users.user_id,users.email,users.user_name from role inner join user_role on user_role.role_id=role.role_id inner join users on users.user_id=user_role.user_id where role_name=:role_name",nativeQuery = true)
	Page<IListUserDtos> findByUserByCandidate(@Param("role_name") String search, Pageable pagable, Class<IListUserDtos> class1);

	Page<IListUserDtos> findByOrderByUserId(Pageable pagable, Class<IListUserDtos> class1);

//	Page<IListUserDtos> findByUserByCandidate(String search, Pageable pagable, Class<IListUserDtos> class1);


}
