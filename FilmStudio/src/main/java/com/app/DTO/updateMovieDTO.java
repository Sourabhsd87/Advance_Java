package com.app.DTO;

import java.time.LocalDate;

import com.app.entities.Rating;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class updateMovieDTO {

	private Integer id;
	private String name;
	private Double ticket;
	private Rating rating;
	private LocalDate releseDate;
	
	private Integer pid;

	public updateMovieDTO(Integer id, String name, Double ticket, Rating rating, LocalDate releseDate, Integer pid) {
		super();
		this.id = id;
		this.name = name;
		this.ticket = ticket;
		this.rating = rating;
		this.releseDate = releseDate;
		this.pid = pid;
	}
	
	
}
