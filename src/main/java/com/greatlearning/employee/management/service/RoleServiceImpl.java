package com.greatlearning.employee.management.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.employee.management.entity.Role;
import com.greatlearning.employee.management.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public Role saveRole(Role role) {
		roleRepository.findAll();
		return roleRepository.save(role);
	}

}
