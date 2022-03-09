package com.thbs.banking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.thbs.banking.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

	Customer findOneByEmailAndPassword(String email, String password);

	Customer findByAccountNo(String accountNum);

}