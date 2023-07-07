package com.app.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.DTO.movieReqDTO;
import com.app.DTO.updateMovieDTO;
import com.app.entities.Movie;
import com.app.service.MovieServiceIF;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/movie")
@CrossOrigin(origins =  "http://localhost:3000")
public class movieController {

	@Autowired
	private MovieServiceIF movieServiceInstance;
	
	@GetMapping
	private List<Movie> getAllMovie(){
		
		return movieServiceInstance.getAllFilms();
		
	}
	
	@PostMapping("/new")
	public Movie addNewMovie(@RequestBody movieReqDTO newMovieDTO) {
		
		return movieServiceInstance.insertNewMovie(newMovieDTO);
		
	}
	
	@PutMapping("/update")
	public Movie updateMovie(@RequestBody updateMovieDTO updateMovie) {
		
		return movieServiceInstance.UpdateMovie(updateMovie);
		
	}
	
	@DeleteMapping("/delete/{movieId}")
	public String deleteMovie(@PathVariable Integer movieId) {
		
		return movieServiceInstance.deleteMovie(movieId);
		
	}
	
	
}
