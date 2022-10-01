package com.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.ErrorResponseDto;
import com.dto.QuestionDto;
import com.dto.SuccessResponseDto;
import com.dto.UserQuestionRequestDto;
import com.entity.QuestionEntity;
import com.entity.RoleEntity;
import com.entity.UserEntity;
import com.entity.UserQuestionEntity;
import com.entity.UserQuestionId;
import com.entity.UserRoleEntity;
import com.entity.UserRoleId;
import com.exception.ResourceNotFoundException;
import com.repository.QuestionRepository;
import com.repository.UserQuestionRepository;
import com.repository.UserRepository;
import com.repository.UserRoleRepository;
import com.security.JwtTokenUtil;
import com.serviceInterface.UserQuestionInterface;

@Service
public class UserQuestionImpl implements UserQuestionInterface{

	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserQuestionRepository userQuestionRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public void addUserQuestion(UserQuestionRequestDto userQuestionRequestDto) {
	
		try
		{
			
		
		ArrayList<com.entity.UserQuestionEntity> userQuestions = new ArrayList<>();

		UserEntity userId=this.userRepository.findById(userQuestionRequestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));

		QuestionEntity questionEntityId=this.questionRepository.findById(userQuestionRequestDto.getQuestionId()).orElseThrow(()-> new ResourceNotFoundException("Not Found questionId"));

		UserQuestionEntity userQuestionEntity=new UserQuestionEntity();
		UserQuestionId userRoleId=new UserQuestionId(userId,questionEntityId);
		userQuestionEntity.setPk(userRoleId);

		userQuestions.add(userQuestionEntity);
		//save in database
		userQuestionRepository.saveAll(userQuestions);
}
	catch(Exception e)
	{
		System.out.println("Invalid QuestionId and UserId....");
		e.printStackTrace();
		throw new ResourceNotFoundException("NOt Found..");


	}

		
	}

	@Override
	public void updateUserQuestion(UserQuestionRequestDto userQuestionRequestDto) {
		
		ArrayList<com.entity.UserQuestionEntity> userQuestions = new ArrayList<>();
		
		UserEntity userId=this.userRepository.findById(userQuestionRequestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));

		QuestionEntity questionEntityId=this.questionRepository.findById(userQuestionRequestDto.getQuestionId()).orElseThrow(()-> new ResourceNotFoundException("Not Found questionId"));
		
		UserQuestionEntity userQuestionEntity=new UserQuestionEntity();
		UserQuestionId userRoleId=new UserQuestionId(userId,questionEntityId);
		userQuestionEntity.setPk(userRoleId);

		userQuestions.add(userQuestionEntity);
		//save in database
		userQuestionRepository.updateUserQuestion(userId.getId(),questionEntityId.getId());
}

	@Override
	public void deleteUserQuestion(UserQuestionRequestDto userQuestionRequestDto) {
		
		UserEntity userId =this.userRepository.findById(userQuestionRequestDto.getUserId()).get();
		QuestionEntity questionEntityId =this.questionRepository.findById(userQuestionRequestDto.getQuestionId()).get();
		UserQuestionId userQuestionId=new UserQuestionId(userId, questionEntityId);
		UserQuestionEntity userQuestionEntity=new UserQuestionEntity();
		userQuestionEntity.setPk(userQuestionId);
		this.userQuestionRepository.delete(userQuestionEntity);
		
		
		
	}

	@Override
	public List<UserQuestionEntity> getAllUserQuestions() {
		
		List<UserQuestionEntity> userQuestion=this.userQuestionRepository.findAll();
		
		return userQuestion;
	}

//	@Override
//	public QuestionDto updateQuestionByUserId(QuestionDto questionDto, Long id,HttpServletRequest request) {
//
////		UserEntity userId=this.userRepository.findById(userQuestionRequestDto.getUserId()).orElseThrow(()-> new ResourceNotFoundException("Not Found UserId"));
////
////		QuestionEntity questionEntityId=this.questionRepository.findById(userQuestionRequestDto.getQuestionId()).orElseThrow(()-> new ResourceNotFoundException("Not Found questionId"));
////		
//		
//		final String header=request.getHeader("Authorization");
//		String requestToken=header.substring(7);
////		//email 
//		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
////		//check on repo.
//		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
//		
//		Long user_id=userEntity.getId();
//		System.out.println("userId"+user_id);
//		
//		
//		
//		UserQuestionEntity userQuestionEntity= userQuestionRepository.findByUserById(user_id);
//		System.out.println("userRoleEntity1111");
//		
//		Long userQuestionId=userQuestionEntity.getPk().getQuestions().getId();
//		System.out.println(""+userQuestionEntity.getPk().getQuestions().getId());
//		
//		QuestionEntity questionEntity1=questionRepository.findById(userQuestionId).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId.."));
//
//		Long ids=questionEntity1.getId();
//		
//		if(user_id.equals(userQuestionId))
//		{
//			
//		}
//		
//		
//		
//		
//		
//		
////		System.out.println("Id"+answerEntity.getUserId().getId().equals(user_id));
//		
//		
//		
//		
//		return null;
//	}
	
	}


