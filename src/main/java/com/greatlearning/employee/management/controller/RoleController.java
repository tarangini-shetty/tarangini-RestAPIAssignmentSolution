package com.greatlearning.employee.management.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.employee.management.entity.Role;
import com.greatlearning.employee.management.service.RoleService;

@RestController
@RequestMapping("/api")
public class RoleController {
	
	@Autowired
	private RoleService roleService;
	
	@PostMapping("/role")
	public Role saveRole(@RequestBody Role role) {
		return roleService.saveRole(role);
	}
	
}
