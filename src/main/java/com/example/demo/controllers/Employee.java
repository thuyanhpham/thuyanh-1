package com.example.demo.controllers;

import java.io.Serializable;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Repository
public class Employee {

	private String name;
	private String email;
	private String phone;
	private String add;
	
	public Employee() {}

	public Employee(String name, String email, String phone, String add) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.add = add;
	}
	
	public String getAdd() {
		return add;
	}
	public void setAdd(String add) {
		this.add = add;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public class Employeeinfor implements Serializable {
	    private static final long serialVersionUID = -297553281792804396L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name")
	    private String name;

	    private String email;
	    private String phone;
	    private String add;
	}
	
	public interface EmployeeRepository extends JpaRepository<Employee, Long> {
		
	}
	
}