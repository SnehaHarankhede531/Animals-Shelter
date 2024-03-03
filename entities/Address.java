package com.app.entities;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="user_adr")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Address extends BaseEntity {
	@Column(length=30)
	private String street;
	@Column(length=20)
	private String city;
	@Column(length=20)
	private String state;
	@Column(length=20)
	private String country;
	@Column(length=20,name="zip_code")
	private String zipCode;
	
	@OneToOne (fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	@MapsId
	private User owner;
	public Address(String street, String city, String state, String country, String zipCode) {
		super();
		this.street = street;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipCode = zipCode;
	}	
	
}
