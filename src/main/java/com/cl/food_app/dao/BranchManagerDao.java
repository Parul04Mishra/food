package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cl.food_app.dto.Admin;
import com.cl.food_app.dto.Branch;
import com.cl.food_app.dto.BranchManager;
import com.cl.food_app.repository.BranchManagerRepository;
@Repository
public class BranchManagerDao {
	
	
	@Autowired
	BranchManagerRepository branchManagerRepository;
	
	
	
	public BranchManager saveBranchManager(BranchManager branchManager) {
		return branchManagerRepository.save(branchManager);
	}
	
	
	public BranchManager updateBranchManager(BranchManager branchManager ,int id) {
		if(branchManagerRepository.findById(id).isEmpty()) {
			return null;}
		else {
			branchManager.setId(id);
			return branchManagerRepository.save(branchManager);
		}
	}
	
	
	public Optional<BranchManager> getBranchManagerById(int id) {
		  return branchManagerRepository.findById(id);
	  }
	public BranchManager deleteBranchManager(int id) {
		  Optional<BranchManager> branchManager= getBranchManagerById(id);
		  branchManagerRepository.delete(branchManager.get());
		  return branchManager.get();
	  }
	  
	 
	  
	  public List<BranchManager> findAllBranchManager(){
		  return branchManagerRepository.findAll();
		  
	  }
	  
		public BranchManager findByEmail(BranchManager branchManager) throws Exception{
			String email=branchManager.getEmail();
			BranchManager obj=null;
			if(email!=null && !"".equals(email)) {
				obj=branchManagerRepository.findByEmail(email);
			}
			
			return obj;
		
}
}


