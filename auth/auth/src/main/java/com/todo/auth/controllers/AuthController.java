package com.todo.auth.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.auth.dto.LoginDTO;
import com.todo.auth.dto.UserOTPEntity;
import com.todo.auth.models.JWTInfo;
import com.todo.auth.models.UserEntity;
import com.todo.auth.services.OTPService;
import com.todo.auth.services.UserService;

@RestController
@RequestMapping("/api")
public class AuthController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private OTPService otpService;
	
	@PostMapping("/login")
	public LoginDTO login(@RequestBody UserEntity user) {	
		return userService.login(user);
	}
	
	@PostMapping("/verifyOTP")
	public JWTInfo verifyOTP(@RequestBody UserOTPEntity user) {
		return otpService.verifyOTP(user);
	}
}
