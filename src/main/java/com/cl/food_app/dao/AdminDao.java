package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.repository.AdminRepository;

@Repository
public class AdminDao {
	
	@Autowired
	AdminRepository adminRepository;
	
	
	
	public Admin saveAdmin(Admin admin) {
		return adminRepository.save(admin);
	}
	
	
	public Admin updateAdmin(Admin admin ,int id) {
		if(adminRepository.findById(id).isEmpty()) {
			throw new IdNotFoundException();}
		else {
			admin.setId(id);
			return adminRepository.save(admin);
		}
	}
	
	
	public Optional<Admin> getAdminById(int id) {
		  return adminRepository.findById(id);
	  }

	
	public Admin deleteAdmin(int id) {
		  Optional<Admin> admin= getAdminById(id);
		  adminRepository.delete(admin.get());
		  return admin.get();
	}

	public List<Admin> findAllAdmin(){
		  return adminRepository.findAll();
		  
	  }


	public Admin findByEmail(Admin admin) throws Exception{
		String email=admin.getEmail();
		Admin obj=null;
		if(email!=null && !"".equals(email)) {
			obj=adminRepository.findByEmail(email);
		}
		
		return obj;
	}
		
		
	}
	
	

		
