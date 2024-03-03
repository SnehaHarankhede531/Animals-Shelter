package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="Payment")
@ToString(exclude="Donor")
public class Payment extends BaseEntity{
	//trac id,amount,payment status,date
	@Column(length=30)
	private String transId;
	
	private double amount;
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private PaymentStatus pays;
	
	private LocalDate date;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="donor_id")
	private Donor donor;
	public Payment(String transId, double amount, PaymentStatus pays, LocalDate date) {
		super();
		this.transId = transId;
		this.amount = amount;
		this.pays = pays;
		this.date = date;
	}
	
	

}
