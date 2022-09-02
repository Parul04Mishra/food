package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Menu;
import com.cl.food_app.repository.MenuRepository;
@Repository
public class MenuDao {
	
	@Autowired
	MenuRepository menuRepository;
	
	
	
	public Menu saveMenu(Menu menu) {
		return menuRepository.save(menu);
	}
	
	public Menu updateMenu(Menu menu ,int id) {
		if(menuRepository.findById(id).isEmpty()) {
			return null;}
		else {
			menu.setId(id);
			return menuRepository.save(menu);
		}
	}

	
	public Optional<Menu> getMenuById(int id) {
		  return menuRepository.findById(id);
	  }

	
	public Menu deleteMenu(int id) {
		  Optional<Menu> menu= getMenuById(id);
		  menuRepository.delete(menu.get());
		  return menu.get();
	  }
	  
	 
	  
	  public List<Menu> findAllMenu(){
		  return menuRepository.findAll();
		  
	  }
}


