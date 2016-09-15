package com.iliasAtGit.helloMVC.dao;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.iliasAtGit.helloMVC.model.Product;
import com.iliasAtGit.helloMVC.model.ShoppingNote;

@Repository
public class ShoppingNoteDao extends GenericDao {

	@PersistenceContext
	private EntityManager em;

	public ShoppingNoteDao() {
		super();
	}

	public void save(ShoppingNote shoppingNote) {
		super.save(shoppingNote);
	}

	public void update(ShoppingNote shoppingNote) {
		em.merge(shoppingNote);
	}

	public void remove(Integer id) {
		ShoppingNote sh = findById(id);
		if (sh == null) {
			System.out.println("Could not find product with id=" + id);
		} else {
			em.remove(sh);
		}
	}

	public ShoppingNote findById(Integer id) {
		System.out.println("Find product with id=" + id);
		return em.find(ShoppingNote.class, id);
	}

	public List<ShoppingNoteUserDisplay> findAll() {
		return em.createNamedQuery("findAllShoppingNote4UserDisplay", ShoppingNoteUserDisplay.class).getResultList();
	}
	
	public List<ShoppingNoteUserDisplay> findActive() {
		return findInShoppingNoteUserDisplay((short)1);//Arrays.asList((short)1)
	}
	
	public List<ShoppingNoteUserDisplay> findDeactivated() {
		return findInShoppingNoteUserDisplay((short)0);
	}
	
	public List<ShoppingNoteUserDisplay> findInShoppingNoteUserDisplay(Short status) {//List<Short> list
		return em.createNamedQuery("findActiveShoppingNote4UserDisplay", ShoppingNoteUserDisplay.class).setParameter("isActive", status).getResultList();
	}

}
