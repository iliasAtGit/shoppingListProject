package com.iliasAtGit.shoppingListProject.service;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.iliasAtGit.shoppingListProject.dao.RoleRepository;
import com.iliasAtGit.shoppingListProject.dao.UserRepository;
import com.iliasAtGit.shoppingListProject.model.Role;
import com.iliasAtGit.shoppingListProject.model.User;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	private static List<User> users;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public void save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setRoles(new HashSet<Role>(){{add(roleRepository.findByName("ROLE_USER"));}});
		userRepository.save(user);
	}

    @Override
	public List<User> findAll() {
    	return userRepository.findAll();
    }

    @Override
	public User findById(long id) {
        for(User user : users){
            if(user.getId() == id){
                return user;
            }
        }
        return null;
    }


    @Override
	public void update(User user) {
        int index = users.indexOf(user);
        users.set(index, user);
    }

    @Override
	public void deleteById(long id) {

        for (Iterator<User> iterator = users.iterator(); iterator.hasNext(); ) {
            User user = iterator.next();
            if (user.getId() == id) {
                iterator.remove();
            }
        }
    }

    @Override
	public boolean isUserExist(User user) {
        return findByUsername(user.getUsername())!=null;
    }

    @Override
	public void deleteAll(){
        users.clear();
    }

}
