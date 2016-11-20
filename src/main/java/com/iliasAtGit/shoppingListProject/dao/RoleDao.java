package com.iliasAtGit.shoppingListProject.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iliasAtGit.shoppingListProject.model.Role;

public interface RoleDao extends JpaRepository<Role, Long>{
	Role findByName(String name);
}
