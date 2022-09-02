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

import com.cl.food_app.dao.AdminDao;
import com.cl.food_app.dao.StaffDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Staff;
import com.cl.food_app.service.AdminService;
import com.cl.food_app.service.StaffService;
import com.cl.food_app.util.ResponseStructure;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class StaffController {
	
	@Autowired
	StaffService staffService;
	@Autowired
	StaffDao staffDao;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveStaff")
	public ResponseEntity<ResponseStructure<Staff>> saveStaff(@RequestBody Staff staff) throws Exception {
		return staffService.saveStaff(staff);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updateStaff")
	public ResponseEntity<ResponseStructure<Staff>> updateStaff(@RequestBody Staff staff,@RequestParam int id){
		return staffService.updateStaff(staff,id);
	
}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getStaffbyid/{id}")
	public ResponseEntity<ResponseStructure<Staff >>getStaffById(@PathVariable int id) {
		return staffService.getStaffById(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deleteStaff/{id}")
	public ResponseEntity<ResponseStructure<Staff>> deleteStaff(@PathVariable int id) {
		return staffService.deleteStaff(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findallStaff")
	public ResponseEntity<ResponseStructure<List<Staff>>>findAllStaff(){
		return staffService.findAllStaff();	
	}
	

}
