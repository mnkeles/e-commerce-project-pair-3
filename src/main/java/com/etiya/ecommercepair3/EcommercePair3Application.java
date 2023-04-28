package com.etiya.ecommercepair3;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EcommercePair3Application {

	public static void main(String[] args) {
		SpringApplication.run(EcommercePair3Application.class, args);
	}

	@Bean
	public ModelMapper getMapper(){
		return new ModelMapper();
	}

}
