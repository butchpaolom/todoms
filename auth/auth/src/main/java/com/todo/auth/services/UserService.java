package com.todo.auth.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.todo.auth.dto.LoginDTO;
import com.todo.auth.dto.UserType;
import com.todo.auth.models.UserEntity;
import com.todo.auth.repository.UserRepository;

@Service
public class UserService implements UserServiceInterface{

	@Autowired
	private UserRepository userRepository;
	
	public Optional<UserEntity> findUser(String email) {
		return userRepository.findByEmail(email);
	}
	
	public boolean sendOTP(UserEntity user) {
		return true;
	}
	
	public LoginDTO login(UserEntity user) {
		boolean exists = userRepository.existsByEmail(user.getEmail());
		if (!exists) userRepository.save(user);
		return LoginDTO.builder().otpSent(sendOTP(user))
				.userType(exists ? UserType.EXISTING : UserType.NEW)
				.build();
	}
}
