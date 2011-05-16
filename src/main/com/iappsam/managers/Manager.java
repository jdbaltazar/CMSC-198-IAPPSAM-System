package com.iappsam.managers;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public abstract class Manager {

	Session session = HibernateUtil.startSession();

	public Manager() {
		super();
	}

	public void close() {
		session.close();
	}

	protected void add(Object entity) throws TransactionException {
		Transaction tx = session.beginTransaction();
		try {
			session.persist(entity);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		}
	}

	protected Object save(Object entity) throws TransactionException {
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.save(entity);
			tx.commit();
			return o;
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		}
	}

	protected void update(Object entity) throws TransactionException {
		Transaction tx = session.beginTransaction();
		try {
			session.update(entity);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		}
	}

	protected Object get(Class cl, Object primaryKey) throws TransactionException {
		Transaction tx = session.beginTransaction();
		try {
			Object o = session.get(cl, (Serializable) primaryKey);
			tx.commit();
			return o;
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		}
	}

	protected void remove(Object entity) throws TransactionException {
		Transaction tx = session.beginTransaction();
		try {
			session.delete(entity);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		}
	}

	protected boolean contains(Object entity) throws TransactionException {
		Transaction tx = session.beginTransaction();
		try {
			boolean b = session.contains(entity);
			tx.commit();
			return b;
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> getList(Class<T> c) throws TransactionException {
		Transaction tx = session.beginTransaction();
		try {
			List<T> list = session.createCriteria(c).list();
			tx.commit();
			return list;
		} catch (HibernateException ex) {
			tx.rollback();
			throw new TransactionException(ex.getMessage());
		}
	}

}
