package com.example.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.dto.AddressDTO;
import com.example.demo.entity.Address;
import com.example.demo.repo.AddressRepository;

@Service
public interface AddressService {
    List<AddressDTO> getAll();

	Address getById(Long id);
	Address save(Address address);
	Address update(Long id, Address address);
	void delete(Long id);

	Address findById(Long id);

	List<Address> getAllAddress();
}