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

import com.cl.food_app.dao.MenuDao;
import com.cl.food_app.dto.Menu;
import com.cl.food_app.service.MenuService;
import com.cl.food_app.util.ResponseStructure;
@RestController
public class MenuController {
	
	
	
	@Autowired
	MenuService menuService;
	@Autowired
	MenuDao menuDao;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveMenu")
	public ResponseEntity<ResponseStructure<Menu>> saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateMenu")
	public ResponseEntity<ResponseStructure<Menu>> updateMenu(@RequestBody Menu menu,@RequestParam int id){
		return menuService.updateMenu(menu,id);
	
}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getMenubyid/{id}")
	public ResponseEntity<ResponseStructure<Menu >>getMenuById(@PathVariable int id) {
		return menuService.getMenuById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteMenu/{id}")
	public ResponseEntity<ResponseStructure<Menu>> deleteAdmin(@PathVariable int id) {
		return menuService.deleteMenu(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findallMenu")
	public ResponseEntity<ResponseStructure<List<Menu>>>findAllAdmin(){
		return menuService.findAllMenu();	
	}
	
}


