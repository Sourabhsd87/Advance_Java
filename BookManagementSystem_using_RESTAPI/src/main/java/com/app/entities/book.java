package com.app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@JsonIgnoreType
public class book extends baseEntity{

	@Column(unique = true)
	private String bookName;
	private Integer Price;
	@ManyToOne
	private Author author;
	private Integer quantity;
	@Enumerated(EnumType.STRING)
	private Genre genre;
	
}
