package com.thbs.banking.service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.thbs.banking.entity.Customer;
import com.thbs.banking.entity.Login;
import com.thbs.banking.Repository.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer save(Customer customer) {
		
		Random random = new Random();
		String accountNumber = String.valueOf(random.nextInt(10000000));
		customer.setAccountNo(accountNumber);

		return customerRepository.save(customer);
	}

	public Customer update(Customer customer) {
		return customerRepository.save(customer);
	}

	public void delete(@PathVariable Long id) {
		customerRepository.deleteById(id);
	}

	public Optional<Customer> getOne(@PathVariable Long id) {
		return customerRepository.findById(id);
	}

	public List<Customer> getAll() {
		return customerRepository.findAll();
	}

	public Customer authenticate(Login login) {

		return customerRepository.findOneByEmailAndPassword(login.getEmail(), login.getPassword());
	}

}