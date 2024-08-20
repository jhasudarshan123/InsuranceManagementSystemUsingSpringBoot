package com.javatpoint.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatpoint.model.Customers;
import com.javatpoint.repository.CustomerRepository;


@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;

	public List<Customers> getAllCustomers() {
		return customerRepository.getAllCustomers();
	}

	public List<Customers> getAllCustomersById(int id) {
		return customerRepository.getAllCustomersById(id);
	}

	public List<Object[]> getAllCustomersPolicesById(int id) {
		return customerRepository.getAllCustomersPolicesById(id);
	}

	public List<Object[]> getAllCustomersClaimsById(int id) {
		return customerRepository.getAllCustomersClaimsById(id);
	}


}
