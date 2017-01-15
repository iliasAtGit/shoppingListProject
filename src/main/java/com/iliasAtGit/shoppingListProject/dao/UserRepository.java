package com.iliasAtGit.shoppingListProject.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.iliasAtGit.shoppingListProject.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
	@Override
	List<User> findAll();
}
