package com.banking.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.Customer;
import com.banking.repositories.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/customer")
public class CustomerController {

	private Customer customer;
	private CustomerRepository repo;
	
	public CustomerController(CustomerRepository repo) {
		this.repo = repo;
	}

	@GetMapping(value="list/all", produces="application/json")
	public ResponseEntity<List<Customer>> getAllCustomers(){	
		List<Customer> customerList = repo.findAll();
		return ResponseEntity.ok().body(customerList);
	}
	
	@GetMapping(value="list/id/{id}", produces="application/json")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int customerId){
		return ResponseEntity.ok(repo.findById(customerId));
	}
	
	@GetMapping(value="list/lastname/{lastname}", produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerByLastName(@PathVariable("lastname") String lastName){
		return ResponseEntity.ok(repo.findByLastNameContaining(lastName));
	}
	
	@GetMapping(value="list/firstname/{firstname}", produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerByFirstName(@PathVariable("firstname") String firstName){
		return ResponseEntity.ok(repo.findByFirstNameContaining(firstName));
	}
	
	@GetMapping(value="list/fullname", produces="application/json")
	public ResponseEntity<List<Customer>> getCustomerByFullName(@RequestParam(value="firstName", required=true) String firstName, @RequestParam(value="lastName", required=true) String lastName){
		List<Customer> custList = repo.findByFirstNameContainingAndLastNameContaining(firstName, lastName);
		return ResponseEntity.ok(custList);
	}
	
	@PostMapping(value="add/user", produces="application/json", consumes="application/json")
	public Customer addNewCustomer(@RequestBody Customer newCustomer) {
		Customer customer = new Customer();		
		if (newCustomer != null) {
			customer = repo.save(newCustomer);
		}
		
		return customer;
	}
	
	@PutMapping(value="update/user", produces="application/json")
	public Customer updateUser(@RequestBody(required=true) Customer customer) {
		Customer lCustomer = repo.findById(customer.getId());
		
		if (lCustomer != null) {
			lCustomer = repo.save(customer);	
		}		
		return lCustomer;
	}
}
