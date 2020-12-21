package com.banking.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banking.entities.Account;

@RepositoryRestResource
public interface AccountRepository extends JpaRepository<Account, Integer> {
	
	@Query(value="select a.* from Account a join customer b on b.id=a.customerid where a.id= :id")
	public Account findById(@Param ("id") int id);
	
	@Query(value="select a.* from Account a join customer b on b.id=a.customerid where b.id= :id")
	public List<Account> findByCustomerId(@Param("id") int customerId);
}
