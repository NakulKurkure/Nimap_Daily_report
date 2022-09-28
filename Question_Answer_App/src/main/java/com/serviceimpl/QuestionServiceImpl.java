package com.serviceimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.QuestionDto;
import com.entity.QuestionEntity;
import com.exception.ResourceNotFoundException;
import com.repository.QuestionRepository;
import com.serviceInterface.IQuestionListDto;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.QuestionServiceInterface;
import com.util.Pagination;

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

	@Override
	public void deleteQuestionById(Long id) {
		
		questionRepository.deleteById(id);
	}

	@Override
	public Page<IQuestionListDto> getAllQuestions(String search, String pageNumber, String pageSize) {

		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return questionRepository.findByOrderById(pagable,IQuestionListDto.class);
		}
		else
		{
			return  questionRepository.findByQuestion(search,pagable,IQuestionListDto.class);
		}
		
		
	}


	
}
