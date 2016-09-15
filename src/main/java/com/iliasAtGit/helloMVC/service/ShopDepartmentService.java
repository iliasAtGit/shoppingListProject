package com.iliasAtGit.helloMVC.service;

import java.util.Collection;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.iliasAtGit.helloMVC.dao.IdAndNameUserDisplay;
import com.iliasAtGit.helloMVC.dao.ShopDepartmentDao;
import com.iliasAtGit.helloMVC.model.ShopDepartment;

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
	public IdAndNameUserDisplay findById4userDisplay(Short id) {
		return shopDepartmentDao.findById4userDisplay(id);
	}

	@Transactional
	public IdAndNameUserDisplay findById4userDisplay(String id) {
		return findById4userDisplay(Short.parseShort(id));
	}

	@Transactional(readOnly = true)
	public List<IdAndNameUserDisplay> findAll() {
		return shopDepartmentDao.findAll4userDisplay();
	}

}