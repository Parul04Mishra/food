package com.cl.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Customer;


public interface CustomerRepository extends JpaRepository<Customer, Integer> {
	

}
