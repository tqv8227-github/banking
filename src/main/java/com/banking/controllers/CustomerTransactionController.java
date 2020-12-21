package com.banking.controllers;

import java.net.HttpCookie;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.entities.CustomerTransaction;
import com.banking.repositories.CustomerTransactionRepository;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/transaction")
public class CustomerTransactionController {

	private CustomerTransactionRepository repo;
	
	// use dependency injection by constructor
	public CustomerTransactionController(CustomerTransactionRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping(value="customer/{id}", produces="application/json")
	public ResponseEntity<List<CustomerTransaction>> getCustomerTransaction(@PathVariable("id") int customerId){
		List<CustomerTransaction> transactionList = repo.findByAccountCustomerId(customerId);
		return  ResponseEntity.ok(transactionList);
	}
	
	@GetMapping(value="account/{id}", produces="application/json")
	public ResponseEntity<List<CustomerTransaction>> getAccountTransaction(@PathVariable("id") int accountId, HttpServletResponse response){
		
		List<HttpCookie> cookieList = new ArrayList<HttpCookie>();
		List<CustomerTransaction> transactionList = repo.findByAccountId(accountId);

		response.addCookie(new Cookie("test", "test"));
		response.addHeader("MyHeader", "Hello World");

		return ResponseEntity.ok().header("MyHeader2","Hello world 2.").body(transactionList);
		//return  ResponseEntity.ok(transactionList);
	}

}
