package com.serviceInterface;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.dto.QuestionDto;
import com.dto.UserQuestionRequestDto;
import com.entity.UserQuestionEntity;

public interface UserQuestionInterface {

	void addUserQuestion(UserQuestionRequestDto userQuestionRequestDto);

	void updateUserQuestion(UserQuestionRequestDto userQuestionRequestDto);

	void deleteUserQuestion(UserQuestionRequestDto userQuestionRequestDto);

	List<UserQuestionEntity> getAllUserQuestions();

//	QuestionDto updateQuestionByUserId(QuestionDto questionDto, Long id,HttpServletRequest request);

}
