package com.iliasAtGit.helloMVC.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

//@Component is Spring annotation that tell the Spring container 
//that we can use this class through Spring IoC (Dependency Injection). 
@Repository
// public abstract class GenericDao<T, ID extends Serializable> {
public abstract class GenericDao {
	// private Class<T> persistentClass;

	// We use JPA’s @PersistenceContext annotation that indicate dependency
	// injection to an EntityManager. Spring injects a proper instance of
	// EntityManager according to the root-context.xml configuration.
	@PersistenceContext
	private EntityManager em;

	/*
	 * @SuppressWarnings("unchecked") public GenericDao() { this.persistentClass
	 * = (Class<T>) ((ParameterizedType)
	 * getClass().getGenericSuperclass()).getActualTypeArguments()[0]; }
	 */

	public <T> void save(final T entity) {
		em.persist(entity);
	}

	public void delete(final Object entity) {
		em.remove(entity);
	}

	public <T> void update(final T entity) {
		em.merge(entity);
	}

	@SuppressWarnings("unchecked")
	// public List<T> findAll() {
	// return em.createQuery("Select t from " + persistentClass.getSimpleName()
	// + " t").getResultList();
	public <T> List<T> getAll(final Class<T> type) {
		return em.createQuery("Select t from " + type.getSimpleName() + " t").getResultList();
	}

	/**
	 * Save an object into the database if it does not exist, else return object
	 * that exists in the database.
	 *
	 * @param query
	 *            query to find object in the database, should only return one
	 *            object.
	 * @param entity
	 *            Object to save or update.
	 * @return Object in the database, whither it was prior or not.
	 * 
	 *         private Object saveOrUpdate(Query query, Object entity) { final
	 *         int NO_RESULT = 0; final int RESULT = 1;
	 * 
	 *         //should return a list of ONE result, // since the query should
	 *         be finding unique objects List results = query.getResultList();
	 *         switch (results.size()) { case NO_RESULT: em.persist(entity);
	 *         return entity; case RESULT: return results.get(0); default: throw
	 *         new NonUniqueResultException("Unexpected query results, " +
	 *         results.size()); }
	 */
	/***/
}
