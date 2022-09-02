package com.cl.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cl.food_app.dto.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {

public Admin findByEmail(String email);

	

}
