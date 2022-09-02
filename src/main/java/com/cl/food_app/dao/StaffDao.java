package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Staff;
import com.cl.food_app.repository.StaffRepository;

@Repository
public class StaffDao {
	
	@Autowired
	StaffRepository staffRepository;
	
	
	
	public Staff saveStaff(Staff staff) {
		return staffRepository.save(staff);
	}
	
	
	public Staff updateStaff(Staff staff ,int id) {
		if(staffRepository.findById(id).isEmpty()) {
			return null;}
		else {
			staff.setId(id);
			return staffRepository.save(staff);
		}
	}
	
	
	public Optional<Staff> getStaffById(int id) {
		  return staffRepository.findById(id);
	  }

	
	public Staff deleteStaff(int id) {
		  Optional<Staff> staff= getStaffById(id);
		  staffRepository.delete(staff.get());
		  return staff.get();
	}

	public List<Staff> findAllStaff(){
		  return staffRepository.findAll();
		  
	  }
	
	public Staff findByEmail(Staff staff) throws Exception{
		String email=staff.getEmail();
		Staff obj=null;
		if(email!=null && !"".equals(email)) {
			obj=staffRepository.findByEmail(email);
		}
		
		return obj;
	

}
}
