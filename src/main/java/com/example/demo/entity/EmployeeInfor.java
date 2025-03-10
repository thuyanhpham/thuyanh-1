package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class EmployeeInfor implements Serializable {

	 private static final long serialVersionUID = -297553281792804396L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @Column(name = "name")
	    private String name;

	    private String email;
	    private String phone;
	
		public String getEmail() {
			return null;
		}

		public String getName() {
			return null;
		}

		public Long getAddressId() {
			return null;
		}
}
