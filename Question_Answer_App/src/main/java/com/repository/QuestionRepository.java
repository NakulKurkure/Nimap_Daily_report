package com.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.entity.QuestionEntity;
import com.serviceInterface.IQuestionListDto;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long>{

	Page<IQuestionListDto> findByQuestion(String search, Pageable pagable, Class<IQuestionListDto> class1);

	Page<IQuestionListDto> findByOrderById(Pageable pagable, Class<IQuestionListDto> class1);

	
	
	//fetch only List of question and only is_draft=true records fetched..
	@Query(value="select q.question from question_entity q where q.is_draft=true",nativeQuery = true)

	List<Object> findByQuestionAndIsDraftTrue();
	
	
	@Query(value="select * from question_entity q where q.is_draft=true",nativeQuery = true)

	List<Object> findByQuestions();

	@Transactional
	@Query(value = "select question_entity.id,question_entity.question,answer_entity.answer from question_entity INNER JOIN answer_entity ON question_entity.user_id_id=answer_entity.user_id_id",nativeQuery = true)
//	@Query(value = "SELECT q.question,q.id,a.id,a.answer FROM question_entity q INNER JOIN answer_entity a ON q.user_id_id=a.user_id_id",nativeQuery = true)

	List<Object> findByUsersQuestionAndAnswerByUserId(@Param("user_id_id")  Long user_id_id);

}
