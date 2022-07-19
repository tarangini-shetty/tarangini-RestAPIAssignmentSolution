package com.greatlearning.employee.management;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.greatlearning.employee.management.entity.Role;
import com.greatlearning.employee.management.entity.User;
import com.greatlearning.employee.management.service.RoleService;
import com.greatlearning.employee.management.service.UserService;


@SpringBootApplication
public class EmployeeManagementApplication implements CommandLineRunner {

	@Autowired
	RoleService roleService;
	
	@Autowired
	UserService userService;
	
	Role role;
	User user;
	
	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Initializing the db with ADMIN role 
		role = Role.builder().id(1).name("ADMIN").build();
		roleService.saveRole(role);
		
		//Initializing the db user table with user1 and assigning ADMIN role to it
		List<Role> roleForUser = new ArrayList<>();
		roleForUser.add(role);
		user = User.builder().id(1l).username("user1").password("user1").roles(roleForUser).build();
		userService.saveUser(user);
		
	}
}
