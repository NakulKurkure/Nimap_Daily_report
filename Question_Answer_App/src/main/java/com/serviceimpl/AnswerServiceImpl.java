package com.serviceimpl;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dto.AnswerDto;
import com.dto.QuestionDto;
import com.entity.AnswerEntity;
import com.entity.QuestionEntity;
import com.entity.RoleEntity;
import com.entity.UserEntity;
import com.entity.UserRoleEntity;
import com.entity.UserRoleId;
import com.exception.ResourceNotFoundException;
import com.repository.AnswerRepository;
import com.repository.QuestionRepository;
import com.repository.RoleRepository;
import com.repository.UserRepository;
import com.repository.UserRoleRepository;
import com.security.JwtTokenUtil;
import com.serviceInterface.AnswerInterface;
import com.serviceInterface.IAnswerListDto;
import com.serviceInterface.IUserListDto;
import com.util.Pagination;

@Service
public class AnswerServiceImpl implements AnswerInterface{

	@Autowired
	private AnswerRepository answerRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Autowired
	private RoleRepository roleRepository;
	
	
	@Override
	public AnswerDto addAnswer(AnswerDto answerDto,HttpServletRequest request) {
	
		AnswerEntity answerEntity=new AnswerEntity();
		answerEntity.setAnswer(answerDto.getAnswer());
		
		QuestionEntity QuestionEntity=questionRepository.findById(answerDto.getQuestion_id()).orElseThrow(()->new ResourceNotFoundException("Not Found Question Id.."));
		
		answerEntity.setQuestion_Id(QuestionEntity);
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email 
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
//		//check on repo.
		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
//		
//		Long id=userEntity.getId();
		
		answerEntity.setUserId(userEntity);
	
		answerRepository.save(answerEntity);
		return answerDto;
		
	}

	@Override
	public AnswerDto updatedAnswer(AnswerDto answerDto, Long id,HttpServletRequest request) {
		
		try
		{
			
		
		AnswerEntity answerEntity=answerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
		
//		QuestionEntity questionEntity=questionRepository.findById(answerDto.getQuestion_id()).orElseThrow(()-> new ResourceNotFoundException("Not Found Question Id.."));
		
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email 
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
//		//check on repo.
		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		
		answerEntity.setUserId(userEntity);
		answerEntity.setAnswer(answerDto.getAnswer());
//		answerEntity.setQuestion_Id(questionEntity);
		
		answerRepository.save(answerEntity);
		}
		catch(Exception e)
		{
			throw new ResourceNotFoundException("Not Found Id..");
		}
		
		return answerDto;
		
		
	}

	@Override
	public AnswerDto getByAnswerId(Long id,HttpServletRequest request) {
		
		AnswerEntity answerEntity=answerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Not Found Id"));
		

		AnswerDto answerDto=new AnswerDto();
		answerDto.setAnswer(answerEntity.getAnswer());
		answerDto.setQuestion_id(answerEntity.getQuestion_Id().getId());
	
		return answerDto;
		
		
		
	}

	@Override
	public void deleteAnswerById(Long id,HttpServletRequest request) {
	
		AnswerEntity answerEntity= answerRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("not Found Answer Id.."));
		
		final String header=request.getHeader("Authorization");
		String requestToken=header.substring(7);
//		//email 
		final String email=jwtTokenUtil.getUsernameFromToken(requestToken);
//		//check on repo.
		UserEntity userEntity=userRepository.findByEmailContainingIgnoreCase(email);
		
		
		Long userId=userEntity.getId();
		System.out.println("userId"+userId);
		
		
		
		UserRoleEntity userRoleEntity= this.userRoleRepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("Not Found Id.."));
		System.out.println("userId22"+userRoleEntity);
		
		RoleEntity roleEntity=userRoleEntity.getPk().getRoles();
		System.out.println("roleEntity"+roleEntity.getId());
		RoleEntity roleEntity1=roleRepository.findById(roleEntity.getId()).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId.."));
		
		System.out.println("roleEntity1"+roleEntity.getId());
		String roleName=roleEntity1.getRoleName();
		
		if(roleName.equals("Admin") && userId.equals(answerEntity.getUserId()))
		{
			answerRepository.deleteById(id);
		}
		else
		{
			throw new ResourceNotFoundException("Cannot Access.. Call To Admin..");
		}
		
		
		
		
		
		
		
		
		
//		UserRoleEntity userRoleEntity1= this.userRoleRepository.findById(userRoleEntity).orElseThrow(()-> new ResourceNotFoundException("Not Found Id.."));

//		
		
	}



	@Override
	public Page<IAnswerListDto> getAllAnswers(String search, String pageNumber, String pageSize) {
		
		
		Pageable pagable=new Pagination().getPagination(pageNumber, pageSize);
		if((search=="")||(search==null)||(search.length()==0))
		{
			return answerRepository.findByOrderById(pagable,IAnswerListDto.class);
		}
		else
		{
			return  answerRepository.findByAnswer(search,pagable,IAnswerListDto.class);
		}
		
	
	}

}
