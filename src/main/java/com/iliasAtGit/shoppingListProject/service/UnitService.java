package com.iliasAtGit.shoppingListProject.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iliasAtGit.shoppingListProject.dao.ShopDepartmentDao;
import com.iliasAtGit.shoppingListProject.dao.UnitDao;
import com.iliasAtGit.shoppingListProject.dao.custom.ProductForUser;
import com.iliasAtGit.shoppingListProject.model.Product;
import com.iliasAtGit.shoppingListProject.model.Unit;

@Service
public class UnitService {

	// We use Spring�s @Autowired annotation to have ProductDao component be
	// dependency injected.
	@Autowired
	private UnitDao unitDao;

	@Transactional
	public void save(Unit unit) {
		unitDao.save(unit);
	}

	@Transactional
	public void update(Unit unit) {
		unitDao.update(unit);
	}

	@Transactional
	public void remove(Short id) {
		unitDao.remove(id);
	}

	@Transactional
	public Unit findById(Short id) {
		return unitDao.findById(id);
	}

	@Transactional
	public Unit findById(String id) {
		return findById(new Short(id));
	}

	@Transactional(readOnly = true)
	public List<Unit> findAll() {
		return unitDao.findAll();
	}
}