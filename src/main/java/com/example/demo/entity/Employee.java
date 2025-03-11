package com.example.demo.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Valid
	@NotEmpty(message = "Tên không được để trống!")
	private String name;
	
	@Valid
	@NotEmpty(message = "Email không được để trống!")
    @Email(message = "Email không hợp lệ")
	private String email;
	
	@Valid
	@NotEmpty(message = "Thiếu số điện thoại")
	private String phone;
	private String address;
	@ManyToOne
    @JoinColumn(name = "address_id")
	@NotNull(message = "Vui lòng chọn địa chỉ!")
    private Address address1;
	
	public Employee() {}

	public Employee(String name, String email, String phone, String address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
		
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address2) {
		this.address = address2;
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

	public Address getAddress1() {
		return address1;
	}

	public void setAddress1(Address address1) {
		this.address1 = address1;
	}


}