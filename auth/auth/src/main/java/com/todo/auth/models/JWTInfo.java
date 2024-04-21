package com.todo.auth.models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class JWTInfo {
	private String accessToken;
	private String refreshToken;
}
