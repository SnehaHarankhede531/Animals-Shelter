
package com.app.dto;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotBlank;

import com.app.entities.Breed;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PetDTO {
	@JsonProperty(access=Access.READ_ONLY)
	private Long id;
	@NotBlank
	private int age;
	@NotBlank
	private String color;
	@NotBlank
	private Breed breed;
	
	private boolean isAvailable=false;
	@NotBlank
	private Long userId;

}
