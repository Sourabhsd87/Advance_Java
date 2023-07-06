package com.app.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

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
public class Author extends baseEntity{

	@Column(unique = true)
	private String authorname;
	private Integer age;
	private String address;
	private String email;
	@OneToMany(mappedBy = "author",cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	private List<book> bookList = new ArrayList<>();
}
