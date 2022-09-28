package com.serviceInterface;

import org.springframework.data.domain.Page;

import com.dto.QuestionDto;

public interface QuestionServiceInterface {

	QuestionDto addQuestions(QuestionDto questionDto);

	QuestionDto getQuestion(Long id);

	QuestionDto updateQuestion(QuestionDto questionDto, Long id);

	void deleteQuestionById(Long id);

	Page<IQuestionListDto> getAllQuestions(String search, String pageNumber, String pageSize);

}
