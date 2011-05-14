package com.iappsam.managers;

import java.io.Serializable;
import java.util.List;

import javax.persistence.PersistenceException;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public abstract class Manager {

	public Manager() {
		super();
	}

	protected void add(Object entity) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			session.persist(entity);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}
	
	protected Object save(Object entity) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.save(entity);
			tx.commit();
			return o;
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	protected void update(Object entity) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			session.update(entity);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	protected Object get(Class cl, Object primaryKey) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.get(cl, (Serializable) primaryKey);
			tx.commit();
			return o;
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	protected void remove(Object entity) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			session.delete(entity);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	protected boolean contains(Object entity) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			boolean b = session.contains(entity);
			tx.commit();
			return b;
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	protected List getList(String query) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			List objects = session.createCriteria(Object.class).list();
			tx.commit();
			return objects;
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}


}
