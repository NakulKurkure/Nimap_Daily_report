package com.springrestapi.security;
//package com.springrestapi.config;

import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.springrestapi.entity.User;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
//
//@Service
@Component
public class JwtTokenUtil implements Serializable{
	private static final long serialVersionUID = -2550185165626007488L;

	public static final long JWT_TOKEN_VALIDITY = 5 * 60 * 60;

	public static final long JWT_TOKEN_VALIDITY_FORGOT_PASS = 5 * 60;

//	@Value("NimapSBAssignment")
	private String secret="Authorization";


//Get Username from jwt Token
	public String getUserNameFromToken(String token) {
//
		return getClaimFromToken(token, Claims::getSubject);
//
	}

	// retrieve expiration date from jwt token
	public Date getExpirationDateFromToken(String token) {

		return getClaimFromToken(token, Claims::getExpiration);

	}

	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {

		final Claims claims = getAllClaimsFromToken(token);
		return claimsResolver.apply(claims);

	}

	// for retrieveing any information from token we will need the secret key
	private Claims getAllClaimsFromToken(String token) {

		return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();

	}

	// check if the token has expired
	private Boolean isTokenExpired(String token) {

		final Date expiration = getExpirationDateFromToken(token);
		return expiration.before(new Date());

	}
	// check if the token has expired
	// public Boolean isTokenExpiredpubl(String token) {
	// final Date expiration = getExpirationDateFromToken(token);
	// return expiration.before(new Date());
	// }

	// generate token for user
	public String generateToken(User userDetails) {

		Map<String, Object> claims = new HashMap<>();
		return doGenerateToken(claims, userDetails.getUsername());

	}
	
//	public String generateToken(String username) {
//
//		Map<String, Object> claims = new HashMap<>();
//		return doGenerateToken(claims, username);
//
//	}



	// while creating the token -
	// 1. Define claims of the token, like Issuer, Expiration, Subject, and the ID
	// 2. Sign the JWT using the HS512 algorithm and secret key.
	// 3. According to JWS Compact
	// Serialization(https://tools.ietf.org/html/draft-ietf-jose-json-web-signature-41#section-3.1)
	// compaction of the JWT to a URL-safe string
	private String doGenerateToken(Map<String, Object> claims, String subject) {

		return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + (JWT_TOKEN_VALIDITY * 1000))).signWith(SignatureAlgorithm.HS512, secret).compact();

	}


	// validate token
	public Boolean validateToken(String token, UserDetails userDetails) {

		final String username=getUserNameFromToken(token);
		return (username.equals(userDetails.getUsername()))&!isTokenExpired(token);

		// throw new ResourceNotFoundException("Timeout for this request");
	}
}
