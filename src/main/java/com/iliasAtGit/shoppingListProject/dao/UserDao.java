package com.iliasAtGit.shoppingListProject.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.iliasAtGit.shoppingListProject.model.User;

//@Component is Spring annotation that tell the Spring container
//that we can use this class through Spring IoC (Dependency Injection).
@Repository
public class UserDao extends GenericDao {// extends JpaRepository<User, Short> {

	@PersistenceContext
	private EntityManager em;

	public UserDao() {
		super();
	}

	public void save(User user) {
		super.save(user);
	}

	public User findById(Short id) {
		return em.find(User.class, id);
	}

	public User findByUsername(String username) {
		return em.find(User.class, username);
	}
}