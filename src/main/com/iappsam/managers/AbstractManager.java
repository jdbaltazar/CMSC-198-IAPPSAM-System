package com.iappsam.managers;

import java.io.Serializable;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public abstract class AbstractManager implements Manager {

	public AbstractManager() {
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
			ex.printStackTrace();
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
			ex.printStackTrace();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	protected void update(Object entity) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			session.merge(entity);
			tx.commit();
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
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
			ex.printStackTrace();
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
			ex.printStackTrace();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("unchecked")
	protected <T> List<T> getList(Class<T> c) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			List<T> list = session.createCriteria(c).list();
			tx.commit();
			return list;
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	protected Object get(Class<?> c, Serializable id) throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();
		try {
			Object result = session.get(c, id);
			tx.commit();
			return result;
		} catch (HibernateException ex) {
			tx.rollback();
			ex.printStackTrace();
			throw new TransactionException(ex.getMessage());
		} finally {
			session.close();
		}
	}

	
	
}
