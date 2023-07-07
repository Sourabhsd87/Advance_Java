package com.app;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ElectionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectionApplication.class, args);
	}

	@Bean
	public ModelMapper mapper() {
		ModelMapper mymapper=new ModelMapper();
		mymapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		return mymapper;
	}
}
