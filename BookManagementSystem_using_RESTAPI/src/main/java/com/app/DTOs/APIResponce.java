package com.app.DTOs;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class APIResponce {
	
	private String message;
	private LocalDateTime timeStamp;
	
	public APIResponce(String msg) {
		this.message=msg;
		this.timeStamp=LocalDateTime.now();
	}
}
