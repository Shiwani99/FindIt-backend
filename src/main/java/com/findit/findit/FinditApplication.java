package com.findit.findit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.findit.findit.repository")
public class FinditApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinditApplication.class, args);
	}

}
