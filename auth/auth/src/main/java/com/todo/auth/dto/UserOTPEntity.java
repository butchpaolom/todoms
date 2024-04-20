package com.todo.auth.dto;

import lombok.Data;

@Data
public class UserOTPEntity {
	private String email;
	private String otp;
}
