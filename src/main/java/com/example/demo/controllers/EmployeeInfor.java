package com.example.demo.controllers;

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
	    private String add;
}
