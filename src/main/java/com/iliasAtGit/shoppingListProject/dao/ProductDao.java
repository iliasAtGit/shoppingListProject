package com.iliasAtGit.shoppingListProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.iliasAtGit.shoppingListProject.dao.custom.ProductForUser;
import com.iliasAtGit.shoppingListProject.model.Product;

@Repository
public class ProductDao extends GenericDao {


	@PersistenceContext
	private EntityManager em;

	public ProductDao() {
		super();
	}

	public void save(Product product) {
		super.save(product);
	}

	public void update(Product product) {
		em.merge(product);
	}

	public void remove(Short id) {
		Product pr = findById(id);
		if (pr == null) {
			System.out.println("Could not find product with id=" + id);
		} else {
			em.remove(pr);
		}
	}

	public Product findById(Short id) {
		return em.find(Product.class, id);
	}

	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p").getResultList();
	}
	
	public List<ProductForUser> findAll4User() {
		return em.createNamedQuery("findProdAllVisible4userDisplay", ProductForUser.class).getResultList();
	}
}