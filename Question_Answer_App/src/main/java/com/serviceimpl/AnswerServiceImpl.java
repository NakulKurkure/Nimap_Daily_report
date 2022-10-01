package com.serviceimpl;


import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.stereotype.Service;

import com.dto.AnswerDto;

import com.entity.AnswerEntity;
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
import com.serviceInterface.AnswerInterface;
import com.serviceInterface.IAnswerListDto;
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
//		answerEntity.setIs_draft(answerDto.isIs_draft());
		
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
//		answerEntity.setIs_draft(answerDto.isIs_draft());
		
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
		
		Long user_id=userEntity.getId();
		System.out.println("userId"+user_id);
		
		
		
		UserRoleEntity userRoleEntity= userRoleRepository.findByUserById(user_id);
		System.out.println("userRoleEntity1111");
		System.out.println("Id"+answerEntity.getUserId().getId().equals(user_id));
		

		if(((answerEntity.getUserId().getId().equals(user_id))))
		{
			answerRepository.deleteById(id);
			return;
		}
		else {
			Long roleEntityId=userRoleEntity.getPk().getRoles().getId();
			System.out.println(""+userRoleEntity.getPk().getRoles().getId());
			RoleEntity roleEntity1=roleRepository.findById(roleEntityId).orElseThrow(()-> new ResourceNotFoundException("Not Found RoleId.."));
			
			System.out.println("roleEntity1"+roleEntity1.getRoleName());
			String roleName=roleEntity1.getRoleName();
			if(roleName.equals("Admin"))
			{
				answerRepository.deleteById(id);
				return;

			}
			
		}
		throw new ResourceNotFoundException("Cannot Access.. Only Access to Admin the Delete Records..");

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

	@Override
	public List<AnswerEntity> getByAnswerIdGetAll(Long id, HttpServletRequest request) {

		List<AnswerEntity> ans =answerRepository.findAll();
		return ans;

		
	}

	@Override
	public List<AnswerEntity> GetAll() {
		
		List<AnswerEntity> ans=answerRepository.findAll();
		
		return ans;
	}

	

}
