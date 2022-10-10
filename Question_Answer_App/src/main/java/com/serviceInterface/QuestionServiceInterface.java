package com.serviceInterface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.dto.QuestionDataDto;
import com.dto.QuestionDto;
import com.dto.UserDataDto;
import com.entity.QuestionEntity;

public interface QuestionServiceInterface {

	QuestionDto addQuestions(QuestionDto questionDto,HttpServletRequest request);

	QuestionDataDto getQuestion(Long id);

	QuestionDto updateQuestion(QuestionDto questionDto, Long id);

	void deleteQuestionById(Long id);

	Page<IQuestionListDto> getAllQuestions(String search, String pageNumber, String pageSize);


	List<Object> getAllDraftQuestions();

	List<Object> getAllQuestionsByUserId(long id,HttpServletRequest request);



}
