package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping()
public class LoginController {
	@Autowired
	private EmployeeService employeeService;

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

//	@PostMapping("/saveEmployee")
//	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee) {
//		repo.save(employee);
//		return new ResponseEntity<String>("Employee Saved", HttpStatus.OK);
//	}
//
//	@GetMapping("employee/all")
//	public ResponseEntity<java.util.List<Employee>> getAll() {
//		java.util.List<Employee> allEmployee = employeeService.getAllEmployee();
//		java.util.List<Employee> listEmployee = allEmployee;
//		return new ResponseEntity<java.util.List<Employee>>(listEmployee, HttpStatus.OK);
//	}
//
//	// Add new employee
//
//	@PostMapping("employee/add")
//	public ResponseEntity<?> addEmployee(@RequestBody Employee std) {
//		Employee dataStd = EmployeeService.addEmployee(std);
//		if (dataStd != null) {
//			return new ResponseEntity<Employee>(dataStd, HttpStatus.OK);
//		}
//		return new ResponseEntity<APIMessages>(HttpStatus.NOT_FOUND);
//	}
//
//	@PutMapping("employee/{id}")
//	public ResponseEntity<?> updateEmployee(@PathVariable(ID2) long id, @RequestBody Employee std) {
//		Employee dataStd = EmployeeService.getEmployee(id);
//		if (dataStd == null) {
//			APIMessages apiErr = new APIMessages();
//			return new ResponseEntity<Object>(apiErr, HttpStatus.NOT_FOUND);
//		} else {
//			dataStd.setName(std.getName());
//			dataStd.setEmail(std.getEmail());
//			dataStd.setPhone(std.getPhone());
//			dataStd.setAddress(std.getAddress());
//			EmployeeService.updateEmployee(dataStd);
//			return new ResponseEntity<Employee>(dataStd, HttpStatus.OK);
//		}
//	}
//
//	@DeleteMapping("employee/{id}")
//	public ResponseEntity<?> deleteEmployee(@PathVariable(ID3) long id) {
//		Employee dataStd = EmployeeService.getEmployee(id);
//		if (dataStd == null) {
//			APIMessages apiErr = new APIMessages();
//			return new ResponseEntity<APIMessages>(apiErr, HttpStatus.NOT_FOUND);
//		} else {
//			boolean delEmployee = EmployeeService.delEmployee(id);
//			APIMessages apiErr = new APIMessages();
//			return new ResponseEntity<APIMessages>(apiErr, HttpStatus.OK);
//		}
//	}

	@GetMapping("/list")
	public String listemployee(Model model) {
		java.util.List<Employee> listEmployee = employeeService.getAllEmployee();
		model.addAttribute("listEmployee", listEmployee);
		return "list";

	}
	
	@GetMapping("/detail/{id}")
	public String viewDetail(Model model, @PathVariable(name = "id") Long id) {
		java.util.List<Employee> listEmployee = employeeService.getAllEmployee();
		model.addAttribute("listEmployee", listEmployee);
		return "list";

	}
	
	@GetMapping("/employee/add")
	public String showAddEmployeeForm(Model model) {
		model.addAttribute("Employee", new Employee());
		return "addEmployee";
	}
	
	@PostMapping("/employee/save")
	public String SaveEmployee(@ModelAttribute Employee employee) {
		employeeService.save(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/employee/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Employee employee = EmployeeService.updateEmployee(id);
		model.addAttribute("Employee", employee);
		return "editEmployee";
	}
	
	@PostMapping("/employee/update")
	public String updateEmployee(@ModelAttribute Long employee, RedirectAttributes redirectAttributes) {
		EmployeeService.updateEmployee(employee);
		redirectAttributes.addFlashAttribute("message","Cập nhật thành công!");
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/list";
		
	}
	
}
