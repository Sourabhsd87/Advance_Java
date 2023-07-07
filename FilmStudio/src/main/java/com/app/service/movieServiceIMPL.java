package com.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.DTO.movieReqDTO;
import com.app.DTO.updateMovieDTO;
import com.app.entities.Movie;
import com.app.entities.producer;
import com.app.exception.resourseNotFoundException;
import com.app.repositery.MovieRepoIF;
import com.app.repositery.producerRepoIF;

@Service
@Transactional
public class movieServiceIMPL implements MovieServiceIF {

	@Autowired
	private MovieRepoIF movieRepoinstance;
	
	@Autowired
	private producerRepoIF producerRepoInstance;
	
	@Autowired
	private ModelMapper mapper;

	public List<Movie> getAllFilms() {		
		
		return movieRepoinstance.findAll();
	}


	@Override
	public Movie insertNewMovie(movieReqDTO newMovieDTO) {
		
		Integer pid=newMovieDTO.getPid();
		System.out.println(pid);
		producer producer = producerRepoInstance.findById(pid).orElseThrow(()->new resourseNotFoundException("invalid Producer ID"));
		
		Movie newMovie = mapper.map(newMovieDTO, Movie.class);
		System.out.println(newMovie.getId());
	    producer.addMovie(newMovie);
		
	    movieRepoinstance.save(newMovie);
		return newMovie;
	}



	public Movie UpdateMovie(updateMovieDTO updatedMovie) {
		// TODO Auto-generated method stub
		
		Integer movieid = updatedMovie.getId();
		Movie upMovie =  movieRepoinstance.findById(movieid).orElseThrow(()->new resourseNotFoundException("invalid movie id"));
		
		upMovie.setName(updatedMovie.getName());
		upMovie.setRating(updatedMovie.getRating());
		upMovie.setTicket(updatedMovie.getTicket());
		upMovie.setReleseDate(updatedMovie.getReleseDate());
		
		return movieRepoinstance.save(upMovie);
	}


	@Override
	public String deleteMovie(Integer movieId) {
		// TODO Auto-generated method stub
		String msg="Movie not deleted";
		if(movieRepoinstance.existsById(movieId)) {
			movieRepoinstance.deleteById(movieId);
			msg="Movie  deleted";
		}
		return msg;
	}

}
