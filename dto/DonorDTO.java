package com.app.dto;

import java.util.List;

import javax.persistence.Column;

import com.app.entities.Payment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Setter
@Getter
public class DonorDTO {
	private String name;
	@Column(unique = true, length=30)
	private String email;
	@Column(length = 10)
	private String mobileNumber;
	private String address;
}
