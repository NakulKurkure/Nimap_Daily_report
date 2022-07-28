package com.springrestapi;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.boot.autoconfigure.SpringBootApplication ;

@SpringBootApplication
public class CrudRestapiApplication {

//	@Autowired
//	private PasswordEncoder passwordEncoder;
////	
	public static void main(String[] args) {
		SpringApplication.run(CrudRestapiApplication.class, args);
	}

	
	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}


////	@Override
//	@Bean
//	public void run(String... args) throws Exception {
//	
//		System.out.print(this.passwordEncoder.encode("xyz"));
//	}
}
