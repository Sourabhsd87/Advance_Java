package com.app.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.app.DTOs.voterReqDTO;
import com.app.entities.Voter;

public interface voterServiceIF {

	Voter insertNewVoter(Voter newVoter);
	
	List<Voter> getAllVoter();
	
	String deleteVoter(Integer id);
	
	Voter updateVoter(Voter UpdateVoter);
	
	ResponseEntity<?> signIn(voterReqDTO voterDto);
}
