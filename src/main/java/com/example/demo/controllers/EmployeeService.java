package com.example.demo.controllers;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface EmployeeService {

	public Employee create(Employee employee);

	 List<Employee> getAllEmployee() ;

	static Employee getEmployee(long id) {
		return null;
	}

	static Employee addEmployee(Employee employee) {
		return null;
	}

	static Employee updateEmployee(Employee employee) {
		return null;
	}

	static boolean delEmployee(long id) {
		return false;
	}

	public void save(Employee employee);

	public void save(Employee employee);
}
