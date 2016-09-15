package com.iliasAtGit.helloMVC.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.iliasAtGit.helloMVC.model.Product;

//@Component is Spring annotation that tell the Spring container 
//that we can use this class through Spring IoC (Dependency Injection). 
@Repository
public class ProductDao extends GenericDao {

	// We use JPA’s @PersistenceContext annotation that indicate dependency
	// injection to an EntityManager. Spring injects a proper instance of
	// EntityManager according to the root-context.xml configuration.
	@PersistenceContext
	private EntityManager em;

	public ProductDao() {
		super();
	}

	public void save(Product product) {
		// em.persist(product);
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
		System.out.println("Find product with id=" + id);
		return em.find(Product.class, id);
	}

	public List<Product> findAll() {
		return em.createQuery("SELECT p FROM Product p").getResultList();
	}
	
	public List<Product> findAll4User() {
		return em.createQuery("SELECT p FROM Product p WHERE p.isVisible = 1").getResultList();
	}

}