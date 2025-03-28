package com.swish.nbastats;

import com.swish.nbastats.model.Player;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.LinkedList;

@SpringBootApplication
@EnableJpaRepositories // Enables JPA repositories (this is optional as Spring Boot auto-configures it)
public class NbaStatsApplication {

	public static void main(String[] args) {
		SpringApplication.run(NbaStatsApplication.class, args);
	}

}
