package com.iliasAtGit.shoppingListProject.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iliasAtGit.shoppingListProject.dao.ShopDepartmentDao;
import com.iliasAtGit.shoppingListProject.dao.custom.DisplayForUserIdAndName;
import com.iliasAtGit.shoppingListProject.model.ShopDepartment;

@Service
public class ShopDepartmentService {

   // @Resource(name = "sessionFactory")
   // private SessionFactory  sessionFactory;
    
	@Autowired
	private ShopDepartmentDao shopDepartmentDao;

	@Transactional
	public void save(ShopDepartment sd) {
		shopDepartmentDao.save(sd);
	}

	// We want to use transactions, so methods annotated with @Transactional
	// Spring annotation.
	@Transactional
	public void saveMassive(Collection<ShopDepartment> sds) {
		for (ShopDepartment sd : sds) {
			shopDepartmentDao.save(sd);
		}
	}

	@Transactional
	public void update(ShopDepartment sdFromPost) {
		shopDepartmentDao.update(sdFromPost);
        /*final Session session = sessionFactory.getCurrentSession();

        final ShopDepartment existingPerson = (ShopDepartment) session.get(ShopDepartment.class, sdFromPost.getId());

        // set here explicitly what must/can be overwritten by the html form POST
        existingPerson.setName(sdFromPost.getName());

        session.update(existingPerson);*/
	}

	@Transactional
	public void remove(ShopDepartment id) {
		shopDepartmentDao.remove(id);
	}
	
	@Transactional
	public void remove(Short id) {
		shopDepartmentDao.remove(id);
	}

	@Transactional
	public DisplayForUserIdAndName findSDById4userDisplay(Short id) {
		return shopDepartmentDao.findSDById4userDisplay(id);
	}

	@Transactional
	public DisplayForUserIdAndName findSDById4userDisplay(String id) {
		return findSDById4userDisplay(Short.parseShort(id));
	}

	@Transactional(readOnly = true)
	public List<DisplayForUserIdAndName> findAll() {
		return shopDepartmentDao.findSDAll4userDisplay();
	}

}