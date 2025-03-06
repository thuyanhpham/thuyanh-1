package com.example.demo.repo;

import java.util.List;

import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Employee;
import com.example.demo.entity.Person;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

	Employee save(Long id);

	List<Employee> findByNameContainingIgnoreCase(String keyword);

	public interface AddressRepository extends JpaRepository<Address, Long> {
		
	}
	public interface PersonRepository extends JpaRepository<Person, Long> {
		
	}


}
