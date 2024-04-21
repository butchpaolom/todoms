package com.todo.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
 
@Service
public class JWTGenerator {

	@Autowired
	private JWTConfiguration jwtConfig;
	
	public String generateJWT(String subject) {

		var issuedAt = new Date();
		var expiration = new Date(issuedAt.getTime() + jwtConfig.getExpiration());
		
		String token = Jwts.builder()
				.subject(subject)
				.signWith(jwtConfig.getSecretKeySpec())
				.issuedAt(issuedAt)
				.expiration(expiration)
				.compact();
		
		return token;
	}
}
