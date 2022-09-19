

package com.springrestapi.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import com.springrestapi.interceptor.ExcecutionInterceptor;
import com.springrestapi.security.JwtAuthenticationEntryPoint;
import com.springrestapi.security.JwtAuthenticationFilter;
import com.springrestapi.security.UserDetailService;

//Basic Authentication  first call UserDeatailService
//@Configuration annotation which indicates that the class has @Bean definition methods
@Configuration
@EnableWebSecurity
@EnableWebMvc
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//

	public static final String[] PUBLIC_URLS= {"/auth/login","/auth/register",
			"v3/api-docs", "/v2/api-docs",
					"/swagger-resources","swagger-ui","/webjars"};
	
	
	@Autowired
	private UserDetailService userDetailService;
//
	@Autowired
	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
////
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;


	@Override
	//Basic Authentication Configure
	protected void configure(HttpSecurity http) throws Exception {
//
//		// We don't need CSRF for this example
		http

		.csrf()
		.disable()
//				// dont authenticate this particular request
		.authorizeHttpRequests()
		//Url Public  (/auth/login)
		.antMatchers(PUBLIC_URLS)
		
		
		.permitAll()
		
		.anyRequest()
		.authenticated()
		.and()
		
		.exceptionHandling()
		//jwtAuthenticationEntryPoint set
		.authenticationEntryPoint(this.jwtAuthenticationEntryPoint)
		.and()


		//set Policy STATELESS is NOt stored in server
		.sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);

		//Set jwtAuthenticationFilter
		//pass Filter Class UsernamePasswordAuthenticationFilter
		http
		.addFilterBefore(this.jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


	}

	@Override
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.userDetailsService(this.userDetailService).passwordEncoder(passwordEncoder());

	} 

	
	//password stored backend form BCryptPasswordEncoder
	@Bean
	public PasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	}


	//Bean Declare for Login For Authenticate Password
	//Get Bean
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {

		return super.authenticationManagerBean();
	}


}