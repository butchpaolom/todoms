package com.todo.taskcore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TaskcoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskcoreApplication.class, args);
	}

}
