package com.example.exemplo_data_rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class ExemploDataRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExemploDataRestApplication.class, args);
	}

}
