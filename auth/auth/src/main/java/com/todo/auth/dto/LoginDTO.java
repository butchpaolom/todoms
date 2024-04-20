package com.todo.auth.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginDTO {
	private UserType userType;
	private boolean otpSent;
}
