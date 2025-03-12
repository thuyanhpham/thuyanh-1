package com.example.demo.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface UserDetalsService {

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

}
