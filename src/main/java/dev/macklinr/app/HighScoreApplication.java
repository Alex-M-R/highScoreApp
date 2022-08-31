package dev.macklinr.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"dev.macklinr"})
@EntityScan(basePackages = {"dev.macklinr.entities"})
@EnableJpaRepositories(basePackages = {"dev.macklinr.repos"})
public class HighScoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(HighScoreApplication.class, args);
	}

}
