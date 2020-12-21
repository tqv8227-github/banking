package com.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banking.entities.TransactionType;

@RepositoryRestResource
public interface TransactionTypeRepository extends JpaRepository<TransactionType, Integer> {

}
