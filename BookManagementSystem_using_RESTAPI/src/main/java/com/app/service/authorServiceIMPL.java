package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DTOs.AuthRequestDTO;
import com.app.DTOs.authResponceDTO;
import com.app.entities.Author;
import com.app.repository.authorRepoIF;

@Service
@Transactional
public class authorServiceIMPL implements authorServiceIF {

	@Autowired
	private authorRepoIF authorRepoInstance;
	
	@Autowired
	private ModelMapper mymap;
	
	@Override
	public Author insertnewAuthor(Author newAuthor) {
		// TODO Auto-generated method stub
		return authorRepoInstance.save(newAuthor);
	}

	@Override
	public List<Author> getallAuthors() {
		// TODO Auto-generated method stub
		return authorRepoInstance.findAll();
	}

	@Override
	public String deleteauthor(Integer id) {
		String msg="not deleted";
		if(authorRepoInstance.existsById(id)) {
			authorRepoInstance.deleteById(id);
			msg="book with ID="+id+" deleted";
		}
		return msg;
	}

	@Override
	public authResponceDTO AuthenticateAuthor(AuthRequestDTO areqDTO) {
		
		Author author = authorRepoInstance.findByAuthornameAndEmail(areqDTO.getAuthorname(),areqDTO.getEmail());
		authResponceDTO authresp = mymap.map(author, authResponceDTO.class);
		
		return authresp;
		
		
	}

	
	
}
