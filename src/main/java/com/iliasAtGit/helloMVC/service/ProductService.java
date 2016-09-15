package com.iliasAtGit.helloMVC.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.iliasAtGit.helloMVC.dao.IdAndNameUserDisplay;
import com.iliasAtGit.helloMVC.dao.ProductDao;
import com.iliasAtGit.helloMVC.dao.ShopDepartmentDao;
import com.iliasAtGit.helloMVC.model.Product;
import com.iliasAtGit.helloMVC.model.ShopDepartment;

@Service
public class ProductService {

	// We use Spring’s @Autowired annotation to have ProductDao component be
	// dependency injected.
	@Autowired
	private ProductDao productDao;
	@Autowired
	private ShopDepartmentDao shopDepartmentDao;

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
	public List<Product> findAll4User() {
		return productDao.findAll4User();
	}
}