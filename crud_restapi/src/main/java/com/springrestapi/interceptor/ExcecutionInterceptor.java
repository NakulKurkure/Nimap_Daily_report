package com.springrestapi.interceptor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

//import java.util.logging.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.gson.GsonAutoConfiguration;
//import org.slf4j.ILoggerFactory;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.springrestapi.entity.ApiLoggerEntity;
import com.springrestapi.entity.LoggerEntity;
import com.springrestapi.exception.Errordetails;
import com.springrestapi.service.ApiLoggerServiceInterface;
import com.springrestapi.service.LoggerServiceInterface;

@Component
public class ExcecutionInterceptor implements HandlerInterceptor{

	@Autowired
	private LoggerServiceInterface loggerServiceInterface;
	
	@Autowired
	private ApiLoggerServiceInterface apiLoggerServiceInterface;
	
	public ExcecutionInterceptor() {
		super();
		// TODO Auto-generated constructor stub
	}
//Gson is an open-source Java library to serialize and deserialize Java objects to JSON.
	Gson gson=new Gson();

	
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		
		ArrayList<String> url=new ArrayList<>(Arrays.asList("/auth/login","/auth/register"));
		
		final String requestUrl=request.getRequestURI();
		System.out.println("url -- "+ requestUrl);
		final String header=request.getHeader("Authorization");
		System.out.println("Url Header"+request.getHeader("Authorization"));
		
		if(!url.contains(requestUrl))
		{
		final String requestHeader=(null !=header ) ?header.split(" ")[1]:null ;
			LoggerEntity logDetails=loggerServiceInterface.getLoggerDetails(requestHeader);

			System.out.println("check 1"+logDetails);
//			
			if(logDetails==null)
			{
				System.out.println("check 2");
				Errordetails errorDetails=new Errordetails(new Date(), "User Not Log In", "Not LogIn");
				String employeeJsonString = this.gson.toJson(errorDetails);
				response.setContentType("application/json");
				response.setCharacterEncoding("UTF-8");
				response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
				response.getWriter().write(employeeJsonString);

				return false;
			}
			else
			{
				
				ApiLoggerEntity apiLoggerEntity=new ApiLoggerEntity();
				System.out.println("check 34 "+apiLoggerEntity);
				apiLoggerEntity.setToken(header);
				apiLoggerEntity.setMethod(request.getMethod());
				apiLoggerEntity.setUrl(request.getRequestURI());
				apiLoggerEntity.setHost(request.getRemoteHost());
				apiLoggerEntity.setIpAddress(request.getRemoteAddr());
				this.apiLoggerServiceInterface.createApiLog(apiLoggerEntity);
				return true;
			}
//			
//			
		}else
		{
			System.out.println("check 4--");
			ApiLoggerEntity apiLoggerEntity=new ApiLoggerEntity();
			apiLoggerEntity.setToken("");
			apiLoggerEntity.setMethod(request.getMethod());
			apiLoggerEntity.setUrl(requestUrl);
			apiLoggerEntity.setHost(request.getRemoteHost());
			apiLoggerEntity.setIpAddress(request.getRemoteAddr());
			this.apiLoggerServiceInterface.createApiLog(apiLoggerEntity);
			return true;
		}
//		return true;
		
		
	
		

	}
	

	
	
}
