package com.example.demo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
@Entity

public class EmployeeInfor implements Serializable {

	 private static final long serialVersionUID = -297553281792804396L;

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	     @NotEmpty(message = "Tên không được để trống!")
	    @Column(name = "name")
	    private String name;
	    
	     @NotEmpty(message = "Email không được để trống!")
	     @Email(message = "Email không hợp lệ")
	    private String email;
	     
	     public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public void setName(String name) {
			this.name = name;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@NotEmpty(message = "Thiếu số điện thoại")
	    private String phone;
	
		public String getEmail() {
			return null;
		}

		public String getName() {
			return null;
		}

		public Long getAddressId() {
			return null;
		}
}
