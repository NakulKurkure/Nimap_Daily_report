package com.springrestapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@SpringBootApplication

public class CrudRestapiApplication {

	
//	
	public static void main(String[] args) {
		SpringApplication.run(CrudRestapiApplication.class, args);
	}

	
	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}
}
