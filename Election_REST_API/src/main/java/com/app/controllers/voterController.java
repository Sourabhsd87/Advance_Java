package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTOs.voterReqDTO;
import com.app.entities.Voter;
import com.app.service.voterServiceIF;


@RestController
@RequestMapping("/voter")
public class voterController {

	@Autowired
	private voterServiceIF voterServiceInstance;
	
	@PostMapping
	public Voter addNewVoter(@RequestBody Voter newVoter) {
		
		return voterServiceInstance.insertNewVoter(newVoter);
	}
	
	@GetMapping("/all")
	public List<Voter> GetAllVoters(){
		
		return voterServiceInstance.getAllVoter();
	}
	
	@DeleteMapping("/delete/{id}")
		public String deleteVoter(@PathVariable Integer id) {
		
		return voterServiceInstance.deleteVoter(id);
	}
	
	@PutMapping("/update")
	public Voter updateVoter(@RequestBody Voter UpVoter) {
		
		return voterServiceInstance.updateVoter(UpVoter);
	}
	
	@PostMapping("/signIn")
	public ResponseEntity<?> signIn(@RequestBody  voterReqDTO voterDTO){
		
		return voterServiceInstance.signIn(voterDTO);
	}
}
