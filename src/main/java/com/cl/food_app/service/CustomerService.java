package com.cl.food_app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.cl.food_app.dao.CustomerDao;
import com.cl.food_app.dao.FoodOrderDao;
import com.cl.food_app.dao.ItemDao;
import com.cl.food_app.dto.Customer;
import com.cl.food_app.dto.FoodOrder;
import com.cl.food_app.exception.IdNotFoundException;


@Service
public class CustomerService {
	
	@Autowired
	CustomerDao customerDao;

	@Autowired
	FoodOrderDao orderDao;
	
	@Autowired
	ItemDao itemsDao;
	
	@Autowired
	JavaMailSender javaMailSender;
	
	
	
	
	public Customer saveCustomer(Customer customer, int id) {
		customer.setGst(0.18);
		customer.setServiceCost(0.05);
		Optional<FoodOrder> order1 = orderDao.getFoodOrderById(id);
		if (order1.isEmpty()) {
			throw new IdNotFoundException();
		} else {
			double total = order1.get().getTotalPrice();
			customer.setTotalCost(total + (total * customer.getGst()) + (total * customer.getServiceCost()));
			return customerDao.saveCustomer(customer);
		}
	
	}
	
	public String sendMessage(Customer customer, int id) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		Optional<FoodOrder> order2 = orderDao.getFoodOrderById(id);
		if (order2.isEmpty()) {
			throw new IdNotFoundException();
		} else {
		
			customer.setGst(0.18);
			customer.setServiceCost(0.05);
			double total = order2.get().getTotalPrice();
			customer.setTotalCost(total + (total * customer.getGst()) + (total * customer.getServiceCost()));
			simpleMailMessage.setFrom("arjunks0721@gmail.com");
			simpleMailMessage.setTo(customer.getEmail());
			simpleMailMessage.setSubject("bill");
			simpleMailMessage.setText("Your order ID is "+order2.get().getId()+". Your food price is "+order2.get().getTotalPrice()+", GST is 18%, services is 5% and your total cost is "+customer.getTotalCost());
			javaMailSender.send(simpleMailMessage);
			
			String message=simpleMailMessage.getText();
			
			return message;
		}
	}


}
