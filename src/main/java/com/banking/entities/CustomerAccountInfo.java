package com.banking.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="CustomerAccountInfo_vw")
public class CustomerAccountInfo {

	@Id
	@Column(name="CustomerId")
	private int customerId;
	
	@Column(name="LastName")
	private String lastName;
	
	@Column(name="FirstName")
	private String firstName;
	
	@Column(name="MiddleName")
	private String middleName;
	
	@Column(name="Sex")
	private String sex;
	
	@Column(name="amount")
	private int balance;
	
	@Column(name="AccountType")
	private String accountType;
	
	@Column(name="AccountNumber")
	private int accountNumber;
	
}
