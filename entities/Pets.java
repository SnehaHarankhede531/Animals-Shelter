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
@Table(name="Pets")
@ToString(exclude="User")
public class Pets extends BaseEntity{
	
	private int age;
	@Column(length=30)
	private String color;
	
	@Enumerated(EnumType.STRING)
	@Column(length=30)
	private Breed breed;
	
	private boolean isAvailable=false;
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User user;
	public Pets(int age, String color, Breed breed, boolean isAvailable) {
		super();
		this.age = age;
		this.color = color;
		this.breed = breed;
		this.isAvailable = isAvailable;
	}
	
	
}
