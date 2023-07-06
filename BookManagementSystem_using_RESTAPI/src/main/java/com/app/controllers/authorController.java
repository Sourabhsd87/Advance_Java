package com.app.controllers;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTOs.AuthRequestDTO;
import com.app.DTOs.authResponceDTO;
import com.app.entities.Author;
import com.app.service.authorServiceIF;

@RestController
@RequestMapping("/authors")
@CrossOrigin(origins = "http://localhost:8080")
public class authorController {
	
	
	
	@Autowired
	private authorServiceIF authorServiceInstance;
	
	@GetMapping
	public List<Author> getallAuthors(){
		
		return authorServiceInstance.getallAuthors();
		
	}
	
	@PostMapping("/newauthor")
	public Author insertnewbook(@RequestBody Author newAuthor) {
		
		return authorServiceInstance.insertnewAuthor(newAuthor);
		
	}
	
	@DeleteMapping("/noauthor/{authorid}")
	public String deleteauthor(@PathVariable Integer authorid) {
	
		return authorServiceInstance.deleteauthor(authorid);
		
	}
	
	@PostMapping("/login")
	public authResponceDTO AuthenticateAuthor(@RequestBody AuthRequestDTO reqDTO) {
		
		return authorServiceInstance.AuthenticateAuthor(reqDTO);
		
	}

}
