package com.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.entity.QuestionEntity;
import com.serviceInterface.IQuestionListDto;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long>{

	Page<IQuestionListDto> findByQuestion(String search, Pageable pagable, Class<IQuestionListDto> class1);

	Page<IQuestionListDto> findByOrderById(Pageable pagable, Class<IQuestionListDto> class1);

//	@Transactional
//	@Query(value = "select s.question from question_entity s WHERE is_draft=true",nativeQuery = true)	
	
	
	//fetch only List of question and only is_draft=true records fetched..
	@Query(value="select q.question from question_entity q where q.is_draft=true",nativeQuery = true)

	List<Object> findByQuestionAndIsDraftTrue();

	
	@Query(value="select * from question_entity q where q.is_draft=true",nativeQuery = true)

	List<Object> findByQuestions();

	
//	@Query(value="")
//	Page<IQuestionListDto> findByAdmin(String search, Pageable pagable, Class<IQuestionListDto> class1);

	
	
//	List<QuestionEntity> findByAllQuestion();

}
