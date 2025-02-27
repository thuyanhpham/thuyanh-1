package EmployeeServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.example.demo.controllers.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
@ComponentScan
@SpringBootApplication
public abstract class EmployeeService implements com.example.demo.controllers.EmployeeService {

	@Autowired
	EmployeeRepository employeerepository;
	@Override
	public Employee create(Employee employee) {
		return employeerepository.save(employee);
	}
}
