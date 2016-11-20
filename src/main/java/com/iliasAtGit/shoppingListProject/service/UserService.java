package com.iliasAtGit.shoppingListProject.service;

import com.iliasAtGit.shoppingListProject.model.User;

public interface UserService {
	void save(User user);

	User findByUsername(String username);
}
