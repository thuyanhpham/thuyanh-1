package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.Address;
import com.example.demo.impl.AddressService;

@Controller
@RequestMapping("/address")
public class AddressViewController {

	  @Autowired
	    private AddressService addressService;
	  
	  public AddressViewController(AddressService addressService) {
		  this.addressService = addressService;
	  }
	  
	  @GetMapping
	  public String showAddressList(Model model) {
		  model.addAttribute("address", addressService.getAll());
		  return "address";
	  }
	  
	  @GetMapping("/add")
	  public String showAddForm(Model model) {
		  model.addAttribute("address", new Address());
		  return "addAddress";
	  }
	  
	  @PostMapping("/save")
	  public String saveAddress(@ModelAttribute Address address) {
		  addressService.save(address);
		  return "redirect:/address";
	  }
	  
	  @GetMapping("/edit/{id}")
	  public String showEditForm(@PathVariable Long id, Model model) {
		  Address address = addressService.getById(id);
		  model.addAttribute("address", address);
		  return "editAddress";
	  }
	  
	  @PostMapping("/update/{id}")
	  public String updateAddress(@PathVariable Long id, @ModelAttribute Address address) {
		  addressService.update(id, address);
		  return "redirect:/address";
	  }
	  
	  @GetMapping("/delete/{id}")
	  public String deleteAddress(@PathVariable Long id) {
		  addressService.delete(id);
		  return "redirect:/address";
	  }
	  
	  
	  
}
