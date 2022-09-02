package com.cl.food_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dao.ItemDao;
import com.cl.food_app.dto.Item;
import com.cl.food_app.service.ItemService;
import com.cl.food_app.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class ItemController {
	
	
	@Autowired
	ItemService itemService;
	@Autowired
	ItemDao itemDao;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveItem")
	public ResponseEntity<ResponseStructure<Item>> saveItem(@RequestBody Item item) {
		return itemService.saveItem(item);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateItem")
	public ResponseEntity<ResponseStructure<Item>> updateItem(@RequestBody Item item,@RequestParam int id){
		return itemService.updateItem(item,id);
	
}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getItembyid/{id}")
	public ResponseEntity<ResponseStructure<Item>>getitemById(@PathVariable int id) {
		return itemService.getItemById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteItem/{id}")
	public ResponseEntity<ResponseStructure<Item>> deleteItem(@PathVariable int id) {
		return itemService.deleteItem(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findallItem")
	public ResponseEntity<ResponseStructure<List<Item>>>findAllItem(){
		return itemService.findAllItem();	
	}
	

}
