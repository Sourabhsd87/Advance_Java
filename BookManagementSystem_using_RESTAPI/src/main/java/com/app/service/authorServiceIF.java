package com.app.service;

import java.util.List;

import com.app.DTOs.AuthRequestDTO;
import com.app.DTOs.authResponceDTO;
import com.app.entities.Author;

public interface authorServiceIF {

	Author insertnewAuthor(Author newAuthor);
	
	List<Author> getallAuthors();
	
	String deleteauthor(Integer id);
	
	authResponceDTO AuthenticateAuthor(AuthRequestDTO areqDTO);
}
