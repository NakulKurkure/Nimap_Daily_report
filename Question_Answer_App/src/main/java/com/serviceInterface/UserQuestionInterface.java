package com.serviceInterface;

import java.util.List;

import com.dto.UserQuestionRequestDto;
import com.entity.UserQuestionEntity;

public interface UserQuestionInterface {

	void addUserQuestion(UserQuestionRequestDto userQuestionRequestDto);

	void updateUserQuestion(UserQuestionRequestDto userQuestionRequestDto);

	void deleteUserQuestion(UserQuestionRequestDto userQuestionRequestDto);

	List<UserQuestionEntity> getAllUserQuestions();

}
