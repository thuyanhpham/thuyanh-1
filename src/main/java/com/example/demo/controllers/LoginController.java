package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.dto.AddressDTO;
import com.example.demo.entity.Address;
import com.example.demo.entity.Employee;
import com.example.demo.entity.EmployeeInfor;
import com.example.demo.impl.AddressService;
import com.example.demo.impl.EmployeeService;

import jakarta.validation.Valid;

@Controller
@RequestMapping()
public class LoginController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@Autowired
	private AddressService addressService;

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
		model.addAttribute("address", addressService.getAll());
		return "addEmployee";
	}
	
	@PostMapping("/employee/save")
	public String SaveEmployee(@Valid @ModelAttribute Employee employee, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("address", addressService.getAll());
			model.addAttribute("Employee", employee);
			return "addEmployee";
		}
		employeeService.save(employee);
		return "redirect:/list";
	}
	
	@GetMapping("/employee/edit/{id}")
	public String showEditForm(@PathVariable("id") Long id, Model model) {
		Employee employee = employeeService.findById(id);
		model.addAttribute("Employee", employee);
		model.addAttribute("address", addressService.getAll());
		return "editEmployee";
	}
	
	@PostMapping("/employee/update")
	public String updateEmployee(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes) {
		employeeService.updateEmployee(employee);
		redirectAttributes.addFlashAttribute("message","Cập nhật thành công!");
		return "redirect:/list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable Long id) {
		employeeService.deleteEmployeeById(id);
		return "redirect:/list";
		
	}
	
    @GetMapping("/employee/search")
    public String listEmployee(@RequestParam(value = "keyword", required = false) String keyword, Model model) {
        List<Employee> employee = employeeService.getAllEmployee(keyword);
        model.addAttribute("listEmployee", employee);
        model.addAttribute("keyword", keyword);
        return "list";
    }
    
    @PostMapping
    public ResponseEntity<String> createEmployee(@Valid @RequestBody Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            return ResponseEntity.badRequest().body(result.getAllErrors().toString());
        }
        return ResponseEntity.ok("Thêm Nhân Viên Thành Công!");
    }
}
