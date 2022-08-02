package com.springrestapi.security;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
//package com.springrestapi.config;
import org.springframework.stereotype.Component;
//
@Component
// @Component indicates that a class might be a candidate for creating a bean.
//@Component is an annotation that allows Spring to automatically detect our custom beans.
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint{
//
	@Override
public void commence(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException authException) throws IOException, ServletException {
		// TODO Auto-generated method stub

	response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "access denited");
}
}

