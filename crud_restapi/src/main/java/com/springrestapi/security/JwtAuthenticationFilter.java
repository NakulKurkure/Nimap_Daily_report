package com.springrestapi.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
//
	@Autowired
	private com.springrestapi.security.JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UserDetailService userDetailService;


	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
//		// TODO Auto-generated method stub

		//get Token form request
		String requestToken=request.getHeader("Authorization");
//
		//Token
//		//Bearer 2343333jdhd
//
		System.out.print(requestToken+"nakkk");
//
//	//In  token :- fetch Username
		String username=null;
//
		// and Token--2343333jdhd
		String token=null;
//

		//
		if(requestToken!=null && requestToken.startsWith("Bearer"))
		{
			token=requestToken.substring(7);

			try
			{
				//get username from Token then handle Exception
				username=this.jwtTokenUtil.getUserNameFromToken(token);
			}catch(IllegalArgumentException e)
			{
				System.out.print(e);
			}catch(ExpiredJwtException e)
			{
				System.out.print(e);
			}
			catch(MalformedJwtException e)
			{
				System.out.print(e);
			}



		}else
		{
			System.out.print("Not begain with bearer");
		}


		//once get Token then validate then set Authentication
		//Is value in token or not check/////////////////////in whatever api heats then always check
		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
		{
			UserDetails userDetails=this.userDetailService.loadUserByUsername(username);

			
			//validate
			if(this.jwtTokenUtil.validateToken(token, userDetails))
			{
				//set UsernamePasswordAuthenticationToken

			//Authentication Object
				/////////////////////////////////////////

			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(token,userDetails);
			//Detail Set
			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			//Set Authentication
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//
		}else
		{
			System.out.println("Invalid jwt Token");
		}
	}
		else
		{
			System.out.println("Username is null,Invalid jwt Token");
		}

		//In DoFilterInternal Method --so Filter Request
		filterChain.doFilter(request, response);
	}
//
}
