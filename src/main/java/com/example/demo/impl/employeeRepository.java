package com.example.demo.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.controllers.Employee;
import com.example.demo.controllers.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee save(Long id);

	List<Employee> findByNameContainingIgnoreCase(String keyword);



}
