package com.cl.food_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dto.Customer;
import com.cl.food_app.service.CustomerService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CustomerController {
	
	@Autowired
	CustomerService customerService;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/customer/{id}")
	public Customer saveCustomer(@RequestBody Customer customer,@PathVariable int id) {
		return customerService.saveCustomer(customer,id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/mail/{id}")
	public String send(@RequestBody Customer customer,@PathVariable int id) {
		return customerService.sendMessage(customer, id);
	}

}
