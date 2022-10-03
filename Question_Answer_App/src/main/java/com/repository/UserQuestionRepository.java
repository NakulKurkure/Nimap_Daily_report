package com.repository;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.QuestionEntity;
import com.entity.UserQuestionEntity;
import com.entity.UserRoleEntity;

@Repository
public interface UserQuestionRepository extends JpaRepository<UserQuestionEntity, Long>{

	
	@Transactional
	@Modifying(flushAutomatically = true,clearAutomatically = true)
	@Query(value="UPDATE user_question p SET question_id=:id2 WHERE p.user_id=:id",nativeQuery = true)
	void updateUserQuestion(Long id, Long id2);

	
	@Transactional
	@Query(value="SELECT * from user_question t WHERE t.user_id=:user_id",nativeQuery = true)
	UserQuestionEntity findByUserById(@Param("user_id") Long user_id);

	
	
	


	
	
	


}
