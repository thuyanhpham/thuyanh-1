package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.Employee;
import com.example.demo.controllers.EmployeeService;
import com.example.demo.repo.EmployeeRepository;

@Service

public abstract class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<Employee> getAllEmployee() {
		List<Employee> listEmployee = employeeRepository.findAll();
		return listEmployee;
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		employee = employeeRepository.save(employee);
		return employee;
	}
	
	public boolean delEmployee(long id) {
		Employee employee = employeeRepository.getOne(id);
		if (employee != null) {
			employeeRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
