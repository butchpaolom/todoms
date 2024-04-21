package com.todo.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.auth.models.JWTInfo;
import com.todo.security.JWTGenerator;

@Service
public class JWTService {
	
	@Autowired
	private JWTGenerator jwtGenerator;
	
	public JWTInfo createJWT(String id) {
		String token = jwtGenerator.generateJWT(id);
		
		return JWTInfo.builder().accessToken(token).build();
	}	
}
