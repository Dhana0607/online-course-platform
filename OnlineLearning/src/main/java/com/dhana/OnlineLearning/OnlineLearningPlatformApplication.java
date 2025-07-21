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
}

