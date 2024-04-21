package com.todo.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.auth.dto.UserOTPDTO;
import com.todo.auth.models.JWTInfo;
import com.todo.auth.models.UserEntity;

@Service
public class OTPService {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private JWTService jwtService;
	
	public boolean verifyOTP(UserOTPDTO user) {
		Optional<UserEntity> optionalUser = userService.findUser(user.getEmail());
		if (optionalUser.isEmpty()) return false;
		var actualUser = optionalUser.get();
		UserContext.setId(actualUser.getId());
		if (actualUser.getOtp().equals(user.getOtp())) return true;
		return false;
	}

	public JWTInfo verifyOTPandCreateToken(UserOTPDTO user) {
		if (verifyOTP(user)) return jwtService.createJWT(UserContext.getId().toString());
		return null;
	}
}
