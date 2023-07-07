package com.app.DTO;

import java.time.LocalDate;


import com.app.entities.Rating;


public class movieReqDTO {
	
	private String name;
	private Double ticket;
	private Rating rating;
	private LocalDate releseDate;
	
	private Integer pid;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getTicket() {
		return ticket;
	}

	public void setTicket(Double ticket) {
		this.ticket = ticket;
	}

	public Rating getRating() {
		return rating;
	}

	public void setRating(Rating rating) {
		this.rating = rating;
	}

	public LocalDate getReleseDate() {
		return releseDate;
	}

	public void setReleseDate(LocalDate releseDate) {
		this.releseDate = releseDate;
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "movieReqDTO [name=" + name + ", ticket=" + ticket + ", rating=" + rating + ", releseDate=" + releseDate
				+ ", Pid=" + pid + "]";
	}
	
	
}
