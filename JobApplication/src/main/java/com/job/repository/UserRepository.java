package com.job.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.job.entity.User;
import com.job.serviceInterface.ILIstUserDto;
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

	@Query(value = "select users.user_id,users.email,users.user_name from role inner join user_role on user_role.role_id=role.role_id inner join users on users.user_id=user_role.user_id where role_name=:role_name",nativeQuery = true)
	List<IListUserDtos> findByUserByCandidate(@Param("role_name")  String search, Class<IListUserDtos> class1);

	
	@Query(value="select users.email as Email from job inner join users on users.user_id=job.recuriter_id\r\n"+ "",nativeQuery = true)
	List<IListDto> findByUsersList(Class<IListDto> class1);



}
