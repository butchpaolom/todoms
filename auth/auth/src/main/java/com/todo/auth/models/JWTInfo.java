package com.todo.auth.models;

import lombok.Data;

@Data
public class JWTInfo {
	private String accessToken;
	private String refreshToken;
}
