package com.exercici.jocdedaus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = {"com.exercici.jocdedaus.repositories.mongodb"})
@EnableJpaRepositories(basePackages = {"com.exercici.jocdedaus.repositories.mysql"})
@SpringBootApplication
public class JocdedausApplication {

	public static void main(String[] args) {
		SpringApplication.run(JocdedausApplication.class, args);
	}

}
