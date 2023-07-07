package com.app.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString(exclude = "password")
@JsonIgnoreType
public class producer extends baseEntity{

	@Column(unique = true)
	private String pname;
	@Min(20)
	private Integer age;
	@Email
	private String email;
	@Past
	private LocalDate dob;
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%])[a-zA-Z0-9@#$%]{5,10}$")
	private String password;
	@OneToMany(mappedBy = "producer",fetch = FetchType.EAGER)
	private List<Movie> movieList =new  ArrayList<>();
	public producer(String pname, @Min(20) Integer age, @Email String email, @Past LocalDate dob,
			@Pattern(regexp = "^(?=.*[0-9])(?=.*[@#$%])[a-zA-Z0-9@#$%]{5,10}$") String password) {
		super();
		this.pname = pname;
		this.age = age;
		this.email = email;
		this.dob = dob;
		this.password = password;
	}
	
	public boolean addMovie(Movie newMovie) {
		
		movieList.add(newMovie);
		newMovie.setProducer(this);

		return true;
	}
}
