package com.app.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.producer;

public interface producerRepoIF extends JpaRepository<producer, Integer>{

	
}
