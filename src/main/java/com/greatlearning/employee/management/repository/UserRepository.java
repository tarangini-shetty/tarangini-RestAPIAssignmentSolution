package com.greatlearning.employee.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.greatlearning.employee.management.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	public User findByUsername(String username);

}
