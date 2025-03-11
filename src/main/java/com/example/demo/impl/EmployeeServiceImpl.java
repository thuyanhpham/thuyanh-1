package com.example.demo.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Override
	public List<Employee> getAllEmployee() {
		List<Employee> listEmployee = employeeRepository.findAll();
		return listEmployee;
	}
	
	public Employee addEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}
	
	public Employee updateEmployee(Employee employee) {
		if(employee.getAddress1() != null) {
			Address address = addressRepository.findById(employee.getAddress1().getId()).get();
			employee.setAddress1(address);
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

	public void save(Employee employee) {
		if(employee.getAddress1() != null) {
			Address address = addressRepository.findById(employee.getAddress1().getId()).get();
			employee.setAddress1(address);
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
		// TODO Auto-generated method stub
		return null;
	}

	public void setEmployeeRepository(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee updateEmployee(Long id, EmployeeInfor employeeInfor) {
		return null;
	}


}
