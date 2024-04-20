package com.todo.auth.services;

import com.todo.auth.models.UserEntity;

public interface UserServiceInterface {
	public boolean sendOTP(UserEntity user);
}
