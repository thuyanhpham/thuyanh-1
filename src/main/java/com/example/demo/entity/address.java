package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class address {

	@Id
	@GeneratedValue
	private Long id;
	
	private String city;
	private String province;
	
	@OneToMany(mappedBy ="address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Person> persons = new ArrayList<>();


}
