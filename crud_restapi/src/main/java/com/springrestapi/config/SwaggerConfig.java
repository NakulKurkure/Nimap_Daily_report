package com.springrestapi.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.spring.web.plugins.plugins.Dok
@EnableWebMvc
@Configuration
@Component
public class SwaggerConfig {

	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2)
				.apiInfo(getInfo()).select().apis(RequestHandlerSelectors.any()).paths(PathSelectors.any()).build();
		
	}

	private ApiInfo getInfo() {
		// TODO Auto-generated method stub
		
		
		return new ApiInfo("Blogging Application", "This Project developed by Nakul", "1.0", "Terms of service", "http://www.google.com", "APIS ", " Apis");
	}
}
