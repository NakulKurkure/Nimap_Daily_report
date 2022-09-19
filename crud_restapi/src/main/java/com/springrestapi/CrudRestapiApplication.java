package com.springrestapi;

import org.modelmapper.ModelMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.springrestapi.properties.FileStorageUploadProperty;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@ComponentScan({ "com.springrestapi.*" })
@EnableCaching
@EnableSwagger2
@EnableConfigurationProperties({FileStorageUploadProperty.class})
//@Import(BeanValidatorPluginsConfiguration.class)
public class CrudRestapiApplication {

	public static void main(String[] args) {
		System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(CrudRestapiApplication.class, args);
	}
	
	
	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}

	@Bean
	   public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.springrestapi")).build();
	   }
	



//For Test in commandLineRunner method overrides the method run..
	//so we just print on console so we encode it..


//password :-Nakul is Encrypt in form $2a$10$M2IlyheCjD9HJ2nhFGRfeeyeFPqCU6x0F253XVU4F0w.IUV7pwNX2


	
//	public User add(User user)
//	{
//		String encode=this.passwordEncoder.encode(user.getPassword());
//		user.setPassword(encode);
//		return this.add(user);
//	}


}
