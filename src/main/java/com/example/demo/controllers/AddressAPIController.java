package com.example.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.AddressDTO;
import com.example.demo.impl.AddressService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

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

}
