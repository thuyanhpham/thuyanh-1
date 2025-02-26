package com.example.demo.controllers;

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
	
}
