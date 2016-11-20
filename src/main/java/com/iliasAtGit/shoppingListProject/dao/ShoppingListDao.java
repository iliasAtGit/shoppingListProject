package com.iliasAtGit.shoppingListProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.iliasAtGit.shoppingListProject.model.ShoppingList;

@Repository
public class ShoppingListDao extends GenericDao {

	@PersistenceContext
	private EntityManager em;

	public ShoppingListDao() {
		super();
	}

	public void save(ShoppingList shoppingList) {
		super.save(shoppingList);
	}

	public void update(ShoppingList shoppingList) {
		em.merge(shoppingList);
	}

	public void remove(Short id) {
		List<ShoppingListUserDisplay> sh = findByShopNoteId(id);
		if (sh == null) {
			System.out.println("Could not find shopping list with note id=" + id);
		} else {
			em.remove(sh);
		}
	}


	@Transactional
	public List<ShoppingListUserDisplay> findByShopNoteId(String id) {
		return findByShopNoteId(Short.parseShort(id));
	}

	@SuppressWarnings("unchecked")
    public List<ShoppingListUserDisplay> findByShopNoteId(Short id) {
		return em.createNamedQuery("getShoppingListByNote", ShoppingListUserDisplay.class).setParameter("shoppingNote", id).getResultList();
	}


}
