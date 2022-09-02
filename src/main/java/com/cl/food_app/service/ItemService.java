package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.dao.ItemDao;
import com.cl.food_app.dto.Item;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.exception.ItemNotFoundException;
import com.cl.food_app.util.ResponseStructure;

@Service
public class ItemService {
	
	
	@Autowired
	ItemDao itemDao;
	
	
	
	public ResponseEntity< ResponseStructure<Item>> saveItem(Item item) {
		ResponseStructure<Item> structure=new ResponseStructure<Item>();
		structure.setMessage("Item saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(itemDao.saveItem(item));
		return new ResponseEntity<ResponseStructure<Item>>(structure,HttpStatus.OK);

}



	public ResponseEntity<ResponseStructure<Item>> updateItem(Item item, int id) {
		
		Item it=itemDao.updateItem(item, id);
		ResponseStructure<Item> structure=new ResponseStructure<Item>();
		if(it!=null) {
			structure.setMessage("Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(it);
			return new ResponseEntity<ResponseStructure<Item >>(structure,HttpStatus.OK);
	}else {
		structure.setMessage("Invalid ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT(null);
		 return new ResponseEntity<ResponseStructure<Item>>(structure,HttpStatus.NOT_FOUND);
	}
	}
	
	
	public ResponseEntity<ResponseStructure<Item>> getItemById(int id) {
		Optional<Item>optional=itemDao.getItemById(id);
		if(optional.isEmpty()) {
			throw new ItemNotFoundException();	
		}
		else {
			ResponseStructure<Item> structure=new ResponseStructure<Item>();
			 structure.setMessage("Item found sucessfully");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Item>>(structure,HttpStatus.OK);
			
		}
	}
	
	public  ResponseEntity<ResponseStructure<Item>> deleteItem( int id) {
		ResponseStructure<Item>structure=new ResponseStructure<Item>();
		structure.setMessage("Item deleted successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(itemDao.deleteItem(id));
		return new ResponseEntity<ResponseStructure<Item>>(structure,HttpStatus.OK);

	}
	
	
	public ResponseEntity<ResponseStructure<List<Item>>>findAllItem(){
		ResponseStructure<List<Item>> structure=new ResponseStructure<List<Item>>();
		structure.setMessage("Item found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(itemDao.findAllItem());
		return new ResponseEntity<ResponseStructure<List<Item>>>(structure,HttpStatus.OK);

	}



}
