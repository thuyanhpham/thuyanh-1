package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.impl.EmployeeRepository;

@Service
public interface EmployeeService {
	public static final EmployeeRepository employeeRepository = null;
	public Employee create(Employee employee);

	 List<Employee> getAllEmployee() ;

	static Employee getEmployee(long id) {
		return null;
	}

	static Employee addEmployee(Employee employee) {
		return null;
	}

	 Employee updateEmployee(Employee employee);

	static boolean delEmployee(long id) {

		return false;
	}

	public void save(Employee employee);

	public void deleteEmployeeById(Long id);
	Employee findById(Long id);

	public static com.example.demo.controllers.List<Employee> searchEmployee(String keyword) {
	return employeeRepository.findByNameContainingIgnoreCase(keyword);
	}
}
