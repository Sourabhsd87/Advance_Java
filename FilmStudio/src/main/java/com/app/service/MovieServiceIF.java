package com.app.service;

import java.util.List;

import com.app.DTO.movieReqDTO;
import com.app.DTO.updateMovieDTO;
import com.app.entities.Movie;

public interface MovieServiceIF {

	List<Movie> getAllFilms();
	
	Movie insertNewMovie(movieReqDTO newMovie);
	
	Movie UpdateMovie(updateMovieDTO updatedMovie);
	
	String deleteMovie(Integer movieId);
}
