package com.example.demo.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controllers.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee save(Long id);


}
