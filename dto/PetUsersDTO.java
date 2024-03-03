package com.app.dto;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.springframework.format.annotation.DateTimeFormat;

import com.app.entities.Pets;
import com.app.entities.UserType;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PetUsersDTO {
	
	@JsonProperty(access=Access.READ_ONLY)
	private Long Id;
	private String name;
	@Column(unique = true, length=30)
	private String email;
	@Column(length = 8)
	private String password ;
	@Column(length = 10)
	private String mobileNumber;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private UserType type;
	@OneToMany(mappedBy="user",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Pets> pets=new ArrayList<>();
	

}
