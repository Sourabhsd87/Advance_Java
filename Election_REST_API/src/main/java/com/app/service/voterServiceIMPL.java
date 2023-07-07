package com.app.service;



import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DTOs.voterReasDTO;
import com.app.DTOs.voterReqDTO;
import com.app.entities.Voter;
import com.app.exceptions.resourceNotFoundException;
import com.app.repository.voterRepoIF;

@Service
@Transactional
public class voterServiceIMPL implements voterServiceIF {

	@Autowired
	private voterRepoIF voterRepoInstance;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Voter insertNewVoter(Voter newVoter) {
		// TODO Auto-generated method stub
		return voterRepoInstance.save(newVoter);
	}

	@Override
	public List<Voter> getAllVoter() {
		// TODO Auto-generated method stub
		return voterRepoInstance.findAll();
	}

	@Override
	public String deleteVoter(Integer id) {
		// TODO Auto-generated method stub
		String msg="not deleted";
		if(voterRepoInstance.existsById(id)) {
			voterRepoInstance.deleteById(id);
			msg="Data deleted";
		}
		return msg;
	}

	@Override
	public Voter updateVoter(Voter UpdateVoter) {
		
		return voterRepoInstance.save(UpdateVoter);
	}

	@Override
	public ResponseEntity<?> signIn(voterReqDTO voterDTO) {
		// TODO Auto-generated method stub
		Voter voter = voterRepoInstance.findByEmailAndPassword(voterDTO.getEmail(), voterDTO.getPassword()).orElseThrow(()->new resourceNotFoundException("Invalid Email or Password"));
		voterReasDTO map = mapper.map(voter, voterReasDTO.class);
		return ResponseEntity.status(HttpStatus.OK).body(map);
	}

}
