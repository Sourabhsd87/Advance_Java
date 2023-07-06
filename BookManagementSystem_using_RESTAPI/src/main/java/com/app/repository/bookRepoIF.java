package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.book;

public interface bookRepoIF extends JpaRepository<book, Integer>{

}
