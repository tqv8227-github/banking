package com.banking.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.banking.entities.CustomerAccountInfo;
import com.banking.services.CustomerAccountInfoService;


@RestController
@RequestMapping(value="/customeraccountinfo")
public class CustomerAccountInfoController {

	private CustomerAccountInfoService service;
	
	public CustomerAccountInfoController(CustomerAccountInfoService service) {
		this.service = service;
	}
	
	@GetMapping(value="customer/lastname/{lastName}")
	public ResponseEntity<List<CustomerAccountInfo>> getCustomerAccountInfoList(@PathVariable("lastName") String lastName){
		List<CustomerAccountInfo> custAccountList = service.getCustomerByLastName(lastName);
		
		return ResponseEntity.ok(custAccountList);
		
	}

}
