package com.springrestapi.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.ApiLoggerEntity;
import com.springrestapi.repo.ApiLoggerRepo;
import com.springrestapi.service.ApiLoggerServiceInterface;

@Service
public class ApiLoggerServiceImpl implements ApiLoggerServiceInterface{

	@Autowired
	private ApiLoggerRepo apiLoggerRepo;
	
	@Override
	public void createApiLog(ApiLoggerEntity apiLoggerEntity) {
		// TODO Auto-generated method stub
		System.out.println("check impl  "+apiLoggerEntity);
		apiLoggerRepo.save(apiLoggerEntity);
		
	}

	public ApiLoggerServiceImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
