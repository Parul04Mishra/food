package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.dao.StaffDao;
import com.cl.food_app.dto.BranchManager;
import com.cl.food_app.dto.Staff;
import com.cl.food_app.dto.Users;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.util.ResponseStructure;

@Service
public class StaffService {
	
	@Autowired
	StaffDao staffDao;
	@Autowired
	UsersService usersService;
	
	public ResponseEntity< ResponseStructure<Staff>> saveStaff(Staff staff) throws Exception {
		Staff obj=staffDao.findByEmail(staff);
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		if(obj!=null) {
			structure.setMessage("Staff with "+staff.getEmail()+" already exists");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(null);
		}else {
		structure.setMessage("Staff saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(staffDao.saveStaff(staff));
		}
		Users user= new Users();
		usersService.saveUser( user,staff.getId(), staff.getEmail(), staff.getRole());
		return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.OK);

}



	public ResponseEntity<ResponseStructure<Staff>> updateStaff(Staff staff, int id) {
		
		Staff st =staffDao.updateStaff(staff, id);
		ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
		if(st!=null) {
			structure.setMessage("Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(st);
			return new ResponseEntity<ResponseStructure<Staff >>(structure,HttpStatus.OK);
	}else {
		structure.setMessage("Invalid ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT(null);
		 return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.NOT_FOUND);
	}
	}
	
	
	public ResponseEntity<ResponseStructure<Staff>> getStaffById(int id) {
		Optional<Staff>optional=staffDao.getStaffById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException();	
		}
		else {
			ResponseStructure<Staff> structure=new ResponseStructure<Staff>();
			 structure.setMessage("Staff found sucessfully");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.OK);
			
		}
	}
	
	public  ResponseEntity<ResponseStructure<Staff>> deleteStaff( int id) {
		ResponseStructure<Staff>structure=new ResponseStructure<Staff>();
		structure.setMessage("Staff found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(staffDao.deleteStaff(id));
		return new ResponseEntity<ResponseStructure<Staff>>(structure,HttpStatus.OK);

	}
	
	
	public ResponseEntity<ResponseStructure<List<Staff>>>findAllStaff(){
		ResponseStructure<List<Staff>> structure=new ResponseStructure<List<Staff>>();
		structure.setMessage("Staff found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(staffDao.findAllStaff());
		return new ResponseEntity<ResponseStructure<List<Staff>>>(structure,HttpStatus.OK);

	}



}
