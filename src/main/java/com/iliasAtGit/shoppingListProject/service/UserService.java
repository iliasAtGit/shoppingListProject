package com.iliasAtGit.shoppingListProject.service;

import java.util.List;

import com.iliasAtGit.shoppingListProject.model.User;

public interface UserService {
	User findByUsername(String username);

    User findById(long id);

	void save(User user);

    void update(User user);

    void deleteById(long id);

    List<User> findAll();

    void deleteAll();

    public boolean isUserExist(User user);
}
