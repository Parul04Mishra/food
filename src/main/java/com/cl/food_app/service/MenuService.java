package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cl.food_app.dao.MenuDao;
import com.cl.food_app.dto.Menu;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.util.ResponseStructure;
@Service
public class MenuService {
	
	
	@Autowired
	MenuDao menuDao;
	
	
	
	public ResponseEntity< ResponseStructure<Menu>> saveMenu(Menu menu) {
		ResponseStructure<Menu> structure=new ResponseStructure<Menu>();
		structure.setMessage("Menu saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(menuDao.saveMenu(menu));
		return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.OK);

}
	
	
	
public ResponseEntity<ResponseStructure<Menu>> updateMenu(Menu menu, int id) {
		
		Menu mn=menuDao.updateMenu(menu, id);
		ResponseStructure<Menu> structure=new ResponseStructure<Menu>();
		if(mn!=null) {
			structure.setMessage("Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(mn);
			return new ResponseEntity<ResponseStructure<Menu >>(structure,HttpStatus.OK);
	}else {
		structure.setMessage("Invalid ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT(null);
		 return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.NOT_FOUND);
	}
	}
	
	
	public ResponseEntity<ResponseStructure<Menu>> getMenuById(int id) {
		Optional<Menu>optional=menuDao.getMenuById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException();	
		}
		else {
			ResponseStructure<Menu> structure=new ResponseStructure<Menu>();
			 structure.setMessage("Menu found sucessfully");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.OK);
			
		}
	}
	
	
	public  ResponseEntity<ResponseStructure<Menu>>deleteMenu( int id) {
		ResponseStructure<Menu>structure=new ResponseStructure<Menu>();
		structure.setMessage("Menu found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(menuDao.deleteMenu(id));
		return new ResponseEntity<ResponseStructure<Menu>>(structure,HttpStatus.OK);

	}
	
	
	public ResponseEntity<ResponseStructure<List<Menu>>>findAllMenu(){
		ResponseStructure<List<Menu>> structure=new ResponseStructure<List<Menu>>();
		structure.setMessage("Menu found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(menuDao.findAllMenu());
		return new ResponseEntity<ResponseStructure<List<Menu>>>(structure,HttpStatus.OK);

	}


}



