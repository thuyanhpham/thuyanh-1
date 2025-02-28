package com.example.demo.impl;

import java.util.List;

import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.Employee;
import com.example.demo.controllers.EmployeeService;

@Service
public abstract class EmployeeServiceImpl implements EmployeeService {

	public List<Employee> getAllEmployee() {
		List<Employee> listEmployee = Repository.findAll();
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
