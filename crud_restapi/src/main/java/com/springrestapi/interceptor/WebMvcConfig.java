package com.springrestapi.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.app.interceptors.ApiLogger;

@Configuration
//The @EnableWebMvc annotation is used for enabling Spring MVC in an application
@EnableWebMvc

public class WebMvcConfig implements WebMvcConfigurer{

	public WebMvcConfig() {
		
	}
	
	@Autowired
	private ExcecutionInterceptor excecutionInterceptor;
	


	public void addInterceptors(InterceptorRegistry interceptorRegistry)
	{
		interceptorRegistry.addInterceptor(excecutionInterceptor);
	}
}
