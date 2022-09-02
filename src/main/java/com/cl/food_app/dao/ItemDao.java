package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cl.food_app.dto.Item;
import com.cl.food_app.repository.ItemRepository;

@Repository
public class ItemDao {

	@Autowired
	ItemRepository itemRepository;
	
	
	
	public Item saveItem(Item item) {
		return itemRepository.save(item);
	}
	
	
	public Item updateItem(Item item ,int id) {
		if(itemRepository.findById(id).isEmpty()) {
			return null;}
		else {
			item.setId(id);
			return itemRepository.save(item);
		}
	}
	
	
	public Optional<Item> getItemById(int id) {
		  return itemRepository.findById(id);
	  }

	
	public Item deleteItem(int id) {
		  Optional<Item> item= getItemById(id);
		  itemRepository.delete(item.get());
		  return item.get();
	}

	public List<Item> findAllItem(){
		  return itemRepository.findAll();
		  
	  }

}
