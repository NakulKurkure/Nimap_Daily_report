package com.springrestapi;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class CrudRestapiApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(CrudRestapiApplication.class, args);
	}


	@Bean
	public ModelMapper modelmapper()
	{
		return new ModelMapper();
	}





//For Test in commandLineRunner method overrides the method run..
	//so we just print on console so we encode it..


//password :-Nakul is Encrypt in form $2a$10$M2IlyheCjD9HJ2nhFGRfeeyeFPqCU6x0F253XVU4F0w.IUV7pwNX2

	@Override
	public void run(String... args) throws Exception {

		System.out.println(this.passwordEncoder.encode("nakul"));
	}


}
