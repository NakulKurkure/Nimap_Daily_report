package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entity.QuestionEntity;
import com.serviceInterface.IQuestionListDto;

@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long>{

	Page<IQuestionListDto> findByQuestion(String search, Pageable pagable, Class<IQuestionListDto> class1);

	Page<IQuestionListDto> findByOrderById(Pageable pagable, Class<IQuestionListDto> class1);

}
