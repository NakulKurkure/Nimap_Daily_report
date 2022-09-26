package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.QuestionDto;
import com.entity.QuestionEntity;
import com.exception.ResourceNotFoundException;
import com.repository.QuestionRepository;
import com.serviceInterface.QuestionServiceInterface;

@Service
public class QuestionServiceImpl implements QuestionServiceInterface{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Override
	public QuestionDto addQuestions(QuestionDto questionDto) {
		
		QuestionEntity questionEntity=new QuestionEntity();
		questionEntity.setQuestion(questionDto.getQuestion());
		questionEntity.setDescription(questionDto.getDescription());
		
		questionRepository.save(questionEntity);
		
		return questionDto;
		
		
	}

	@Override
	public QuestionDto getQuestion(Long id) {
		
		QuestionEntity questionEntity=  questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Question Id.."));
		
		QuestionDto questionDto=new QuestionDto();
		questionDto.setQuestion(questionEntity.getQuestion());
		questionDto.setDescription(questionEntity.getDescription());
		
		
		return questionDto;
	}

	@Override
	public QuestionDto updateQuestion(QuestionDto questionDto, Long id) {
		
		QuestionEntity questionEntity=  questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Question Id.."));
		
		questionEntity.setDescription(questionDto.getDescription());
		questionEntity.setQuestion(questionDto.getQuestion());
		
		questionRepository.save(questionEntity);
		return questionDto;
	}

}
