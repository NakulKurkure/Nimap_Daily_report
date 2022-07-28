//package com.springrestapi.config;
//
//import java.io.IOException;
//import java.nio.charset.MalformedInputException;
//
//import javax.servlet.FilterChain;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
////import com.springrestapi.service.UserDetailService;
//
//import io.jsonwebtoken.ExpiredJwtException;
//import io.jsonwebtoken.MalformedJwtException;
//

//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter{
//
//	@Autowired
//	private JwtTokenUtil jwtTokenUtil;
//	
////	@Autowired
//	@org.springframework.beans.factory.annotation.Autowired(required=true)
//
//	private UserDetails userDetails;
//	
//	
	
//	@Autowired
//	private UserDetailService userDetalService;
	
	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		
//		//get Token form request
//		String requestToken=request.getHeader("Authorized");
//		
//		//Bearer 2343333jdhd
//		
//		System.out.print(requestToken);
//		
//		
//		String username=null;
//		
//		String token=null;
//		
//		if(request!=null && requestToken.startsWith("bearer"))
//		{
//			token=requestToken.substring(7);
//			
//			try
//			{
//				//get username from Token
//				username=this.jwtTokenUtil.getUserNameFromToken(token);
//			}catch(IllegalArgumentException e)
//			{
//				System.out.print(e);
//			}catch(ExpiredJwtException e)
//			{
//				System.out.print(e);
//			}catch(MalformedJwtException e)
//			{
//				System.out.print(e);
//			}
//			
//			
//			
//		}else
//		{
//			System.out.print("Not begain with bearer");
//		}
//		
		
		//once get Token then validate
		
//		if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null)
//		{
////			UserDetailService userDetalService=(UserDetailService) this.userDetalService.loadUserByUsername(username);
//			if(this.jwtTokenUtil.validateToken(token, userDetails))
//			{
//				
//			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(token, null,this.userDetails.getAuthorities());
//			usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//				SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
//			
//		}else
//		{
//			System.out.println("Invalid jwt Token");
//		}
//	}
//		else
//		{
//			System.out.println("Username is null,Invalid jwt Token");
//		}
//
//		filterChain.doFilter(request, response);
//	}
//	
//}
