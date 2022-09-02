package com.cl.food_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Customer;
import com.cl.food_app.repository.CustomerRepository;

@Repository
public class CustomerDao {
	
	@Autowired
	CustomerRepository customerRepository;
	
	
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}

}
