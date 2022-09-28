package com.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.UserQuestionEntity;

@Repository
public interface UserQuestionRepository extends JpaRepository<UserQuestionEntity, Long>{

	
	@Transactional
	@Modifying(flushAutomatically = true,clearAutomatically = true)
	@Query(value="UPDATE user_question p SET question_id=:id2 WHERE p.user_id=:id",nativeQuery = true)
	void updateUserQuestion(Long id, Long id2);

}
