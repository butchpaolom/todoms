package com.todo.auth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.todo.security", "com.todo.auth.*"})
public class AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthApplication.class, args);
	}

}
