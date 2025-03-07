package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AddressDTO;
import com.example.demo.entity.Address;
import com.example.demo.impl.AddressService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController //khai báo rest api controller
@RequestMapping("/api/address")
public class AddressAPIController {
    @Autowired
    private AddressService addressService;

    @GetMapping //ko khai báo url, nên mặc định sẽ là '/api/address'
    public ResponseEntity<List<AddressDTO>> getAllAddress() {
        List<AddressDTO> list = addressService.getAll();
        return ResponseEntity.ok(list);
    }
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable Long id) {
    	Address address = addressService.getById(id) ;
    	AddressDTO addressDTO = new AddressDTO();
    	addressDTO.setCity(address.getCity());
    	return ResponseEntity.ok(addressDTO);
    }
    
    @PostMapping
    public ResponseEntity<Address> address(@RequestBody Address address) {
    	return ResponseEntity.ok(addressService.save(address));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
    	Address updateAddress = addressService.update(id, address);
    	return (updateAddress != null) ? ResponseEntity.ok(updateAddress) : ResponseEntity.notFound().build();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAdress(@PathVariable Long id) {
    	addressService.delete(id);
    	return ResponseEntity.noContent().build();
    }
    
    
}
