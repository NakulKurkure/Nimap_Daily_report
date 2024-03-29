package com.springrestapi.repo;




import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

//import com.springrestapi.entity.RoleEntity;
//import com.springrestapi.entity.User;
import com.springrestapi.entity.UserRoleEntity;
import com.springrestapi.service.RoleIdList;

@Repository
public interface UserRoleRepo extends JpaRepository<UserRoleEntity, Integer>{
	
//	We use @Transactional annotation when we create/update one more entity at the same time
	@Transactional
	//@Modifying annotation is used to enhance the @Query annotation 
//	so that we can execute not only SELECT queries, but also INSERT, UPDATE, DELETE queries
	@Modifying(flushAutomatically = true,clearAutomatically  = true)
	//Annotation to declare finder queries directly on repository methods.
	//Annotate to repository methods
	//value=Defines the JPA query to be executed 
	//Configures whether the given query is a native one. Defaults to false.
	
	@Query(value="UPDATE user_role u SET role_id=:role_id WHERE u.user_id=:user_id",nativeQuery = true)
	void updateUserRole(@Param ("user_id") Integer user_id,@Param ("role_id") Integer  role_id);
	
//	ArrayList<RoleIdList> findByPkUserId(Integer user,Class<RoleIdList> role);

	ArrayList<RoleIdList> findByPkUsersId(int id, Class<RoleIdList> class1);
	
}
