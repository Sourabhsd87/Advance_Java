package com.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Author;
import com.app.entities.book;

public interface authorRepoIF extends JpaRepository<Author, Integer>{

	Author findByAuthornameAndEmail(String name,String email);
		
}
