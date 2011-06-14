package com.iappsam.managers.sessions;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.iappsam.forms.APP;
import com.iappsam.managers.APPManager;
import com.iappsam.managers.AbstractManager;
import com.iappsam.managers.exceptions.TransactionException;
import com.iappsam.util.HibernateUtil;

public class APPManagerSession extends AbstractManager implements APPManager {

	@Override
	public void addAPP(APP annualProcurementPlan) throws TransactionException {
		add(annualProcurementPlan);
	}

	@Override
	public void updateAPP(APP annualProcurementPlan) throws TransactionException {
		update(annualProcurementPlan);
	}

	@Override
	public APP getAPP(int appID) throws TransactionException {
		return (APP) get(APP.class, appID);
	}

	@Override
	public boolean containsAPP(APP app) throws TransactionException {
		return getAPP(app.getId()) != null;
	}

	@Override
	public List<APP> getAllAPP() throws TransactionException {

		Session session = HibernateUtil.startSession();
		Transaction tx = session.beginTransaction();

		List<APP> list = session.createQuery("from AnnualProcurementPlan").list();

		tx.commit();
		session.close();
		return list;
	}

	@Override
	public void removeAPP(APP app) throws TransactionException {
		remove(app);
	}
}
