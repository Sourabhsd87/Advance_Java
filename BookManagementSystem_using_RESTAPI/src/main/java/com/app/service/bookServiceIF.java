package com.app.service;

import java.util.List;

import com.app.entities.book;

public interface bookServiceIF {

	book insertnewbook(book newBook);
	
	List<book> getallbooks();
	
	String deleteBook(Integer id);
		
	
	
}
