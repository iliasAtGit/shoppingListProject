package com.iliasAtGit.shoppingListProject.service;

import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class CustomSecurityUser extends User {

   private static final long serialVersionUID = -3531439484732724601L;

   private Long id;


public CustomSecurityUser(String username, String password, boolean enabled,
       boolean accountNonExpired, boolean credentialsNonExpired,
       boolean accountNonLocked,
       Set<GrantedAuthority> authorities,
       Long id) {

           super(username, password, enabled, accountNonExpired,
              credentialsNonExpired, accountNonLocked, authorities);

           this.id = id;

   }

   public Long getId() {
	   return id;
   }

	public void setId(Long id) {
		this.id = id;
	}

}