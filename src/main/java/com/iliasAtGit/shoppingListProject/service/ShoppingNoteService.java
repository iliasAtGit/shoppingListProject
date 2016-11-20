package com.iliasAtGit.shoppingListProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iliasAtGit.shoppingListProject.dao.ShoppingNoteDao;
import com.iliasAtGit.shoppingListProject.dao.ShoppingNoteUserDisplay;
import com.iliasAtGit.shoppingListProject.dao.custom.DisplayForUserIdAndName;
import com.iliasAtGit.shoppingListProject.model.ShoppingNote;

@Service
public class ShoppingNoteService {

	@Autowired
	ShoppingNoteDao shoppingNoteDao;

	@Transactional
	public void save(ShoppingNote shoppingNote) {
		shoppingNoteDao.save(shoppingNote);
	}

	@Transactional
	public void update(ShoppingNote shoppingNote) {
		shoppingNoteDao.update(shoppingNote);
	}

	@Transactional
	public void remove(Integer id) {
		shoppingNoteDao.remove(id);
	}

	@Transactional
	public ShoppingNote findById(Integer id) {
		return shoppingNoteDao.findById(id);
	}

	@Transactional
	public ShoppingNote findById(String id) {
		return findById(Integer.parseInt(id));
	}

	// The listAll method only reads the database so we set the @Transactional
	// annotation to read-only for optimisation.
	@Transactional(readOnly = true)
	public List<ShoppingNoteUserDisplay> findAll() {
		return shoppingNoteDao.findAll();
	}
	
	@Transactional(readOnly = true)
	public List<ShoppingNoteUserDisplay> findActive() {
		return shoppingNoteDao.findActive();
	}
}
