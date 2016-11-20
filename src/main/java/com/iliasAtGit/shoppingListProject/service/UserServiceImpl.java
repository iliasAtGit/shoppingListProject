package com.iliasAtGit.shoppingListProject.service;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iliasAtGit.shoppingListProject.dao.RoleDao;
import com.iliasAtGit.shoppingListProject.dao.UserDao;
import com.iliasAtGit.shoppingListProject.model.Role;
import com.iliasAtGit.shoppingListProject.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userRepository;
	@Autowired
	private RoleDao roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<Role>(){{add(roleRepository.findByName("ROLE_USER"));}});
		userRepository.save(user);
	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}