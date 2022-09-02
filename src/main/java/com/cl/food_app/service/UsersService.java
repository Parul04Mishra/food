package com.cl.food_app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.dao.UsersDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Users;
import com.cl.food_app.util.ResponseStructure;

@Service
public class UsersService {
	@Autowired
	UsersDao userDao;
	
	
	
	public Users saveUser(Users user,int u_id,String email,String role) {
		user.setRole(role);
		user.setEmail(email);
		user.setUser_id(u_id);
		return userDao.saveUsers(user);
}
	
	
	
}
}

