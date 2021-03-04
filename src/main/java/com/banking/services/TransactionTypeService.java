package com.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.entities.TransactionType;
import com.banking.repositories.TransactionTypeRepository;

@Service
public class TransactionTypeService {

	private TransactionTypeRepository repo;
	
	public TransactionTypeService(TransactionTypeRepository rep) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	
	////////////////////////////////////////////////////////////////
	public TransactionType findById(int id) {
		return repo.findById(id);
	}
	/////////////////////////////////////////////////////////////////
	public List<TransactionType> findAll(){
		return repo.findAll();
	}
	////////////////////////////////////////////////////////////////
	public void save(TransactionType transactionType) {
		repo.saveAndFlush(transactionType);
	}

}
