package com.banking.repositories;

import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banking.entities.CustomerTransaction;

@RepositoryRestResource
public interface CustomerTransactionRepository extends JpaRepository<CustomerTransaction, Integer> {

	@Query(value="select a.* from customertransaction a join account b on b.id=a.accountid where b.customerid=:id")
	public List<CustomerTransaction> findByAccountCustomerId(@Param("id") int customerId);
	
	@Query(value="select a.* from customertransaction a join account b on b.id=a.accountid where b.id=:id")
	public List<CustomerTransaction> findByAccountId(@Param("id") int accountId);
}
