package com.iappsam.managers.sessions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iappsam.forms.PR;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.PRManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public class PRManagerSession extends AbstractManager implements PRManager {

	@Override
	public void addPR(PR pr) throws TransactionException {
		if (pr.validate())
			add(pr);
	}

	@Override
	public void updatePR(PR pr) throws TransactionException {
		update(pr);
	}

	@Override
	public PR getPR(int id) throws TransactionException {
		return (PR) get(PR.class, id);
	}

	@Override
	public boolean containsPR(PR pr) throws TransactionException {
		return getPR(pr.getId()) != null;
	}

	@Override
	public List<PR> getAllPR() throws TransactionException {
		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();

		List<PR> list = session.createQuery("from PR").list();

		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void removePR(PR pr) throws TransactionException {
		remove(pr);
	}

	@Override
	public PR getPR(PR pr) throws TransactionException {
		return getPR(pr.getId());
	}
}
