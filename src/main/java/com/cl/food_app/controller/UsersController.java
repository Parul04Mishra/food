package com.cl.food_app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dao.AdminDao;
import com.cl.food_app.dao.UsersDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Users;
import com.cl.food_app.service.AdminService;
import com.cl.food_app.service.UsersService;
import com.cl.food_app.util.ResponseStructure;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UsersController {
	
	
	@Autowired
	UsersService usersService;
	@Autowired
	UsersDao usersDao;
	
	
	
	



}
