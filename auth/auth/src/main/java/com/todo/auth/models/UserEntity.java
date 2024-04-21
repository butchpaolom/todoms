package com.todo.auth.models;


import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;

@Data
@Entity
@Builder
public class UserEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonIgnore
	private Long id;
	@Pattern(regexp="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
	@Schema(example="test@email.com")
	private String email;
	@JsonIgnore
	private String otp;
}
