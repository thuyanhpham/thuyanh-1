package com.example.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeInfor;
import com.example.demo.repo.EmployeeRepository;

@Service
public interface EmployeeService {
	public static final EmployeeRepository employeeRepository = null;
	public Employee create(Employee employee);

	 List<Employee> getAllEmployee() ;

	static Employee getEmployee(long id) {
		return null;
	}

	public Employee addEmployee(EmployeeInfor employeeInfor);
	 Employee updateEmployee(Employee employee);

	static boolean delEmployee(long id) {

		return false;
	}

	public void save(Employee employee);

	public void deleteEmployeeById(Long id);
	Employee findById(Long id);

	List<Employee> getAllEmployee(String keyword);

	public Employee updateEmployee(Long id, EmployeeInfor employeeInfor);

	
}
