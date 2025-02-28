package EmployeeServices;

import java.util.List;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.Employee;

@Service
@ComponentScan
@SpringBootApplication
public interface EmployeeService {
	
	//Get all employee
	public List<Employee> getAllEmployee();
	
	//Create new employee
	public Employee addEmployee(Employee employee);
	
	//Update employee
	public Employee updateEmployee(Employee employee);
	
	//Delete employee
	public boolean delEmployee(long id);
	
}
