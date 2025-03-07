package com.example.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AddressDTO;

@Service
public interface AddressService {
    List<AddressDTO> getAll();
}