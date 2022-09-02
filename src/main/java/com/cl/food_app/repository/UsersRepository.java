package com.cl.food_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cl.food_app.dto.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {
	public Users findByEmailNPassword(String email,String password);
	
	public Users findByEmail(String email);

}
