package com.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.entities.CustomerTransaction;
import com.banking.repositories.CustomerTransactionRepository;

@Service
public class CustomerTransactionService {

	private CustomerTransactionRepository repo;
	
	public CustomerTransactionService(CustomerTransactionRepository repo) {
		this.repo = repo;
	}
	
	/////////////////////////////////////////////////////////////////////////////
	public CustomerTransaction findById(int id) {
		return repo.findById(id);
	}
	/////////////////////////////////////////////////////////////////////////////
	public List<CustomerTransaction> findAll(){
		return repo.findAll();
	}
	////////////////////////////////////////////////////////////////////////////
	public void save(CustomerTransaction transaction) {
		repo.saveAndFlush(transaction);
	}
	
}
