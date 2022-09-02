package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cl.food_app.dao.FoodOrderDao;
import com.cl.food_app.dto.FoodOrder;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.exception.OrderNotFoundException;
import com.cl.food_app.util.ResponseStructure;

@Service
public class FoodOrderService {
	
	@Autowired
	FoodOrderDao foodOrderDao;
	
	
	
	public ResponseEntity< ResponseStructure<FoodOrder>> saveFoodOrder(FoodOrder foodOrder) {
		ResponseStructure<FoodOrder> structure=new ResponseStructure<FoodOrder>();
		structure.setMessage("FoodOrder saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(foodOrderDao.saveFoodOrder(foodOrder));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.OK);

}



	public ResponseEntity<ResponseStructure<FoodOrder>> updateFoodOrder(FoodOrder foodOrder, int id) {
		
		FoodOrder order =foodOrderDao.updateFoodOrder(foodOrder, id);
		ResponseStructure<FoodOrder> structure=new ResponseStructure<FoodOrder>();
		if(order!=null) {
			structure.setMessage("Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(order);
			return new ResponseEntity<ResponseStructure<FoodOrder >>(structure,HttpStatus.OK);
	}else {
		structure.setMessage("Invalid ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT(null);
		 return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.NOT_FOUND);
	}
	}
	
	
	public ResponseEntity<ResponseStructure<FoodOrder>> getFoodOrderById(int id) {
		Optional<FoodOrder>optional=foodOrderDao.getFoodOrderById(id);
		if(optional.isEmpty()) {
			throw new OrderNotFoundException();	
		}
		else {
			ResponseStructure<FoodOrder> structure=new ResponseStructure<FoodOrder>();
			 structure.setMessage("FoodOrder found sucessfully");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.OK);
			
		}
	}
	
	public  ResponseEntity<ResponseStructure<FoodOrder>> deleteFoodOrder( int id) {
		ResponseStructure<FoodOrder>structure=new ResponseStructure<FoodOrder>();
		structure.setMessage("FoodOrder deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodOrderDao.deleteFoodOrder(id));
		return new ResponseEntity<ResponseStructure<FoodOrder>>(structure,HttpStatus.OK);

	}
	
	
	public ResponseEntity<ResponseStructure<List<FoodOrder>>>findAllFoodOrder(){
		ResponseStructure<List<FoodOrder>> structure=new ResponseStructure<List<FoodOrder>>();
		structure.setMessage("FoodOrder found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(foodOrderDao.findAllFoodOrder());
		return new ResponseEntity<ResponseStructure<List<FoodOrder>>>(structure,HttpStatus.OK);

	}


}
