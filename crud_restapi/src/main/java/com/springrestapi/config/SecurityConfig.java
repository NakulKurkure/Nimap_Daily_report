

package com.springrestapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.config.BeanIds;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
////import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.annotation.web.configurers.HttpBasicConfigurer;
//import org.springframework.security.config.authentication.AuthenticationManagerBeanDefinitionParser;
//import org.springframework.security.config.http.SessionCreationPolicy;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
//
//import static org.springframework.security.config.Customizer.withDefaults;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//
//
@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
////	@Autowired
////    private AuthenticationManager authenticationManager;
//
//	@Autowired
//	private UserDetailsService userDetailsService;
//	
//	@Autowired
//	private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
//	
//	@Autowired
////	private JwtAuthenticationFilter jwtAuthenticationFilter;
//	
//	@Bean
//	public UserDetailsService jwtuserDetailsService() {
//
//		return super.userDetailsService();
//
//	}
//	
//	

//	@Override
	protected void configure(HttpSecurity http) throws Exception {
//
//		// We don't need CSRF for this example
		http
		
		.csrf()
		.disable()
//				// dont authenticate this particular request
		.authorizeHttpRequests()
////		.antMatchers("/auth/v1/auth/login")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
////		.permitAll()
////		.anyRequest()
////	
//	
//				// all other requests need to be authenticated
//		
////		.authenticated()
////		.and()
////		.exceptionHandling()
////		
//		
//				// make sure we use stateless session; session won't be used to
//				// store user's state.
//		
//		
//	}
//	
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//
//		auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
//
//	}
//	
//	@Bean
//	public BCryptPasswordEncoder passwordEncoder() {
//	    return new BCryptPasswordEncoder();
//	}
//	
//	
//
////	@Bean
////	public UserDetailsService userDetailsService() {
////	    return super.userDetailsService();
////	}
//
//	@Bean
//	public AuthenticationManager authenticationManagerBean() throws Exception {
//	    return super.authenticationManagerBean();
//	}
//	
//           
//               
//
//	
}
}