package com.todo.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.auth.models.UserEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
	public boolean existsByEmail(String email);
}
