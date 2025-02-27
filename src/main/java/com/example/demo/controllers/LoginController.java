package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import EmployeeServices.EmployeeService;


@Controller
@RequestMapping()

public class LoginController {
	
	@Autowired
	EmployeeService employeeService;
	@GetMapping("/")
	public String addEmployee(Model model) {
		model.addAttribute("employee", new Employee());
		return "index";
		
	}
	
	@PostMapping("/post")
	public String post(@ModelAttribute Employee employee, ModelMap modelMap) {
		modelMap.addAttribute("employee", employee);
		return "result";
	}
	
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeService.create(employee);
	}
}
