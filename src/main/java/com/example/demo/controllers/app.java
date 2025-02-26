package com.example.demo.controllers;

import javax.naming.Context;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.WebProperties.Resources.Chain.Strategy.Content;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication

public class app {
	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(app.class, args);
		EmployeeRepository employeeRepository = Context.getName(EmployeeRepository.class);
		
		employeeRepository.findAll()
							.forEach(System.out::println);
		
		Employee employee = employeeRepository.save(new Employee());
		
		System.out.println("Employee vừa có ID: " + employee.getName());
		String employeeId = employee.getName();
		
		
		employeeRepository.save(employee);
		
		
		
	}
}
