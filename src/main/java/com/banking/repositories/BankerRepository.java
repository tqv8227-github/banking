package com.banking.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.banking.entities.Banker;

@RepositoryRestResource
public interface BankerRepository extends JpaRepository<Banker, Integer> {

}
