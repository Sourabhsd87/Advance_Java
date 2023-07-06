package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.book;
import com.app.service.bookServiceIF;


@RestController
@RequestMapping("/books")
@CrossOrigin(origins = "http://localhost:3000")
public class bookController {

	@Autowired
	private bookServiceIF bookServiceInstance;
	
	@PostMapping("/newbook")
	public String addNewBook(@RequestBody book newbook) {
		
		book insertnewbook = bookServiceInstance.insertnewbook(newbook);
		
		String status= "inserted "+insertnewbook.getBookName();
				
		
		return status;
	}
	
	@GetMapping
	public List<book> getAllbooks(){
		
		return bookServiceInstance.getallbooks();
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable Integer id){
		
		return bookServiceInstance.deleteBook(id);
	}

}
