package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookShopApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookShopApplication.class, args);
	}

	@Bean
	public ModelMapper myMapper() {
		ModelMapper mymap= new ModelMapper();
		
		mymap.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mymap;
	}
}
