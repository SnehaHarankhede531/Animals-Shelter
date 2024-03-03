package com.app.dto;

import java.time.LocalDate;

import com.app.entities.PaymentStatus;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PaymentsDTO {
private String transId;
	
	private double amount;
	
	private PaymentStatus pays;
	
	private LocalDate date;
}