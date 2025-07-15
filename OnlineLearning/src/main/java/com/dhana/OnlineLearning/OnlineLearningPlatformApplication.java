package com.dhana.OnlineLearning;

import com.dhana.OnlineLearning.repository.UserRepository;
import com.dhana.OnlineLearning.model.User;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineLearningPlatformApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineLearningPlatformApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(UserRepository repo) {
		return args -> {
			repo.save(new User(null, "Dhana", "dhana@example.com"));
			repo.save(new User(null, "Ravi", "ravi@example.com"));
		};
	}

}

