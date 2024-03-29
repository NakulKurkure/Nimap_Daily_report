package com.serviceInterface;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.data.domain.Page;

import com.dto.AnswerDto;


public interface AnswerInterface {

	AnswerDto addAnswer(AnswerDto answerDto,HttpServletRequest request);

	AnswerDto updatedAnswer(AnswerDto answerDto, Long id,HttpServletRequest request);

	AnswerDto getByAnswerId(Long id,HttpServletRequest request);

	void deleteAnswerById(Long id,HttpServletRequest request);

	Page<IListAnswerDto> getAllAnswers(String search, String pageNumber, String pageSize);

	Object getByAnswerIdGetAll(Long id, HttpServletRequest request);

	Object GetAll();

	AnswerDto updateQuestionByUserId(AnswerDto questionDto, Long id, HttpServletRequest request);

	List<IListAnswerDto> getQuestionAndAnswerById(Long id, HttpServletRequest request);


	
	
}
