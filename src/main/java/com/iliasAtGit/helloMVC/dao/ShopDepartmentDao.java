package com.iliasAtGit.helloMVC.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.iliasAtGit.helloMVC.model.ShopDepartment;

//@Component is Spring annotation that tell the Spring container 
//that we can use this class through Spring IoC (Dependency Injection). 
@Repository
public class ShopDepartmentDao extends GenericDao {

//return em.find(ShopDepartment.class, id);
	@PersistenceContext
	private EntityManager em;

	public ShopDepartmentDao() {
		super();
	}

	public void save(ShopDepartment sd) {
		// em.persist(product);
		super.save(sd);
	}

	public void update(ShopDepartment sd) {
		em.merge(sd);
	}

	public void remove(ShopDepartment sd) {
		em.remove(sd);
	}
	public void remove(Short id) {
		/*IdAndNameUserDisplay pr = findById4userDisplay(id);

		if (pr == null) {
			System.out.println("Could not find ShopDepartment with id=" + id);
		} else {
			ShopDepartment sd = em.getReference(ShopDepartment.class, id);
			em.remove(sd);
		}*/
		ShopDepartment sd = null ;
		try {
			sd = em.getReference(ShopDepartment.class, id);// , new Short((short)2));
		}
	    catch (EntityNotFoundException e){

	    } finally {
	    	if (sd != null)
	    		em.remove(sd);
	    }
		
	}

	public IdAndNameUserDisplay findById4userDisplay(Short id) {
		return em.createNamedQuery("findById4userDisplay", IdAndNameUserDisplay.class).setParameter("sdId", id).getSingleResult();
	}

	public List<IdAndNameUserDisplay> findAll4userDisplay() {
		return em.createNamedQuery("findAll4userDisplay", IdAndNameUserDisplay.class).getResultList();
	}

}