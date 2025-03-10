package com.example.demo.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.AddressDTO;
import com.example.demo.entity.Address;
import com.example.demo.repo.AddressRepository;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    private AddressRepository addressRepository;

    @Override
    public List<AddressDTO> getAll() {
        List<Address> listEntity = addressRepository.findAll();
        List<AddressDTO> listDTO = new ArrayList<>();

        // convert from Entity to DTO class
        listEntity.forEach(entity -> {
            AddressDTO dto = new AddressDTO();
            dto.setId(entity.getId());
            dto.setCity(entity.getCity());
            dto.setProvince(entity.getProvince());
            listDTO.add(dto);
        });
        return listDTO;
    }

	@Override
	public Address getById(Long id) {
		return addressRepository.findById(id).orElse(null);
	}
	
	@Override
	public Address save(Address address) {
		return addressRepository.save(address);
	}
	
	@Override
	public Address update(Long id, Address address) {
		Optional<Address> existingAddress = addressRepository.findById(id);
		if (existingAddress.isPresent()) {
			Address updateAddress = existingAddress.get();
			updateAddress.setCity(address.getCity());
			updateAddress.setProvince(address.getProvince());
			return addressRepository.save(updateAddress);
		}
		return null;
	}
	
	@Override
	public void delete(Long id) {
		addressRepository.deleteById(id);
	}

	@Override
	public Address findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}


}
