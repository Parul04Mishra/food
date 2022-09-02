package com.cl.food_app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.cl.food_app.dto.Branch;
import com.cl.food_app.repository.BranchRepository;
@Repository
public class BranchDao {

	
	@Autowired
	BranchRepository branchRepository;
	
	
	
	public Branch saveBranch(Branch branch) {
		return branchRepository.save(branch);
	}
	
	public Branch updateBranch(Branch branch ,int id) {
		if(branchRepository.findById(id).isEmpty()) {
			return null;}
		else {
			branch.setId(id);
			return branchRepository.save(branch);
		}
	}

	
	public Optional<Branch> getBranchById(int id) {
		  return branchRepository.findById(id);
	  }

	
	public Branch deleteBranch(int id) {
		  Optional<Branch> branch= getBranchById(id);
		  branchRepository.delete(branch.get());
		  return branch.get();
	  }
	  
	 
	  
	  public List<Branch> findAllBranch(){
		  return branchRepository.findAll();
		  
	  }
}
