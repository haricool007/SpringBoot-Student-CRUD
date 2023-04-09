package com.Student.SpringBoot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.controller") // to specify package name of controller
@EnableJpaRepositories(basePackages = "com.repository") // to specify package name of repository
@EntityScan(basePackages = "com.Student.Entity") // to specify entity classes

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
