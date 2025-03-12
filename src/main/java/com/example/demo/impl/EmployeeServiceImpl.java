package com.example.demo.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeInfor;
import com.example.demo.repo.AddressRepository;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> listEmployee = employeeRepository.findAll();
		return listEmployee;
	}
	
	public Employee addEmployee(Employee employee) {
		String encodedPassword = passwordEncoder.encode(employee.getPassword());
		employee.setPassword(encodedPassword);
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		if(employee.getAddress1() != null) {
			Address address = addressRepository.findById(employee.getAddress1().getId()).get();
			employee.setAddress1(address);
		}
		if (employee.getPassword() != null && !employee.getPassword().startsWith("$2a$")) {
			String encodedPassword = passwordEncoder.encode(employee.getPassword());
			employee.setPassword(encodedPassword);
		}
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

	@Override
	public Employee create(Employee employee) {
		return null;
	}

	public void save(String username, String rawPassword) {
		String encodedPassword = passwordEncoder.encode(rawPassword);
		Employee employee = new Employee();
		employee.setUsername(username);
		employee.setPassword(encodedPassword);
		if(employee.getAddress1() != null) {
			Address address = addressRepository.findById(employee.getAddress1().getId()).get();
			employee.setAddress1(address);
		}
		if ( employee.getRole() == null || employee.getRole().isEmpty()) {
			employee.setRole("USER");
		}
		employeeRepository.save(employee);
	}

	@Override
	public void deleteEmployeeById(Long id) {
		employeeRepository.deleteById(id);
	}

	 @Override
	    public List<Employee> getAllEmployee(String keyword) {
	        if (keyword != null && !keyword.isEmpty()) {
	            return (List<Employee>) employeeRepository.findByNameContainingIgnoreCase(keyword);
	        }
	        return employeeRepository.findAll();
	    }

	@Override
	public Employee findById(Long id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public Employee addEmployee(EmployeeInfor employeeInfor) {
		return null;
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeInfor employeeInfor) {
		return null;
	}
	
	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee updateEmployee(Long id, Employee employee) {
		Employee existingEmployee = employeeRepository.findById(id).orElse(null);
		if (existingEmployee == null) {
			return null;
		}
		
		if (employee.getPassword() != null && !employee.getPassword().isEmpty()) {
			existingEmployee.setPassword(passwordEncoder.encode(employee.getPassword()));
		}
		
		if ( employee.getRole() == null) {
			employee.setRole("USER");
		}
		return employeeRepository.save(existingEmployee);
	}

	public void registerEmployee(String username, String inputPassword) {
		Optional<Employee> employee = employeeRepository.findByUsername(username);
		
		if (!employee.isPresent()) {
			return;
		}
		
	}
	
	public void saveEmployee(String username, String rawPassword) {
		String encodedPassword = passwordEncoder.encode(rawPassword);
	}

	@Override
	public void save(Employee employee) {
		// TODO Auto-generated method stub
		
	}

	
	
}
