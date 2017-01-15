package com.iliasAtGit.shoppingListProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Order;
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

	@SuppressWarnings("unchecked")
    public List<User> findAllUsers() {
        Criteria criteria = null;
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).addOrder(Order.asc("username"));//To avoid duplicates.
        List<User> users = criteria.list();

        for(User user : users){
            Hibernate.initialize(user.getRoles());
        }
        return users;
    }
}