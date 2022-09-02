package com.cl.food_app.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Users;
import com.cl.food_app.repository.AdminRepository;
import com.cl.food_app.repository.UsersRepository;
@Repository
public class UsersDao {
	
	
	@Autowired
	UsersRepository usersRepository;
	
	public Users saveUsers(Users user) {
		return usersRepository.save(user);
	}

	
	
	
	public Users findByEmail(Users user) throws Exception{
		String email=user.getEmail();
		Users obj=null;
		if(email!=null && !"".equals(email)) {
			obj=usersRepository.findByEmail(email);
		}
		
		return obj;
	}
		
	public Users findByEmailNPassword(Users user)
	{ 
	
	
		return user;
		
	}
		
	}
	

