package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.cl.food_app.dao.BranchManagerDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Branch;
import com.cl.food_app.dto.BranchManager;
import com.cl.food_app.dto.Users;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.util.ResponseStructure;
@Service
public class BranchManagerService {
	
	@Autowired
	BranchManagerDao branchManagerDao;
	
	@Autowired
	UsersService usersService;
	
	public ResponseEntity< ResponseStructure<BranchManager>> saveBranchManager(BranchManager branchManager) throws Exception {
		BranchManager obj=branchManagerDao.findByEmail(branchManager);
		ResponseStructure<BranchManager> structure=new ResponseStructure<BranchManager>();
		if(obj!=null) {
			structure.setMessage("BranchManager with "+branchManager.getEmail()+" already exists");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(null);
		}else {
		structure.setMessage("BranchManager saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(branchManagerDao.saveBranchManager(branchManager));
		}
		Users user= new Users();
		usersService.saveUser( user,branchManager.getId(), branchManager.getEmail(), branchManager.getRole());
		return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.OK);


	}



	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(BranchManager branchManager, int id) {
		
		BranchManager bm=branchManagerDao.updateBranchManager(branchManager, id);
		ResponseStructure<BranchManager> structure=new ResponseStructure<BranchManager>();
		if(bm!=null) {
			structure.setMessage("Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(bm);
			return new ResponseEntity<ResponseStructure<BranchManager >>(structure,HttpStatus.OK);
	}else {
		structure.setMessage("Invalid ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT(null);
		 return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.NOT_FOUND);
	}
	}
	
	
	public ResponseEntity<ResponseStructure<BranchManager>> getBranchManagerById(int id) {
		Optional<BranchManager>optional=branchManagerDao.getBranchManagerById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException();	
		}
		else {
			ResponseStructure<BranchManager> structure=new ResponseStructure<BranchManager>();
			 structure.setMessage("Admin found sucessfully");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.OK);
			
		}
	}
	
	
	public  ResponseEntity<ResponseStructure<BranchManager>>deleteBranchManager( int id) {
		ResponseStructure<BranchManager>structure=new ResponseStructure<BranchManager>();
		structure.setMessage("BranchManager found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchManagerDao.deleteBranchManager(id));
		return new ResponseEntity<ResponseStructure<BranchManager>>(structure,HttpStatus.OK);

	}
	
	
	public ResponseEntity<ResponseStructure<List<BranchManager>>>findAllBranchManager(){
		ResponseStructure<List<BranchManager>> structure=new ResponseStructure<List<BranchManager>>();
		structure.setMessage("BranchManager found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchManagerDao.findAllBranchManager());
		return new ResponseEntity<ResponseStructure<List<BranchManager>>>(structure,HttpStatus.OK);

	}



}



