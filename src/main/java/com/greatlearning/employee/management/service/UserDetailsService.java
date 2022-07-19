package com.greatlearning.employee.management.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface UserDetailsService {
	
	public UserDetails loadUserByUsername(String username);

}