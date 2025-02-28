package com.example.demo.controllers;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Repository;

import com.example.demo.repo.EmployeeRepository;



@SpringBootApplication
@Repository
@ComponentScan
public class app {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(app.class, args);
		 EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

		
		employeeRepository.findAll()
							.forEach(System.out::println);
		
		Employee employee = employeeRepository.save(new Employee());
		
		System.out.println("Employee vừa có ID: " + employee.getName());
		employeeRepository.save(employee);
		
		
		
	}
}
