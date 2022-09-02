package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.FoodOrder;
import com.cl.food_app.repository.FoodOrderRepository;

@Repository
public class FoodOrderDao {
	
	@Autowired
	FoodOrderRepository orderRepository;
	
	
	
	public FoodOrder saveFoodOrder(FoodOrder order) {
		return orderRepository.save(order);
	}
	
	
	public FoodOrder updateFoodOrder(FoodOrder order ,int id) {
		if(orderRepository.findById(id).isEmpty()) {
			return null;}
		else {
			order.setId(id);
			return orderRepository.save(order);
		}
	}
	
	
	public Optional<FoodOrder> getFoodOrderById(int id) {
		  return orderRepository.findById(id);
	  }

	
	public FoodOrder deleteFoodOrder(int id) {
		  Optional<FoodOrder> foodOrder= getFoodOrderById(id);
		  orderRepository.delete(foodOrder.get());
		  return foodOrder.get();
	}

	public List<FoodOrder> findAllFoodOrder(){
		  return orderRepository.findAll();
		  
	  }
}


