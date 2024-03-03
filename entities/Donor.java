package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name="donor")
@ToString(exclude=("payments"),callSuper=true)

public class Donor  extends BaseEntity{
//name email mobile no adrees
	
	
	@Column(length=30)
	private String name;
	@Column(unique = true, length=30)
	private String email;
	@Column(length = 10)
	private String mobileNumber;
	@Column(length=30)
	private String address;
	@OneToMany(mappedBy="donor",cascade=CascadeType.ALL,orphanRemoval = true)
	private List<Payment> pay= new ArrayList<>();
	public void addPayments(Payment p)
	{
		pay.add(p);
		p.setDonor(this);
	}
	public void removePayments(Pets p) 
	{
		pay.remove(p);
		p.setUser(null);
	}	
	
}
