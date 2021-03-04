package com.banking.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.banking.entities.Banker;
import com.banking.entities.BankerType;
import com.banking.repositories.BankerRepository;
import com.banking.repositories.BankerTypeRepository;

@Service
public class BankerTypeService {

	private BankerTypeRepository repo;
	
	// constructor injection
	public BankerTypeService(BankerTypeRepository repo) {
		// TODO Auto-generated constructor stub
		this.repo = repo;
	}
	
	//////////////////////////////////////////////////////////
	public BankerType findBankerById(int id){
		return repo.findById(id);
	}
	
	///////////////////////////////////////////////////////////
	public List<BankerType> findAll(){
		return repo.findAll();
	}
	
	////////////////////////////////////////////////////////////
	public void save(BankerType bankerType) {
		//repo.save(banker);
		repo.saveAndFlush(bankerType);
	}

}
