package com.iliasAtGit.shoppingListProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iliasAtGit.shoppingListProject.dao.RoleRepository;
import com.iliasAtGit.shoppingListProject.model.Role;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Override
	public Role findByName(String name) {
		return roleRepository.findByName(name);
	}
}
