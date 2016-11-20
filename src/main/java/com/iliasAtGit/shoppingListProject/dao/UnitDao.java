package com.iliasAtGit.shoppingListProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.iliasAtGit.shoppingListProject.model.Unit;

//@Component is Spring annotation that tell the Spring container 
//that we can use this class through Spring IoC (Dependency Injection). 
@Repository
public class UnitDao extends GenericDao {

	@PersistenceContext
	private EntityManager em;

	public UnitDao() {
		super();
	}

	public void save(Unit unit) {
		// em.persist(product);
		super.save(unit);
	}

	public void update(Unit unit) {
		em.merge(unit);
	}

	public void remove(Short id) {
		Unit pr = findById(id);
		if (pr == null) {
			System.out.println("Could not find product with id=" + id);
		} else {
			em.remove(pr);
		}
	}

	public Unit findById(Short id) {
		System.out.println("Find product with id=" + id);
		return em.find(Unit.class, id);
	}

	public List<Unit> findAll() {
		return em.createQuery("SELECT u FROM Unit u Order By u.name").getResultList();
	}
}