package com.cl.food_app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cl.food_app.dao.BranchManagerDao;
import com.cl.food_app.dto.Branch;
import com.cl.food_app.dto.BranchManager;
import com.cl.food_app.service.BranchManagerService;
import com.cl.food_app.util.ResponseStructure;
@RestController
public class BranchMangerController {
	
	@Autowired
	BranchManagerService branchManagerService;
	@Autowired
	BranchManagerDao branchManagerDao;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/saveBranchManager")
	public ResponseEntity<ResponseStructure<BranchManager>> saveBranchManager(@RequestBody BranchManager branchManager) throws Exception {
		return branchManagerService.saveBranchManager(branchManager);
	}
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/updatebranchManager")
	public ResponseEntity<ResponseStructure<BranchManager>> updateBranchManager(@RequestBody BranchManager branchManager,@RequestParam int id){
		return branchManagerService.updateBranchManager(branchManager,id);
	
}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/getbranchManagerbyid/{id}")
	public ResponseEntity<ResponseStructure<BranchManager >>getBranchManagerById(@PathVariable int id) {
		return branchManagerService.getBranchManagerById(id);
	}

	@CrossOrigin(origins = "http://localhost:4200")
	@DeleteMapping("/deletebranchManager/{id}")
	public ResponseEntity<ResponseStructure<BranchManager>> deleteBranchManager(@PathVariable int id) {
		return branchManagerService.deleteBranchManager(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/findallbranchManager")
	public ResponseEntity<ResponseStructure<List<BranchManager>>>findAllBranchManager(){
		return branchManagerService.findAllBranchManager();	
	}

}
