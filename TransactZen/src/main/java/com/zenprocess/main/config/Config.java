package com.zenprocess.main.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.zenprocess.main.document.User;
import com.zenprocess.main.repository.UsersRepository;

@EnableMongoRepositories(basePackageClasses = UsersRepository.class)
@Configuration
public class Config {
	
	@Bean
	CommandLineRunner lineRunner(UsersRepository usersRepository) {
		return strings -> {
			usersRepository.save(new User(1, 1, 1, "Luzbel", "Umana"));
			usersRepository.save(new User(2, 1, 1, "Mefisto", "Lumiel"));
			usersRepository.save(new User(3, 1, 1, "Baal", "Trampolin"));
		};
	}

}
