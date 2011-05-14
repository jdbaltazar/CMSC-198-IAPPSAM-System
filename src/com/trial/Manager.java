package com.trial;

import java.util.List;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public abstract class Manager {
	
	private Session session;

//	protected EntityManager em;

	public Manager() {
		super();
//		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Trial");
//		em = entityManagerFactory.createEntityManager();
		
		session = HibernateUtil.startSession();
		//init session here??????????
	}

	protected void add(Object entity) throws PersistenceException {
//		try {
//			em.persist(entity);
//		} catch (Exception e) {
//			throw new PersistenceException(e.getMessage());
//		}
		Transaction tx = session.beginTransaction();

		try {
			session.persist(entity);
			tx.commit();
			
		} catch (HibernateException ex) {
			tx.rollback();
		}
	}

//	protected <T> T get(Class<T> cl, Object primaryKey) throws PersistenceException {
//		try {
//			return em.find(cl, primaryKey);
//		} catch (Exception e) {
//			throw new PersistenceException(e.getMessage());
//		}
//	}
//
//	protected void remove(Class<?> cl, Object primaryKey) throws PersistenceException {
//		try {
//			Object entity = em.find(cl, primaryKey);
//			if (entity != null)
//				em.remove(entity);
//		} catch (Exception e) {
//			throw new PersistenceException(e.getMessage());
//		}
//	}
//
//	protected boolean contains(Class<?> cl, Object primaryKey) throws PersistenceException {
//		try {
//			Object entity = em.find(cl, primaryKey);
//			return entity != null;
//		} catch (Exception e) {
//			throw new PersistenceException(e.getMessage());
//		}
//	}
//
//	@SuppressWarnings("unchecked")
//	protected <T> List<T> getList(String str, Class<T> T) {
//		Query query = em.createNativeQuery(str, T);
//		return query.getResultList();
//	}
//
//	protected void executeUpdate(String str) {
//		Query query = em.createNativeQuery(str);
//		query.executeUpdate();
//	}
}