package com.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.dto.QuestionDataDto;
import com.dto.QuestionDto;

import com.entity.QuestionEntity;
import com.entity.RoleEntity;
import com.entity.UserEntity;
import com.entity.UserRoleEntity;
import com.exception.ResourceNotFoundException;
import com.repository.AnswerRepository;
import com.repository.QuestionRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.repository.UserRoleRepository;
import com.security.JwtTokenUtil;

import com.serviceInterface.IQuestionListDto;
import com.serviceInterface.QuestionServiceInterface;
import com.util.Pagination;

@Service
public class QuestionServiceImpl implements QuestionServiceInterface{

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AnswerRepository answerRepository;
	
	@Override
	public QuestionDto addQuestions(QuestionDto questionDto,HttpServletRequest request) {
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email 
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
//		//check on repo.
		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);

		
		
		
		QuestionEntity questionEntity=new QuestionEntity();
		questionEntity.setQuestion(questionDto.getQuestion());
		questionEntity.setDescription(questionDto.getDescription());
		questionEntity.setIs_draft(questionDto.isIs_draft());
		questionEntity.setIs_publish(questionDto.getIs_publish());
		questionEntity.setUser_id(userEntity);
		
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
		questionEntity.setIs_flag(questionDto.isIs_flag());
		
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
	
	public List<Object> getAllQuestionsByUserId(long id,HttpServletRequest request)
	{
		
		UserEntity userEntity1= userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));
		System.out.println("Id"+id);
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email 
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
//		//check on repo.
		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		
		Long user_id=userEntity.getId();
		System.out.println("userId"+user_id);
		
		
		
		UserRoleEntity userRoleEntity= userRoleRepository.findByUserById(user_id);
		System.out.println("userRoleEntity1111");
		
		Long roleEntityId=userRoleEntity.getPk().getRoles().getId();
		System.out.println(""+userRoleEntity.getPk().getRoles().getId());
		
		RoleEntity roleEntity1=roleRepository.findById(roleEntityId).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId.."));
		
		
		String roleName=roleEntity1.getRoleName();
		System.out.println("role"+roleName);
		if(roleName.equals("Admin"))
		{
		
//		QuestionEntity questionEntity1= questionRepository.findByUsersId(id).orElseThrow(()-> new ResourceNotFoundException("Not found Id"));	
//		System.out.println(questionEntity1);
			
		System.out.println("Hi"+questionRepository.findByUsersQuestionAndAnswerByUserId(id));
		List<Object> questionEntity= questionRepository.findByUsersQuestionAndAnswerByUserId(id);	
		return (List<Object>)questionEntity;
		
			
			
		}else
		{
			throw new ResourceNotFoundException("Not Found ");
		}
		
		
		
		
	}
	
	
}
