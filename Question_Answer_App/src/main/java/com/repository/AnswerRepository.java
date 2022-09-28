package com.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.AnswerEntity;
import com.entity.QuestionEntity;
import com.serviceInterface.IAnswerListDto;

@Repository
public interface AnswerRepository extends JpaRepository<AnswerEntity, Long>{

	Page<IAnswerListDto> findByOrderById(Pageable pagable, Class<IAnswerListDto> class1);

	Page<IAnswerListDto> findByAnswer(String search, Pageable pagable, Class<IAnswerListDto> class1);

//	void save(AnswerEntity answerEntity);
//
	

}
