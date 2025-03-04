package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
@EnableJpaRepositories(basePackages="com.example.demo.repo")
@SpringBootApplication
public class Thuyanh1Application {

	public static void main(String[] args) {
		SpringApplication.run(Thuyanh1Application.class, args);
	}

}
