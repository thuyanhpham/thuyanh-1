package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repo.EmployeeRepository;


@Controller
@RequestMapping()
public class LoginController {
	private EmployeeRepository employeeRepository;
	
	private static final String ID3 = "id";
	private static final String ID2 = ID3;
	
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
	
	@PostMapping("/saveEmployee")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
		repo.save(employee);
		return new ResponseEntity<String>("Employee Saved", HttpStatus.OK);
	}
	
	@GetMapping("employee/all")
	public ResponseEntity<List<Employee>> getAll() {
		List<Employee> allEmployee = (List<Employee>) EmployeeService.getAllEmployee();
		List<Employee> listEmployee = allEmployee;
		return new ResponseEntity<List<Employee>>(listEmployee, HttpStatus.OK);
	}
	
	//Add new employee

	@PostMapping("employee/add")
	public ResponseEntity<?> addEmployee (@RequestBody Employee std) {
		Employee dataStd = EmployeeService.addEmployee(std);
		if (dataStd != null) {
			return new ResponseEntity<Employee>(dataStd, HttpStatus.OK);
		}
		return new ResponseEntity<APIMessages>(HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("employee/{id}")
	public ResponseEntity<?> updateEmployee(@PathVariable(ID2) long id, @RequestBody Employee std) {
		Employee dataStd = EmployeeService.getEmployee(id);
		if (dataStd == null) {
			APIMessages apiErr = new APIMessages();
			return new ResponseEntity<Object>(apiErr, HttpStatus.NOT_FOUND);
		}else {
			dataStd.setName(std.getName());
			dataStd.setEmail(std.getEmail());
			dataStd.setPhone(std.getPhone());
			dataStd.setAddress(std.getAddress());
			EmployeeService.updateEmployee(dataStd);
			return new ResponseEntity<Employee>(dataStd, HttpStatus.OK);
		}
	}
	

	@DeleteMapping("employee/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(ID3) long id) {
		Employee dataStd = EmployeeService.getEmployee(id);
		if (dataStd == null) {
			APIMessages apiErr = new APIMessages();
			return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
		} else {
			boolean delEmployee = EmployeeService.delEmployee(id);
			APIMessages apiErr = new APIMessages();
			return new ResponseEntity<APIMessages>(apiErr, HttpStatus.OK);
		}
	}
	

}
