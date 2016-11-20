package com.iliasAtGit.shoppingListProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iliasAtGit.shoppingListProject.dao.ShoppingListDao;
import com.iliasAtGit.shoppingListProject.dao.ShoppingListUserDisplay;
import com.iliasAtGit.shoppingListProject.model.ShoppingList;

@Service
public class ShoppingListService {

	@Autowired
	ShoppingListDao shoppingListDao;

	@Transactional
	public void save(ShoppingList shoppingList) {
		shoppingListDao.save(shoppingList);
	}

	@Transactional
	public void update(ShoppingList shoppingList) {
		shoppingListDao.update(shoppingList);
	}

	@Transactional
	public void remove(Short id) {
		shoppingListDao.remove(id);
	}

	@Transactional
	public List<ShoppingListUserDisplay> findByShopNoteId(String id) {
		return findByShopNoteId(Short.parseShort(id));
	}
	
	@Transactional(readOnly = true)
	public List<ShoppingListUserDisplay> findByShopNoteId(Short id) {
		return shoppingListDao.findByShopNoteId(id);
	}
}
