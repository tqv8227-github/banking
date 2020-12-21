package com.banking.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.banking.config.ApplicationProps;
import com.banking.entities.Account;
import com.banking.repositories.AccountRepository;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/account")
public class AccountController {

	@Autowired
	private Account account; 
	private AccountRepository rep;
	
	@Value("${spring.security.user.password}")
	private String pwd;
	
	@Autowired
	public Environment env;
	
	@Autowired
	private ApplicationProps appProps;
	
	public void printProps() {
		// using Environment to get prop from application.properties
		String userName = env.getProperty("spring.security.user.name");
		
		// Using @Value
		System.out.println("user name: "+userName+" and password: "+pwd);
		
		// Using @ConfigurationProperties in ApplicationProps class
		String propsStr = "Security: "+appProps.getSecurity()+". auth: "+appProps.getAuthentication()+". Env: "+appProps.getEnv()+". Menu: "+appProps.getMenu();
		System.out.println(propsStr);
	}
	
	public AccountController(AccountRepository rep) {
		this.rep = rep;
	}
	
	@GetMapping(value="list/all", produces="application/json")
	public ResponseEntity<List<Account>> getAccountList(){
		List<Account> accountList = rep.findAll();
		
		this.printProps();
		return ResponseEntity.ok(accountList);
	}
	
	@GetMapping(value="number/{number}", produces="application/json")
	public ResponseEntity<Account> getAccount(@PathVariable (name="number") int accountNumber){
		//Account account = rep.findById(accountNumber).get();
		Account account = rep.findById(accountNumber);
		return ResponseEntity.ok(account);
	}
	
	@GetMapping(value="customer/{number}", produces="application/json")
	public ResponseEntity<List<Account>> getAccountForCustomer(@PathVariable (name="number") int customerId){
		//Account account = rep.findById(accountNumber).get();
		List<Account> accountList = rep.findByCustomerId(customerId);
		return ResponseEntity.ok(accountList);
	}

}
