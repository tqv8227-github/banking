package com.banking.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

import lombok.Data;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

@Entity
@Data
@Table (name = "Customer")
public class Customer {

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name="Id")
	private int id;
	
	@Column(name="FIRSTNAME")
	private String firstName;
	
	@Column(name="LASTNAME")
	private String lastName;
	
	@Column(name="MIDDLENAME")
	private String middleName;
	
	@Column(name="BIRTHDATE")
	private LocalDateTime birthDate;
	
	@Column(name="Sex")
	private String sex;
	
	@Column(name="SSN")
	private String ssn;

}
