package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.util.ResponseStructure;
import com.cl.food_app.dao.AdminDao;
import com.cl.food_app.dao.UsersDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Users;
import com.cl.food_app.exception.IdNotFoundException;
@Service
public class AdminService {
	
	@Autowired
	AdminDao adminDao;
	
	@Autowired
	UsersDao usersDao;
	
	@Autowired
	UsersService usersService;
	
	
	
	public ResponseEntity< ResponseStructure<Admin>> saveAdmin(Admin admin) throws Exception {
		Admin obj=adminDao.findByEmail(admin);
		
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		if(obj!=null) {
			structure.setMessage("Admin with "+admin.getEmail()+" already exists");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(null);
		}
		else {
		

		structure.setMessage("Admin saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(adminDao.saveAdmin(admin));
		}
		Users user= new Users();
		usersService.saveUser( user,admin.getId(), admin.getEmail(), admin.getRole());
		
	return  new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);

}



	public ResponseEntity<ResponseStructure<Admin>> updateAdmin(Admin admin, int id) {
		
		Admin ad=adminDao.updateAdmin(admin, id);
		ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
		if(ad!=null) {
			structure.setMessage("Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(ad);
			return new ResponseEntity<ResponseStructure<Admin >>(structure,HttpStatus.OK);
	}else {
		structure.setMessage("Invalid ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT(null);
		 return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.NOT_FOUND);
	}
	}
	
	
	public ResponseEntity<ResponseStructure<Admin>> getAdminById(int id) {
		Optional<Admin>optional=adminDao.getAdminById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException();	
		}
		else {
			ResponseStructure<Admin> structure=new ResponseStructure<Admin>();
			 structure.setMessage("Admin found sucessfully");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);
			
		}
	}
	
	public  ResponseEntity<ResponseStructure<Admin>> deleteAdmin( int id) {
		ResponseStructure<Admin>structure=new ResponseStructure<Admin>();
		structure.setMessage("Admin found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(adminDao.deleteAdmin(id));
		return new ResponseEntity<ResponseStructure<Admin>>(structure,HttpStatus.OK);

	}
	
	
	public ResponseEntity<ResponseStructure<List<Admin>>>findAllAdmin(){
		ResponseStructure<List<Admin>> structure=new ResponseStructure<List<Admin>>();
		structure.setMessage("Admin found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(adminDao.findAllAdmin());
		return new ResponseEntity<ResponseStructure<List<Admin>>>(structure,HttpStatus.OK);

	}
	
	

}
