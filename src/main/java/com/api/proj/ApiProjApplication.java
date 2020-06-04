package com.api.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"models"})
@ComponentScan({"controllers", "service"})
@EnableJpaRepositories(basePackages = "repositories")
@EnableJpaAuditing
public class ApiProjApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiProjApplication.class, args);
	}

}
