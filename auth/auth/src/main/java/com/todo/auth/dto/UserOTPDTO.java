package com.todo.auth.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class UserOTPDTO {
	@Pattern(regexp="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$")
	@Schema(example="test@email.com")
	private String email;
	@Pattern(regexp="[A-Z0-9]{6}")
	private String otp;
}
