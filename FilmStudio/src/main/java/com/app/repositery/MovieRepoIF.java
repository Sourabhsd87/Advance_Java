package com.app.repositery;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.entities.Movie;

public interface MovieRepoIF extends JpaRepository<Movie, Integer>{

}
