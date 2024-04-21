package com.todo.security;

import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@Configuration
@Data
public class JWTConfiguration {
	
	private SecretKeySpec secretKeySpec;
	
	@Value("${jwt.expiration}")
	private Long expiration;
	
	@Value("${jwt.algorithm}")
	private String algorithm;
	
	@Value("${jwt.key}")
	private String key;
	
	public SecretKeySpec getSecretKeySpec() {
		if (this.secretKeySpec==null)
			this.secretKeySpec =  new SecretKeySpec(this.getKey().getBytes(), this.getAlgorithm());
		return this.secretKeySpec;
	}
}
