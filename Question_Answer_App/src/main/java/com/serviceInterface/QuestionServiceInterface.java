package com.serviceInterface;

import com.dto.QuestionDto;

public interface QuestionServiceInterface {

	QuestionDto addQuestions(QuestionDto questionDto);

	QuestionDto getQuestion(Long id);

	QuestionDto updateQuestion(QuestionDto questionDto, Long id);

}
