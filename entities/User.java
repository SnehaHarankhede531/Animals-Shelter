package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
	@NoArgsConstructor
	@Setter
	@Getter
	@Entity
	@Table(name="User")
	@ToString(exclude=("pets"),callSuper=true)
	
	public class User extends BaseEntity {
		
		@Column(length=30)
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
		
		public void addPets(Pets p)
		{
			pets.add(p);
			p.setUser(this);
		}
		public void removePets(Pets p) 
		{
			pets.remove(p);
			p.setUser(null);
			
		}
		public User(String name, String email,String password,String mobileNumber, LocalDate date, UserType type, List<Pets> pets) {
			super();
			this.name = name;
			this.email = email;
			this.password = password;
			this.mobileNumber = mobileNumber;
			this.date = date;
			this.type = type;
			this.pets = pets;
		}
			

}
