package com.job.Interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.job.entity.User;
import com.job.repository.UserRepository;
import com.job.security.JwtTokenUtil;

@Component
public class AuthLogger implements HandlerInterceptor {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserRepository userRepository;

	public final static String UserId = "user-id";

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String authHeader = request.getHeader("Authorization");
		String tokenString = (null != authHeader) ? authHeader.split(" ")[1] : null;

		if (null != tokenString) {
			final String emailString = jwtTokenUtil.getUsernameFromToken(tokenString);
			System.out.println("EmailString" + emailString);

			User user = userRepository.findByEmail(emailString);

			System.out.println("EmailString" + user.getUserId());
			request.setAttribute("user-id", user.getUserId());

		}
		return HandlerInterceptor.super.preHandle(request, response, handler);
	}
}
