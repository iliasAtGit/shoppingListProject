package com.iliasAtGit.shoppingListProject.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iliasAtGit.shoppingListProject.dao.ProductDao;
import com.iliasAtGit.shoppingListProject.dao.custom.ProductForUser;
import com.iliasAtGit.shoppingListProject.model.Product;

@Service
public class ProductService {

	// We use Spring�s @Autowired annotation to have ProductDao component be
	// dependency injected.
	@Autowired
	private ProductDao productDao;

	@Transactional
	public void save(Product product) {
		productDao.save(product);
	}

	// We want to use transactions, so methods annotated with @Transactional
	// Spring annotation.
	@Transactional
	public void saveMassive(Collection<Product> products) {
		for (Product product : products) {
			productDao.save(product);
		}
	}

	@Transactional
	public void update(Product product) {
		productDao.update(product);
	}

	@Transactional
	public void remove(Short id) {
		productDao.remove(id);
	}

	@Transactional
	public Product findById(Short id) {
		return productDao.findById(id);
	}

	@Transactional
	public Product findById(String id) {
		return findById(new Short(id));
	}

	// The listAll method only reads the database so we set the @Transactional
	// annotation to read-only for optimisation.
	@Transactional(readOnly = true)
	public List<Product> findAll() {
		return productDao.findAll();
	}
	@Transactional(readOnly = true)
	public List<ProductForUser> findAll4User() {
		return productDao.findAll4User();
	}
}