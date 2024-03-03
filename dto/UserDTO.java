package com.app.dto;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UserDTO {
	@JsonProperty(access = Access.READ_ONLY) // used during serialization
	private Long id;
	@NotBlank
	private String name;
	@Email
	private String email;
	@JsonProperty(access = Access.WRITE_ONLY) //required only in de-ser.
	private String password;
	@JsonProperty(access = Access.WRITE_ONLY)
	private String confirmPassword;
	@NotBlank
	private String mobileNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate Date;
	private UserType type;
	
}
