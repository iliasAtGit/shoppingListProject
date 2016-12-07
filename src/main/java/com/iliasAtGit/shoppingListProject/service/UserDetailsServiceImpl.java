package com.iliasAtGit.shoppingListProject.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.iliasAtGit.shoppingListProject.dao.UserRepository;
import com.iliasAtGit.shoppingListProject.model.Role;
import com.iliasAtGit.shoppingListProject.model.User;

public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException, DataAccessException {
		CustomSecurityUser customSecurityUser = null;
		Set<GrantedAuthority> grantedAuthorities = new HashSet<>();

		if (!"".equals(username)) {
			User userProfile = userRepository.findByUsername(username);

			if (null != userProfile) {
				for (Role role : userProfile.getRoles()) {
					grantedAuthorities.add(new SimpleGrantedAuthority(role.getName()));
				}

				customSecurityUser = new CustomSecurityUser(username, userProfile.getPassword(), true, true, true, true,
						grantedAuthorities, userProfile.getId());

			} else {
				customSecurityUser = new CustomSecurityUser(username, "NA", true, true, true, true, grantedAuthorities,
						null);
			}
		} else {
			customSecurityUser = new CustomSecurityUser(username, "NA", true, true, true, true, grantedAuthorities,
					null);
		}

		return customSecurityUser;
	}
}
