package com.iliasAtGit.shoppingListProject.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.iliasAtGit.shoppingListProject.dao.custom.DisplayForUserIdAndName;
import com.iliasAtGit.shoppingListProject.model.ShopDepartment;

@Repository
public class ShopDepartmentDao extends GenericDao {

	@PersistenceContext
	private EntityManager em;

	public ShopDepartmentDao() {
		super();
	}

	public void save(ShopDepartment sd) {
		super.save(sd);
	}

	public void update(ShopDepartment sd) {
		em.merge(sd);
	}

	public void remove(ShopDepartment sd) {
		em.remove(sd);
	}
	public void remove(Short id) {
		/*DisplayForUserIdAndName pr = findSDById4userDisplay(id);

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

	public DisplayForUserIdAndName findSDById4userDisplay(Short id) {
		return em.createNamedQuery("findSDById4userDisplay", DisplayForUserIdAndName.class).setParameter("sdId", id).getSingleResult();
	}

	public List<DisplayForUserIdAndName> findSDAll4userDisplay() {
		return em.createNamedQuery("findSDAll4userDisplay", DisplayForUserIdAndName.class).getResultList();
	}

}