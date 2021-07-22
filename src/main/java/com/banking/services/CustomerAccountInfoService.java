package com.banking.services;

import java.util.List;
import org.springframework.stereotype.Service;
import com.banking.repositories.CustomerAcountInfoRepository;
import com.banking.entities.CustomerAccountInfo;

@Service
public class CustomerAccountInfoService {

	private CustomerAcountInfoRepository repo;
	
	public CustomerAccountInfoService(CustomerAcountInfoRepository rep) {
		this.repo = repo;
	}
	
	public List<CustomerAccountInfo> getCustomerByLastName(String lastName){
		try {
			List<CustomerAccountInfo> customerList = repo.getCustomerList(lastName);
			return customerList;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
