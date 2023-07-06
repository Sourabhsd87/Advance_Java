package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.entities.book;
import com.app.repository.bookRepoIF;

@Service
@Transactional
public class bookServiceIMPL implements bookServiceIF {

	@Autowired
	private bookRepoIF bookRepoInstance;
	
	@Override
	public book insertnewbook(book newBook) {
		// TODO Auto-generated method stub
		return bookRepoInstance.save(newBook);
	}

	@Override
	public List<book> getallbooks() {
		// TODO Auto-generated method stub
		return bookRepoInstance.findAll();
	}

	@Override
	public String deleteBook(Integer id) {
		// TODO Auto-generated method stub
		
		String msg="Not deleted";
		if(bookRepoInstance.existsById(id)) {
			bookRepoInstance.deleteById(id);
			msg="book with id "+id+"deleted";
		}
		return msg;
	}

}
