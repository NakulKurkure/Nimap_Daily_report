package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.dto.QuestionDataDto;
import com.dto.QuestionDto;
import com.entity.AnswerEntity;
import com.entity.QuestionEntity;
import com.entity.UserEntity;
import com.entity.UserQuestionEntity;
import com.entity.UserRoleEntity;
import com.exception.ResourceNotFoundException;
import com.repository.QuestionRepository;
import com.repository.UserQuestionRepository;
import com.repository.UserRepository;
import com.repository.UserRoleRepository;
import com.security.JwtTokenUtil;
import com.serviceInterface.IQuestionListDto;
import com.serviceInterface.IUserListDto;
import com.serviceInterface.QuestionServiceInterface;
import com.serviceInterface.getQuestions;
import com.util.Pagination;

@Service
public class QuestionServiceImpl implements QuestionServiceInterface{

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserQuestionRepository userQuestionRepository;
	
	@Override
	public QuestionDto addQuestions(QuestionDto questionDto) {
		
		QuestionEntity questionEntity=new QuestionEntity();
		questionEntity.setQuestion(questionDto.getQuestion());
		questionEntity.setDescription(questionDto.getDescription());
		questionEntity.setIs_draft(questionDto.isIs_draft());
		
		questionRepository.save(questionEntity);
		
		return questionDto;
		
		
	}

	@Override
	public QuestionDataDto getQuestion(Long id) {
		
		QuestionEntity questionEntity=  questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Question Id.."));
		
		QuestionDataDto questionDataDto=new QuestionDataDto();
		questionDataDto.setQuestion(questionEntity.getQuestion());
		questionDataDto.setDescription(questionEntity.getDescription());
		
		return questionDataDto;
	}

	@Override
	public QuestionDto updateQuestion(QuestionDto questionDto, Long id) {
		
		QuestionEntity questionEntity=  questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Question Id.."));
		
		questionEntity.setDescription(questionDto.getDescription());
		questionEntity.setQuestion(questionDto.getQuestion());
		questionEntity.setIs_draft(questionDto.isIs_draft());
		
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


	@Override
	public List<Object> getAllDraftQuestions() {

	List<Object> questionEntity1= questionRepository.findByQuestionAndIsDraftTrue();

	return questionEntity1;


	}
//
	public QuestionDto updateQuestionByUserId(QuestionDto questionDto, Long id,HttpServletRequest request) {
		
		
		
		QuestionEntity questionEntity=  questionRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Question Id.."));
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email 
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
//		//check on repo.
		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		
//		System.out.println("Id"+userEntityId);
		
		
		try
		{
//			System.out.println();
			
			Long id1=userEntity.getId();
			System.out.println("Id"+id1);
		UserQuestionEntity userQuestionEntity= userQuestionRepository.findPkQueationIdByPkUsersId(id1);
		
		
		if(userQuestionEntity!=null) {
			
			throw new Exception("User in not valid");
		}
		
		System.out.println("Id"+userQuestionEntity);
		
//		QuestionEntity questionEntity2= questionRepository.findById(questionEntityId).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
//		
//		System.out.println("Idsssss"+userQuestionEntity);	
//	
//			questionEntity2.setDescription(questionDto.getDescription());
//			questionEntity2.setQuestion(questionDto.getQuestion());
//			questionEntity2.setIs_draft(questionDto.isIs_draft());
//			
//			questionRepository.save(questionEntity2);
			
			return questionDto;
		}catch(Exception e)
		{
			throw new ResourceNotFoundException("Not Found UserId..");
		}

	}

	
	

	

}
