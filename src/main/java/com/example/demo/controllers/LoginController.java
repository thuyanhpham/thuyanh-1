package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping()

public class LoginController {
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
}
