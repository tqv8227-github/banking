package com.banking.repositories;

import java.util.List;

//import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.banking.entities.CustomerAccountInfo;

@Repository
public interface CustomerAcountInfoRepository extends JpaRepository<CustomerAccountInfo, Integer> {
	@Query(value="select a.* from CustomerAccountInfo_vw a", nativeQuery=true)
	public List<CustomerAccountInfo> getCustomerList(String lastName);

}
