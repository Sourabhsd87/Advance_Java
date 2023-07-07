package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Past;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Setter
@Getter
@NoArgsConstructor
@ToString
@JsonIgnoreType
public class Movie extends baseEntity{

	@Column(unique = true )
	private String name;
	private Double ticket;
	@Enumerated(EnumType.STRING)
	private Rating rating;
	@Past
	private LocalDate releseDate;
	@ManyToOne
	private producer producer;
	
	public Movie(String name, Double ticket, Rating rating, @Past LocalDate releseDate) {
		super();
		this.name = name;
		this.ticket = ticket;
		this.rating = rating;
		this.releseDate = releseDate;
	}
	
	
}
