package com.cl.food_app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cl.food_app.dao.BranchDao;
import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Branch;
import com.cl.food_app.exception.IdNotFoundException;
import com.cl.food_app.util.ResponseStructure;
@Service
public class BranchService {

	
	@Autowired
	BranchDao branchDao;
	
	
	
	public ResponseEntity< ResponseStructure<Branch>> saveBranch(Branch branch) {
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		structure.setMessage("Branch saved successfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setT(branchDao.saveBranch(branch));
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);

}
	
	
	
public ResponseEntity<ResponseStructure<Branch>> updateBranch(Branch branch, int id) {
		
		Branch br=branchDao.updateBranch(branch, id);
		ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
		if(br!=null) {
			structure.setMessage("Updated Sucessfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setT(br);
			return new ResponseEntity<ResponseStructure<Branch >>(structure,HttpStatus.OK);
	}else {
		structure.setMessage("Invalid ID");
		structure.setStatus(HttpStatus.NOT_FOUND.value());
		structure.setT(null);
		 return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.NOT_FOUND);
	}
	}
	
	
	public ResponseEntity<ResponseStructure<Branch>> getBranchById(int id) {
		Optional<Branch>optional=branchDao.getBranchById(id);
		if(optional.isEmpty()) {
			throw new IdNotFoundException();	
		}
		else {
			ResponseStructure<Branch> structure=new ResponseStructure<Branch>();
			 structure.setMessage("Branch found sucessfully");
			 structure.setStatus(HttpStatus.OK.value());
			 structure.setT(optional.get());
			return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);
			
		}
	}
	
	
	public  ResponseEntity<ResponseStructure<Branch>>deleteBranch( int id) {
		
		ResponseStructure<Branch>structure=new ResponseStructure<Branch>();
		structure.setMessage("Branch found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchDao.deleteBranch(id));
		return new ResponseEntity<ResponseStructure<Branch>>(structure,HttpStatus.OK);

	}
	
	
	public ResponseEntity<ResponseStructure<List<Branch>>>findAllBranch(){
		ResponseStructure<List<Branch>> structure=new ResponseStructure<List<Branch>>();
		structure.setMessage("Branch found successfully");
		structure.setStatus(HttpStatus.OK.value());
		structure.setT(branchDao.findAllBranch());
		return new ResponseEntity<ResponseStructure<List<Branch>>>(structure,HttpStatus.OK);

	}


}
